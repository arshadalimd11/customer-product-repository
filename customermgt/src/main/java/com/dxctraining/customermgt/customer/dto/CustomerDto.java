package com.dxctraining.customermgt.customer.dto;

public class CustomerDto {

	private Integer id;
	private String name;
	
	public CustomerDto() {
		
	}
	
	public CustomerDto(Integer id, String name) {
		this.id=id;
		this.name=name;
				
	}
	
	public Integer getId() {
		return id;
	}
	public void SetId(Integer id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void SetName(String name) {
		this.name=name;
	}
}
