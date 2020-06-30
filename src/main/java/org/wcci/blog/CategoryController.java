package org.wcci.blog;

import org.springframework.ui.Model;

public class CategoryController {

    private CategoryRepository categoryRepo;

    public CategoryController(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public void displayAllCategories(Model model) {
        model.addAttribute("categories",categoryRepo.findAll());
    }

    public void showSingleBlog(String name, Model model) {
       // model.addAttribute("categories",);
    }
}
