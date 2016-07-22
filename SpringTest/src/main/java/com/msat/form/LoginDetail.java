package com.msat.form;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("loginTarget")
@Scope(value="prototype")
public class LoginDetail {

	/*
	 * private String value;
	 * 
	 * public void setValue(String login) { this.value = login; }
	 * 
	 * public String getValue() { return value; }
	 */
}
