package com.dealers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealers.model.Dealer;

public interface DealerRepository extends JpaRepository<Dealer,Integer>{

}
