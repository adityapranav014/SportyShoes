package com.sporty_shoes.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sporty_shoes.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

	List<Purchase> findAllByPurchaseDate(Date dt);

}
