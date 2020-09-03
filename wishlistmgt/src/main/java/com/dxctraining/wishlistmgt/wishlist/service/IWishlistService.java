package com.dxctraining.wishlistmgt.wishlist.service;
import java.util.*;
import com.dxctraining.wishlistmgt.wishlist.entities.*;

public interface IWishlistService {
	
	WishedItem save(WishedItem item);
	List<WishedItem> fetchAll(Integer customerId, String productId);
	List<WishedItem> findAll();
}
