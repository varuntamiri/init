package com.msat.service;

import java.util.List;

import com.msat.exception.GeneralException;
import com.msat.vo.UserPolicyVO;
import com.msat.vo.UserVO;

public interface UserService {
	
	public UserVO getUserDetail(String userName) throws GeneralException;

	public List<UserVO> getUserDetailList() throws GeneralException;

	public List<UserPolicyVO> getUserPolicyList(String userName)
			throws GeneralException;

	public UserPolicyVO getUserPolicy(int policyID)
			throws GeneralException;
	
	public void createPolicy(UserPolicyVO userPolicy) throws GeneralException;

	public void updatePolicy(UserPolicyVO userPolicy) throws GeneralException;
}
