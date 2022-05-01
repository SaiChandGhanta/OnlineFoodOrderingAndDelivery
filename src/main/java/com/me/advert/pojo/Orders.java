package com.me.advert.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ElementCollection
	private Map<Pizza,Integer> orderItems = new HashMap<>();
	private String address;
	private String orderAmount;
	private Long userId;
	
	public Map<Pizza, Integer> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Map<Pizza, Integer> orderItems) {
		this.orderItems = orderItems;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Orders() {
	}
	public Orders(Map<Pizza, Integer> orderItems, String address, String orderAmount, Long userId) {
		super();
		this.orderItems = orderItems;
		this.address = address;
		this.orderAmount = orderAmount;
		this.userId = userId;
	}

	
}