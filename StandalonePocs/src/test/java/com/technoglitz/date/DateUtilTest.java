package com.technoglitz.date;

import org.junit.Assert;
import org.junit.Test;

import com.technoglitz.date.DateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtilTest.
 */
public class DateUtilTest {

	/**
	 * Test is pay day.
	 */
	@Test
	public void testIsPayDay(){
		Assert.assertTrue(new DateUtil().isPayDay("9/06/2011"));
	}

	/**
	 * Test negative is pay day.
	 */
	@Test
	public void testNegativeIsPayDay(){
		Assert.assertTrue(!new DateUtil().isPayDay("1/06/2017"));
	}

}
