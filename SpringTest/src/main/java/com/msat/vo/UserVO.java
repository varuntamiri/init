package com.msat.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER")
public class UserVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7948631485788342175L;

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private int userID;
	
	@Column(name = "USER_PWD", nullable = false)
	private String strUserPwd;
	
	@Column(name = "LOGIN_NAME", nullable = false)
	private String strLoginName;
	
	@Column(name = "FIRST_NAME")
	private String strFirstName;
	
	@Column(name = "LAST_NAME")
	private String strLastName;
	
	@Column(name = "USER_ROLE", nullable = false)
	private String strUserRole;
	
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(name = "UPDATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	// @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @JoinColumn(table = "policy")
	@OneToMany(mappedBy = "user")
	private Set<UserPolicyVO> userPolicies;

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the strUserPwd
	 */
	public String getStrUserPwd() {
		return strUserPwd;
	}

	/**
	 * @param strUserPwd the strUserPwd to set
	 */
	public void setStrUserPwd(String strUserPwd) {
		this.strUserPwd = strUserPwd;
	}

	/**
	 * @return the strFirstName
	 */
	public String getStrFirstName() {
		return strFirstName;
	}

	/**
	 * @param strFirstName the strFirstName to set
	 */
	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	/**
	 * @return the strLastName
	 */
	public String getStrLastName() {
		return strLastName;
	}

	/**
	 * @param strLastName the strLastName to set
	 */
	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	/**
	 * @return the strUserRole
	 */
	public String getStrUserRole() {
		return strUserRole;
	}

	/**
	 * @param strUserRole the strUserRole to set
	 */
	public void setStrUserRole(String strUserRole) {
		this.strUserRole = strUserRole;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the userPolicies
	 */
	public Set<UserPolicyVO> getUserPolicies() {
		return userPolicies;
	}

	/**
	 * @param userPolicies the userPolicies to set
	 */
	public void setUserPolicies(Set<UserPolicyVO> userPolicies) {
		this.userPolicies = userPolicies;
	}

	/**
	 * @return the strLoginName
	 */
	public String getStrLoginName() {
		return strLoginName;
	}

	/**
	 * @param strLoginName the strLoginName to set
	 */
	public void setStrLoginName(String strLoginName) {
		this.strLoginName = strLoginName;
	}	
}
