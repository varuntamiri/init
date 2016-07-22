package com.msat.dao;

import java.util.List;

import com.msat.exception.DataAccessException;
import com.msat.vo.UserPolicyVO;
import com.msat.vo.UserVO;

public interface UserDAO {

	public UserVO fetchUserDetails(String strLoginName)throws DataAccessException;
	
	public List<UserVO> fetchUserList()throws DataAccessException;
	
	public List<UserPolicyVO> fetchUserPolicyList(String strLoginName)throws DataAccessException;
	
	public UserPolicyVO fetchUserPolicy(int policyID)throws DataAccessException;
	
	public void createPolicy(UserPolicyVO userPolicy)throws DataAccessException;
	
	public void updatePolicy(UserPolicyVO userPolicy)throws DataAccessException;
}