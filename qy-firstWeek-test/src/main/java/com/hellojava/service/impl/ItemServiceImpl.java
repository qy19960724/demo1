package com.hellojava.service.impl;

import com.hellojava.dao.ItemsRepository;
import com.hellojava.entity.Items;
import com.hellojava.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemsRepository itemsRepository;
    @Override
    public List<Items> loadAll(Example<Items> of) {
        return itemsRepository.findAll(of);
    }

    @Override
    public Boolean save(Items items) {
        Items save = itemsRepository.save(items);
        return save!=null?true:false;
    }

    @Override
    public void delete(int id) {
        itemsRepository.deleteById(id);
    }

    @Override
    public Items loadById(int id) {
        Optional<Items> byId = itemsRepository.findById(id);
        Items b = null;
        if(byId.isPresent()){
            b = byId.get();
        }
        return b;
    }

    @Override
    public Boolean update(Items items) {
        Items book1 = itemsRepository.saveAndFlush(items);
        boolean b = false;
        if (book1!=null){
            b = true;
        }
        return b;
    }
}
