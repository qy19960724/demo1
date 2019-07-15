package com.hellojava.controller;


import com.hellojava.entity.Items;
import com.hellojava.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "save")
    public String saveView() {
        return "save";
    }

    @RequestMapping("index")
    public String loadAll(Model model,
                          @RequestParam(required = false) String nameResult,
                          @RequestParam(required = false) String detailResult){
        Items items = new Items();
        if (nameResult!=null && nameResult!="") {
            items.setName(nameResult.trim());
        }
        if (detailResult!=null && detailResult!="") {
            items.setDetail(detailResult.trim());
        }
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact())
                                                                 .withMatcher("detail", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Items> of = Example.of(items, exampleMatcher);
        List<Items> list =  itemService.loadAll(of);
        model.addAttribute("nameResult", nameResult);
        model.addAttribute("detailResult", detailResult);
        model.addAttribute("list",list);
        return "index";
    }

    @RequestMapping("add")
    public String add(Items items){
        Boolean save = itemService.save(items);
        return save?"redirect:index" : "error";
    }

    @RequestMapping("delete")
    public String delete(int id){
        itemService.delete(id);
        return "redirect:index";
    }

    //查询需要修改的信息
    @RequestMapping(value = "loadById")
    public String loadById(Model model, int id) {
        Items items = itemService.loadById(id);
        model.addAttribute("items", items);
        return "update";
    }

    //修改信息
    @RequestMapping(value = "update")
    public String update(Items items) {
        boolean b = itemService.update(items);
        System.out.println(items);
        return b ? "redirect:index" : "error";
    }
}
