package com.technoglitz.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.technoglitz.services.rest.OrderController;

/**
 * @author Varun Tamiri
 *
 */
@XmlRootElement(name = "Order")
public class OrderVO implements Serializable { 
	private static final long serialVersionUID = 1047342001435882491L;
	
	/**
	 * 
	 */
	private long orderId;
	/**
	 * 
	 */
	private String orderName;
	/**
	 * 
	 */
	private String client;

	/**
	 * 
	 */
	public OrderVO() {
		setOrderId(OrderController.ATOMICLONG.incrementAndGet());
	}

	/**
	 * @return
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * @param oId
	 */
	public void setOrderId(long oId) {
		this.orderId = oId;
	}

	/**
	 * @return
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	/**
	 * @return
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client
	 */
	public void setClient(String client) {
		this.client = client;
	}
}