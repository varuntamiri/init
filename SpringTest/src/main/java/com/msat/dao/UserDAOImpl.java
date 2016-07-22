package com.msat.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.msat.exception.DataAccessException;
import com.msat.vo.UserPolicyVO;
import com.msat.vo.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public UserVO fetchUserDetails(String strLoginName)
			throws DataAccessException {
		List<UserVO> userList = new ArrayList<UserVO>();
		UserVO userVO = new UserVO();
		try {
			userList = (ArrayList<UserVO>) hibernateTemplate.find(
					"from UserVO user where user.strLoginName=?", strLoginName);
			if (userList.size() > 0) {
				userVO = userList.get(0);
			}
		} catch (DataAccessException dae) {
			throw dae;
		}
		return userVO;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserPolicyVO> fetchUserPolicyList(String strLoginName)
			throws DataAccessException {
		List<UserPolicyVO> userPolicyList = new ArrayList<UserPolicyVO>();
		try {
			userPolicyList = (ArrayList<UserPolicyVO>) hibernateTemplate
					.find("from UserPolicyVO where user.strLoginName=?",
							strLoginName);

		} catch (DataAccessException dae) {
			throw dae;
		}
		return userPolicyList;
	}

	@Override
	public List<UserVO> fetchUserList() throws DataAccessException {
		List<UserVO> userInfoList = new ArrayList<UserVO>();
		try {
			userInfoList = (ArrayList<UserVO>) hibernateTemplate
					.loadAll(UserVO.class);

		} catch (DataAccessException dae) {
			throw dae;
		}
		return userInfoList;
	}

	@Override
	public UserPolicyVO fetchUserPolicy(int policyID)
			throws DataAccessException {
		UserPolicyVO userPolicy = new UserPolicyVO();
		try {
			userPolicy = hibernateTemplate.get(UserPolicyVO.class, policyID);

		} catch (DataAccessException dae) {
			throw dae;
		}
		return userPolicy;
	}

	@Override
	public void createPolicy(UserPolicyVO userPolicy)
			throws DataAccessException {
		try {
			hibernateTemplate.save(userPolicy);
		} catch (DataAccessException dae) {
			throw dae;
		}
	}

	@Override
	public void updatePolicy(UserPolicyVO userPolicy)
			throws DataAccessException {
		try {
			hibernateTemplate.saveOrUpdate(userPolicy);
		} catch (DataAccessException dae) {
			throw dae;
		}
	}

}
