package com.msat.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "POLICY")
public class UserPolicyVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2096006193359248560L;

	@Id
	@Column(name = "POLICY_ID")
	@GeneratedValue
	private int policyID;

	@Column(name = "POLICY_NAME")
	private String policyName;

	@Column(name = "DATE_OF_PREMIUM")
	private Date dateOfpremium;

	@Column(name = "PREMIUM_AMMOUNT")
	private double premiumAmount;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserVO user;

	/**
	 * @return the policyID
	 */
	public int getPolicyID() {
		return policyID;
	}

	/**
	 * @param policyID
	 *            the policyID to set
	 */
	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

	/**
	 * @return the policyName
	 */
	public String getPolicyName() {
		return policyName;
	}

	/**
	 * @param policyName
	 *            the policyName to set
	 */
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	/**
	 * @return the dateOfpremium
	 */
	public Date getDateOfpremium() {
		return dateOfpremium;
	}

	/**
	 * @param dateOfpremium
	 *            the dateOfpremium to set
	 */
	public void setDateOfpremium(Date dateOfpremium) {
		this.dateOfpremium = dateOfpremium;
	}

	/**
	 * @return the premiumAmount
	 */
	public double getPremiumAmount() {
		return premiumAmount;
	}

	/**
	 * @param premiumAmount
	 *            the premiumAmount to set
	 */
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	/**
	 * @return the user
	 */
	public UserVO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserVO user) {
		this.user = user;
	}
	
}