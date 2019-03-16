package io.effective.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class MyCustomRealm extends JdbcRealm {
    private Map<String, String> credentials = new HashMap<>();
    private Map<String, Set<String>> roles = new HashMap<>();
    private Map<String, Set<String>> perm = new HashMap<>();

    {
        credentials.put("user", "password");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");

        roles.put("user", new HashSet<>(Collections.singletonList("admin")));
        roles.put("user2", new HashSet<>(Collections.singletonList("editor")));
        roles.put("user3", new HashSet<>(Collections.singletonList("author")));

        perm.put("admin", new HashSet<>(Collections.singletonList("*")));
        perm.put("editor", new HashSet<>(Collections.singletonList("articles:*")));
        perm.put("author", new HashSet<>(Arrays.asList("articles:compose", "articles:save")));
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        if (uToken.getUsername() == null || uToken.getUsername().isEmpty() || !credentials.containsKey(uToken.getUsername()))
            throw new UnknownAccountException("Username not found.");
        return new SimpleAuthenticationInfo(uToken.getUsername(), credentials.get(uToken.getUsername()), ByteSource.Util.bytes("salt"), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roleNames = new HashSet<>();
        Set<String> permissions = new HashSet<>();

        for (Object p : principals) {
            try {
                Set<String> roles = getRoleNamesForUser(null, (String) p);
                roleNames.addAll(roles);
                permissions.addAll(getPermissions(null, null, roles));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected Set<String> getRoleNamesForUser(Connection conn, String username) throws SQLException {
        if (!roles.containsKey(username))
            throw new SQLException("username not found!");
        return roles.get(username);
    }

    @Override
    protected Set<String> getPermissions(Connection conn, String username, Collection<String> roleNames) throws SQLException {
        for (String roleName : roleNames) {
            if (!perm.containsKey(roleName))
                throw new SQLException("role not found.");
        }
        Set<String> finalSet = new HashSet<>();
        for (String role : roleNames) {
            finalSet.addAll(perm.get(role));
        }
        return finalSet;
    }
}
