package com.dxctraining.wishlistmgt.wishlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.wishlistmgt.wishlist.dao.IWishlistDao;
import com.dxctraining.wishlistmgt.wishlist.entities.*;
import com.dxctraining.wishlistmgt.wishlist.exceptions.InvalidArgumentException;

import java.util.*;

@Service
public class WishlistServiceImpl implements IWishlistService {
	
	
	@Autowired
	private IWishlistDao dao;
	
	@Override
	public WishedItem save(WishedItem item) {
		
		validate(item);
		 item = dao.save(item);
		 return item;
		
	}
	
	public  void validate( Object obj) {
		if(obj == null) {
			throw new InvalidArgumentException("Wisheditem can not be null");
		}
	}
	
	@Override
	public List<WishedItem> fetchAll(Integer customerId, String productId) {
		
		List<WishedItem> list = dao.fetchAll(customerId, productId);
		return list;
	}
	
	@Override
	public List<WishedItem> findAll() {
		List<WishedItem> list =dao.findAll();
		return list;
	}
	
}
