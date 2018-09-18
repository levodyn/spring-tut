package com.stef.treehouse.controller;

import com.stef.treehouse.data.CategoryRepository;
import com.stef.treehouse.data.GifRepository;
import com.stef.treehouse.model.Category;
import com.stef.treehouse.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        List<Category> allCategories = categoryRepository.getAllCategories();
        modelMap.put("categories",allCategories);
        return "categories";
    }

    @RequestMapping("/category/{catId}")
    public String category(@PathVariable int catId, ModelMap modelMap) {
        Category category = categoryRepository.findById(catId);
        if(category == null){
            category = categoryRepository.findById(1);
        }

        List<Gif> allGifs = gifRepository.findByCategoryId(catId);
        modelMap.put("gifs",allGifs);
        modelMap.put("category",category);
        return "category";
    }

}
