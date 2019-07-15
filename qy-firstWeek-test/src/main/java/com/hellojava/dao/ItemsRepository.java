package com.hellojava.dao;

import com.hellojava.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemsRepository extends JpaRepository<Items,Integer> {
}
