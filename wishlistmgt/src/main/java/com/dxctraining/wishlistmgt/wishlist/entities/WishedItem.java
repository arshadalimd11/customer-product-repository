package com.dxctraining.wishlistmgt.wishlist.entities;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Wishlist details")
public class WishedItem {
	@Id
	@GeneratedValue
	private String id;
	private Integer customerId;
	private String productId;
	
	public WishedItem() {
		
	}
	
	public WishedItem(Integer customerId, String productId) {
		this.customerId=customerId;
		this.productId=productId;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Integer customerId) {
		this.customerId=customerId;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId=productId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if((obj == null) || getClass()!= obj.getClass()) {
			return false;
		}
		
		WishedItem wishedItem =(WishedItem) obj;
		return Objects.equals(id, wishedItem.id );
	}
	
	
	
}
