package io.effective.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "`ams_account`")
public class AmsAccount implements Serializable {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Long id;

    @Column(name = "`name`")
    private String name;

    @Column(name = "`allocated`")
    private Boolean allocated;

    @Column(name = "`created_at`")
    private Date createdAt;

    @Column(name = "`deleted`")
    private Boolean deleted;

    @Column(name = "`deleted_at`")
    private Date deletedAt;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String NAME = "name";

    public static final String DB_NAME = "name";

    public static final String ALLOCATED = "allocated";

    public static final String DB_ALLOCATED = "allocated";

    public static final String CREATED_AT = "createdAt";

    public static final String DB_CREATED_AT = "created_at";

    public static final String DELETED = "deleted";

    public static final String DB_DELETED = "deleted";

    public static final String DELETED_AT = "deletedAt";

    public static final String DB_DELETED_AT = "deleted_at";

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return allocated
     */
    public Boolean getAllocated() {
        return allocated;
    }

    /**
     * @param allocated
     */
    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
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
     * @return deleted_at
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * @param deletedAt
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", allocated=").append(allocated);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deleted=").append(deleted);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}