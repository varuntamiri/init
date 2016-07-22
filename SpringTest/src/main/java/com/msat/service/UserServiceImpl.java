package com.msat.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.msat.dao.UserDAO;
import com.msat.exception.DataAccessException;
import com.msat.exception.GeneralException;
import com.msat.vo.UserPolicyVO;
import com.msat.vo.UserVO;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
//	@Autowired
//	private LoginDetailHandler detailHandler;

	Logger log = Logger.getLogger(UserServiceImpl.class);
	@Override
	@Transactional(readOnly = true)
	public UserVO getUserDetail(String username) throws GeneralException {
		UserVO user = new UserVO();
		try {
			// log.debug("Thread Local value:"+LoginDetailHandler.getLoginBean().getValue());
			user = userDAO.fetchUserDetails(username);
		} catch (DataAccessException dae) {
			throw new GeneralException(
					"Error occured while performing Database operation");
		}
		return user;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<UserVO> getUserDetailList() throws GeneralException {
		List<UserVO> userList = new ArrayList<UserVO>();
		try {
			userList = userDAO.fetchUserList();
		} catch (DataAccessException dae) {
			throw new GeneralException(
					"Error occured while performing Database operation");
		}
		return userList;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserPolicyVO> getUserPolicyList(String username)
			throws GeneralException {
		List<UserPolicyVO> userPolicyList = new ArrayList<UserPolicyVO>();
		try {
			userPolicyList = userDAO.fetchUserPolicyList(username);
		} catch (DataAccessException dae) {
			throw new GeneralException(
					"Error occured while performing Database operation");
		}
		return userPolicyList;
	}

	@Override
	@Transactional(readOnly = true)
	public UserPolicyVO getUserPolicy(int policyID) throws GeneralException {
		UserPolicyVO userPolicyVO = new UserPolicyVO();
		try {
			userPolicyVO = userDAO.fetchUserPolicy(policyID);
		} catch (DataAccessException dae) {
			throw new GeneralException(
					"Error occured while performing Database operation");
		}
		return userPolicyVO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updatePolicy(UserPolicyVO userPolicy) throws GeneralException {
		try {
			userDAO.updatePolicy(userPolicy);
		} catch (DataAccessException dae) {
			throw new GeneralException(
					"Error occured while performing Database operation");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createPolicy(UserPolicyVO userPolicy) throws GeneralException {
		try {
			userDAO.createPolicy(userPolicy);
		} catch (DataAccessException dae) {
			throw new GeneralException(
					"Error occured while performing Database operation");
		}
	}

}
