package com.msat.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.msat.vo.UserVO;

public class UserPolicyForm {

	private int policyID;

	@NotEmpty(message = "Policy Name Cannot be Null")
	@Size(min = 1, max = 25, message = "Policy Name must between 1 to 25 Characters.")
	private String strPolicyName;

	private Date dateOfpremium;

	@NotNull(message = "Premium Amount cannot be Empty")
	@NumberFormat(style = Style.NUMBER)
	private Double premiumAmount;

	@NotEmpty(message = "Date cannot be Empty")
	private String strDateOfpremium;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
	 * @return the dateOfpremium
	 */
	public Date getDateOfpremium() {
		try {
			dateOfpremium = dateFormat.parse(getStrDateOfpremium());
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
	 * @return the strPolicyName
	 */
	public String getStrPolicyName() {
		return strPolicyName;
	}

	/**
	 * @param strPolicyName
	 *            the strPolicyName to set
	 */
	public void setStrPolicyName(String strPolicyName) {
		this.strPolicyName = strPolicyName;
	}

	/**
	 * @return the user
	 */
	public UserVO getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserVO user) {
		this.user = user;
	}

	/**
	 * @return the strDateOfpremium
	 */
	public String getStrDateOfpremium() {
		return strDateOfpremium;
	}

	/**
	 * @param strDateOfpremium
	 *            the strDateOfpremium to set
	 */
	public void setStrDateOfpremium(String strDateOfpremium) {
		this.strDateOfpremium = strDateOfpremium;
	}

	/**
	 * @return the premiumAmount
	 */
	public Double getPremiumAmount() {
		return premiumAmount;
	}

	/**
	 * @param premiumAmount the premiumAmount to set
	 */
	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	
	

}
