package com.sporty_shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sporty_shoes.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

	Admin findByEmail(String email);
}
