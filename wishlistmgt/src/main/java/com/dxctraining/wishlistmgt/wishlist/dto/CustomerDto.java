package com.dxctraining.wishlistmgt.wishlist.dto;

public class CustomerDto {
	
	private Integer customerId;
	private String customerName;
	
	public CustomerDto( ) {
		
	}
	
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
