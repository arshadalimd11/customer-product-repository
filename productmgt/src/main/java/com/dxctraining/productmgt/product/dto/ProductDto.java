package com.dxctraining.productmgt.product.dto;

public class ProductDto {

	private String id;
	private String name;
	
	public ProductDto() {
		
	}
	
	public ProductDto(String id, String name) {
		this.id=id;
		this.name=name;
				
	}
	
	public String getId() {
		return id;
	}
	public void SetId(String id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void SetName(String name) {
		this.name=name;
	}
}
