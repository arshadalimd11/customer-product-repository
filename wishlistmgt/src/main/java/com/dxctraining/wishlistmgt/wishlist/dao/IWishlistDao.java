package com.dxctraining.wishlistmgt.wishlist.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dxctraining.wishlistmgt.wishlist.entities.*;

public interface IWishlistDao extends JpaRepository<WishedItem,String> {
	
	@Query("from WishedItem where customerId=:customerId and productId=:productId")
	List<WishedItem> fetchAll(@Param("customerId")Integer customerId, @Param("productId") String productId);
}
