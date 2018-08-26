package com.CoffeeShopCont.Lab24.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.CoffeeShopCont.Lab24.entity.Item;

@Repository
@Transactional
public class ItemDao {

	@PersistenceContext
	private EntityManager em;
	

	//return Food
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
	
	public List<Item> findAll(){
		
		//the select clause is optional in HQL. if omitted, it's like using SELECT *
		//when creating the query we must specify the type of resuls : Food.class
		return em.createQuery("FROM Item",Item.class).getResultList();
				
}
}
