package com.dxctraining.wishlistmgt.wishlist.util;
import com.dxctraining.wishlistmgt.wishlist.dto.WishedItemDto;
import com.dxctraining.wishlistmgt.wishlist.entities.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class WishlistUtil {

	public WishedItemDto wishedListDto(WishedItem wishedItem, String productId, String productName, Integer customerId, String customerName) {
		WishedItemDto dto = new WishedItemDto(wishedItem.getId());
		dto.setProductId(productId);
		dto.setProductName(productName);
		dto.setCustomerId(customerId);
		dto.setCustomerName(customerName);
		return dto;
	}
}