package com.CoffeeShopCont.Lab24.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CoffeeShopCont.Lab24.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
//	List<Item> findByNameContaining(String keyword); //name is from POJO
//	
//	List<Item> findByCategory(String category);
}
