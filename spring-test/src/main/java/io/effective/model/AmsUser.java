package io.effective.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "`ams_user`")
public class AmsUser implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private String id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`srn`")
    private String srn;

    @Column(name = "`root`")
    private Boolean root;

    @Column(name = "`account_id`")
    private Long accountId;

    @Column(name = "`mobile`")
    private String mobile;

    @Column(name = "`email`")
    private String email;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`password_reset`")
    private Boolean passwordReset;

    @Column(name = "`description`")
    private String description;

    @Column(name = "`created_at`")
    private Date createdAt;

    @Column(name = "`created_by`")
    private String createdBy;

    @Column(name = "`updated_at`")
    private Date updatedAt;

    @Column(name = "`updated_by`")
    private String updatedBy;

    @Column(name = "`deleted`")
    private Boolean deleted;

    @Column(name = "`secret_key`")
    private byte[] secretKey;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String NAME = "name";

    public static final String DB_NAME = "name";

    public static final String SRN = "srn";

    public static final String DB_SRN = "srn";

    public static final String ROOT = "root";

    public static final String DB_ROOT = "root";

    public static final String ACCOUNT_ID = "accountId";

    public static final String DB_ACCOUNT_ID = "account_id";

    public static final String MOBILE = "mobile";

    public static final String DB_MOBILE = "mobile";

    public static final String EMAIL = "email";

    public static final String DB_EMAIL = "email";

    public static final String PASSWORD = "password";

    public static final String DB_PASSWORD = "password";

    public static final String PASSWORD_RESET = "passwordReset";

    public static final String DB_PASSWORD_RESET = "password_reset";

    public static final String DESCRIPTION = "description";

    public static final String DB_DESCRIPTION = "description";

    public static final String CREATED_AT = "createdAt";

    public static final String DB_CREATED_AT = "created_at";

    public static final String CREATED_BY = "createdBy";

    public static final String DB_CREATED_BY = "created_by";

    public static final String UPDATED_AT = "updatedAt";

    public static final String DB_UPDATED_AT = "updated_at";

    public static final String UPDATED_BY = "updatedBy";

    public static final String DB_UPDATED_BY = "updated_by";

    public static final String DELETED = "deleted";

    public static final String DB_DELETED = "deleted";

    public static final String SECRET_KEY = "secretKey";

    public static final String DB_SECRET_KEY = "secret_key";

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return srn
     */
    public String getSrn() {
        return srn;
    }

    /**
     * @param srn
     */
    public void setSrn(String srn) {
        this.srn = srn == null ? null : srn.trim();
    }

    /**
     * @return root
     */
    public Boolean getRoot() {
        return root;
    }

    /**
     * @param root
     */
    public void setRoot(Boolean root) {
        this.root = root;
    }

    /**
     * @return account_id
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * @param accountId
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return password_reset
     */
    public Boolean getPasswordReset() {
        return passwordReset;
    }

    /**
     * @param passwordReset
     */
    public void setPasswordReset(Boolean passwordReset) {
        this.passwordReset = passwordReset;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return created_by
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * @return updated_at
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return updated_by
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * @return deleted
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * @param deleted
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * @return secret_key
     */
    public byte[] getSecretKey() {
        return secretKey;
    }

    /**
     * @param secretKey
     */
    public void setSecretKey(byte[] secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", srn=").append(srn);
        sb.append(", root=").append(root);
        sb.append(", accountId=").append(accountId);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", passwordReset=").append(passwordReset);
        sb.append(", description=").append(description);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", deleted=").append(deleted);
        sb.append(", secretKey=").append(secretKey);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}