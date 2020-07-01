package org.wcci.blog;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class CategoryController {

    private CategoryStorage categoryStorage;
    private CategoryRepository categoryRepo;

    public CategoryController(CategoryStorage categoryStorage, CategoryRepository categoryRepo){
        this.categoryStorage = categoryStorage;
        this.categoryRepo = categoryRepo;
    }

    @RequestMapping("Category/{name}")
    public String displaySingleCategory(@PathVariable String name, Model model){
        model.addAttribute("categories", categoryStorage.categoryByName(name));
        return "Category-template";
    }

    @RequestMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("categories",categoryStorage.getAllCategories());
        return "HomePage-template";
    }

}
