package com.msat.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msat.form.UserPolicyForm;
import com.msat.service.UserService;
import com.msat.vo.UserPolicyVO;
import com.msat.vo.UserVO;

@Controller
@RequestMapping("/insurance")
public class UserPolicyController {

	protected static Logger logger = Logger.getLogger("UserPolicyController");

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String getCommonPage(Model model) {
		List<UserVO> userList = new ArrayList<UserVO>();
		String strViewPage = "";
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Collection<GrantedAuthority> authList = (Collection<GrantedAuthority>) authentication.getAuthorities();
			if (authList.contains(new GrantedAuthorityImpl("ROLE_ADMIN"))) {
				userList = userService.getUserDetailList();
				model.addAttribute("userList", userList);
				strViewPage = "/admin/userspage";
			} else {
				strViewPage = "/user/policy";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strViewPage;
	}

	@RequestMapping(value = "/viewpolicy", method = RequestMethod.GET)
	public String getUserPolicies(Model model) {
		logger.debug("Received request to show User policy page");
		List<UserPolicyVO> userPolicyList = new ArrayList<UserPolicyVO>();
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			userPolicyList = userService.getUserPolicyList(authentication.getName());
			model.addAttribute("userPolicyList", userPolicyList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/policiespage";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPolicy(Model model) {
		logger.debug("Received request to show Add policy page");

		UserPolicyForm userPolicy = new UserPolicyForm();
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			userPolicy.setUser(userService.getUserDetail(authentication.getName()));
			model.addAttribute("userPolicy", userPolicy);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/addpolicy";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPolicy(
			@Valid @ModelAttribute("userPolicy") UserPolicyForm userPolicy,
			BindingResult result, Model model) {
		logger.debug("Received request to Add policy into database");
		String strViewPage = "";
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			userPolicy.setUser((UserVO) authentication.getDetails());
			if(result.hasErrors())
			{
				strViewPage =  "/user/addpolicy"; 
			} else
			{
				userService.createPolicy(convertFormToVO(userPolicy));
				strViewPage = "/user/success";
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strViewPage;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPolicy(@PathVariable Integer id, Model model) {
		logger.debug("Received request to show Edit policy page");

		UserPolicyVO userPolicy = new UserPolicyVO();
		try {
			userPolicy = userService.getUserPolicy(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("userPolicy", convertVOToForm(userPolicy));
		return "/user/editpolicy";
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editPolicy(
			@Valid @ModelAttribute("userPolicy") UserPolicyForm userPolicy,
			BindingResult result, Model model) {
		logger.debug("Received request to Edit policy into database");
		String strViewPage = "";
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			userPolicy.setUser(userService.getUserDetail(authentication.getName()));
			if(result.hasErrors())
			{
				strViewPage =  "/user/editpolicy"; 
			} else
			{
				userService.updatePolicy(convertFormToVO(userPolicy));
				strViewPage = "/user/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strViewPage;
	}

	private UserPolicyVO convertFormToVO(UserPolicyForm userPolicy) {
		UserPolicyVO userPolicyVO = new UserPolicyVO();
		userPolicyVO.setPolicyID(userPolicy.getPolicyID());
		userPolicyVO.setPolicyName(userPolicy.getStrPolicyName());
		userPolicyVO.setPremiumAmount(userPolicy.getPremiumAmount());
		userPolicyVO.setDateOfpremium(userPolicy.getDateOfpremium());
		userPolicyVO.setUser(userPolicy.getUser());
		return userPolicyVO;
	}

	private UserPolicyForm convertVOToForm(UserPolicyVO userPolicyVO) {
		UserPolicyForm userPolicy = new UserPolicyForm();
		userPolicy.setPolicyID(userPolicyVO.getPolicyID());
		userPolicy.setStrPolicyName(userPolicyVO.getPolicyName());
		userPolicy.setPremiumAmount(userPolicyVO.getPremiumAmount());
		userPolicy.setDateOfpremium(userPolicyVO.getDateOfpremium());
		userPolicy.setStrDateOfpremium(convertDateToString(userPolicyVO
				.getDateOfpremium()));
		userPolicy.setUser(userPolicyVO.getUser());
		return userPolicy;
	}

	private String convertDateToString(Date date) {
		return dateFormat.format(date);
	}

}
