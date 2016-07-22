package com.technoglitz.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Varun Tamiri
 *
 */
@XmlRootElement(name = "OrderList")
public class OrderList {
	/**
	 * 
	 */
	private List<OrderVO> orderList;

	/**
	 * @return
	 */
	public List<OrderVO> getOrderList() {
		if (orderList == null) {
			orderList = new ArrayList<OrderVO>();
		}
		return orderList;
	}

	/**
	 * @param oList
	 */
	public void setOrderList(List<OrderVO> oList) {
		this.orderList = oList;
	}
}