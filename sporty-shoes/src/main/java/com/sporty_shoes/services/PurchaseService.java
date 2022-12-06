package com.sporty_shoes.services;

import java.util.List;

import com.sporty_shoes.entities.Purchase;

public interface PurchaseService {

	List<Purchase> findByDate(String date);

}
