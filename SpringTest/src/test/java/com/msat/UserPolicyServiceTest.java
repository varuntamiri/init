package com.msat;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.msat.service.UserService;
import com.msat.vo.UserPolicyVO;
import com.msat.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-security.xml" })
public class UserPolicyServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testUserDetails() throws Exception {
		UserVO user = userService.getUserDetail("vijay");
		Assert.assertNotNull(user);
		Assert.assertEquals(user.getStrFirstName(), "Vijay");
		Assert.assertEquals(user.getStrUserRole(), "ROLE_ADMIN");
	}

	@Test
	public void testUserDetailList() throws Exception {
		List<UserVO> userList = userService.getUserDetailList();
		Assert.assertNotNull(userList);
		Assert.assertEquals(userList.size(), 3);
	}

	@Test
	public void testUserPolicyList() throws Exception {
		List<UserPolicyVO> userPolicyList = userService.getUserPolicyList("varun");
		Assert.assertNotNull(userPolicyList);
		Assert.assertEquals(userPolicyList.size(), 3);
	}

	@Test
	public void testUserPolicy() throws Exception {
		UserPolicyVO userPolicy = userService.getUserPolicy(1003);
		Assert.assertNotNull(userPolicy);
		Assert.assertEquals(userPolicy.getPolicyName(), "policy3");
		Assert.assertEquals(userPolicy.getPremiumAmount(), 30000.00);
	}
}
