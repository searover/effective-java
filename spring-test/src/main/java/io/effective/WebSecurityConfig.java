package io.effective;

import io.effective.service.RestAuthenticationEntryPoint;
import io.effective.service.RestAuthenticationFailureHandler;
import io.effective.service.RestAuthenticationSuccessHandler;
import io.effective.service.RestLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    @Autowired
    private RestLogoutHandler restLogoutHandler;
    @Autowired
    private RestAuthenticationSuccessHandler restAuthenticationSuccessHandler;
    @Autowired
    private RestAuthenticationFailureHandler restAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().failureHandler(restAuthenticationFailureHandler).successHandler(restAuthenticationSuccessHandler)
                .and()
                .logout().defaultLogoutSuccessHandlerFor(restLogoutHandler, new AntPathRequestMatcher("/logout", "POST"))
                .and()
                .requestCache().disable()
        ;
    }

//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return authentication -> {
//            val user = userDetailsService.loadUserByUsername(authentication.getName());
//            val token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
//            return token;
//        };
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.equals(encodedPassword);
            }
        });
    }
}
