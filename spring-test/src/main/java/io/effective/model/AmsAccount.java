package io.effective.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ams_account
 *
 * @mbg.generated do_not_delete_during_merge Fri Jul 13 15:12:35 CST 2018
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AmsAccount {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ams_account.id
	 * @mbg.generated
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ams_account.name
	 * @mbg.generated
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ams_account.allocated
	 * @mbg.generated
	 */
	private Boolean allocated;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ams_account.created_at
	 * @mbg.generated
	 */
	@JsonFormat(timezone = "Asia/Shanghai")
	private Date createdAt;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ams_account.deleted
	 * @mbg.generated
	 */
	@JsonIgnore
	private Boolean deleted;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ams_account.deleted_at
	 * @mbg.generated
	 */
	@JsonIgnore
	private Date deletedAt;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ams_account.id
	 * @return  the value of ams_account.id
	 * @mbg.generated
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ams_account.id
	 * @param id  the value for ams_account.id
	 * @mbg.generated
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ams_account.name
	 * @return  the value of ams_account.name
	 * @mbg.generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ams_account.name
	 * @param name  the value for ams_account.name
	 * @mbg.generated
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ams_account.allocated
	 * @return  the value of ams_account.allocated
	 * @mbg.generated
	 */
	public Boolean getAllocated() {
		return allocated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ams_account.allocated
	 * @param allocated  the value for ams_account.allocated
	 * @mbg.generated
	 */
	public void setAllocated(Boolean allocated) {
		this.allocated = allocated;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ams_account.created_at
	 * @return  the value of ams_account.created_at
	 * @mbg.generated
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ams_account.created_at
	 * @param createdAt  the value for ams_account.created_at
	 * @mbg.generated
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ams_account.deleted
	 * @return  the value of ams_account.deleted
	 * @mbg.generated
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ams_account.deleted
	 * @param deleted  the value for ams_account.deleted
	 * @mbg.generated
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ams_account.deleted_at
	 * @return  the value of ams_account.deleted_at
	 * @mbg.generated
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ams_account.deleted_at
	 * @param deletedAt  the value for ams_account.deleted_at
	 * @mbg.generated
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public AmsAccount() {
    }

    public AmsAccount(Long id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    private String opsUserId;
	private String opsUserName;
	private Boolean isPrimary;

	public String getOpsUserId() {
		return opsUserId;
	}

	public AmsAccount setOpsUserId(String opsUserId) {
		this.opsUserId = opsUserId;
		return this;
	}

	public String getOpsUserName() {
		return opsUserName;
	}

	public AmsAccount setOpsUserName(String opsUserName) {
		this.opsUserName = opsUserName;
		return this;
	}

	public Boolean getPrimary() {
		return isPrimary;
	}

	public AmsAccount setPrimary(Boolean primary) {
		isPrimary = primary;
		return this;
	}
}