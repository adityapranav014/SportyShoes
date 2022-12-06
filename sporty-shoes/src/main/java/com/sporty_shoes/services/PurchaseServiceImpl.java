package com.sporty_shoes.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty_shoes.entities.Purchase;
import com.sporty_shoes.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository purchaseDao;

	@Override
	public List<Purchase> findByDate(String date) {
		Date dt = null;
		try {
			dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return purchaseDao.findAllByPurchaseDate(dt);
	}

}
//new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-01")