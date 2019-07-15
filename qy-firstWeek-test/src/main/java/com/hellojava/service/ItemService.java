package com.hellojava.service;

import com.hellojava.entity.Items;
import org.springframework.data.domain.Example;

import java.util.List;

public interface ItemService {
    List<Items> loadAll(Example<Items> of);
    Boolean save(Items items);
    void delete(int id);
    Items loadById(int id);
    Boolean update(Items items);
}
