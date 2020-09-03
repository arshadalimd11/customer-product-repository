package com.dxctraining.wishlistmgt.wishlist.dto;

public class WishedItemDto {
	
	private String id;
	private Integer customerId;
	private String productId;
	private String productName;
	private String customerName;
	
	public WishedItemDto() {	
	}
	
	  public WishedItemDto(String id){
	        this.id=id;
	    }
	  
	  public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}
		
		public String getProductId() {
			return productId;
		}

		public void setProductId(String productId) {
			this.productId = productId;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
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
