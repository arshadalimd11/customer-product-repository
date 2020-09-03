package com.dxctraining.customermgt.customer.dto;

public class CreateCustomerRequest {
	
	private String name;
	
	public CreateCustomerRequest() {
		
	}
	public CreateCustomerRequest(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void SetName(String name) {
		this.name=name;
	}

}
