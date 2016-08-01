package com.technoglitz.services.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.technoglitz.hashdb.TmpBuffer;
import com.technoglitz.vo.OrderList;
import com.technoglitz.vo.OrderVO;

/**
 * @author Varun Tamiri
 *
 */
public class OrderController {

	protected final Logger log = LoggerFactory.getLogger(OrderController.class);
	public static AtomicLong ATOMICLONG = new AtomicLong(1);

	/**
	 * @param name
	 * @return
	 */
	@POST
	@Path("/getOrder/{name}")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json", "application/x-www-form-urlencoded" })
	public Response getOrder(@PathParam("name") String name) {
		log.debug("name : " + name);
		OrderVO orderVO = null;
		try {
			orderVO = TmpBuffer.getOrder(URLDecoder.decode(name, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if (orderVO == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(orderVO).build();
		}
	}

	/**
	 * @return
	 */
	@GET
	@Path("/getAll")
	@Produces({ "application/xml", "application/json" })
	public Response getAll() {
		log.info("Inside getAll ");
		OrderList orderVO = new OrderList();
		List<OrderVO> list = new ArrayList<>();
		list.addAll(TmpBuffer.getAll());
		orderVO.setOrderList(list);
		return Response.ok(orderVO).build();
	}

	/**
	 * @param orderName
	 * @param client
	 * @return
	 */
	@POST
	@Path("/addOrder")
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json", "application/x-www-form-urlencoded" })
	public Response addOrder(@FormParam("name") String orderName, @FormParam("client") String client) {
		log.debug("inside add order");
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderName(orderName);
		orderVO.setClient(client);
		TmpBuffer.insertOrder(orderVO);
		if (TmpBuffer.getOrder(orderName) == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		} else {
			return Response.ok(orderVO).build();
		}

	}
}