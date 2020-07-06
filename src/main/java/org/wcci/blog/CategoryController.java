package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;
    private CategoryRepository categoryRepo;
    private TagStorage tagStorage;
    private AuthorStorage authorStorage;
    private BlogPostStorage blogPostStorage;

    public CategoryController(CategoryStorage categoryStorage, CategoryRepository categoryRepo, TagStorage tagStorage, AuthorStorage authorStorage, BlogPostStorage blogPostStorage){
        this.categoryStorage = categoryStorage;
        this.categoryRepo = categoryRepo;
        this.tagStorage = tagStorage;
        this.authorStorage = authorStorage;
        this.blogPostStorage = blogPostStorage;
    }

    @RequestMapping("category/{name}")
    public String displaySingleCategory(@PathVariable String name, Model model){
        model.addAttribute("categories", categoryStorage.findCategoryByName(name));
        model.addAttribute("tags", tagStorage.findAllTags());
        model.addAttribute("blogs", blogPostStorage.findAllBlogs());
        return "category-template";
    }

    @RequestMapping("categories")
    public String displayAllCategories(Model model) {
        model.addAttribute("categories",categoryStorage.getAllCategories());
        model.addAttribute("tags", tagStorage.findAllTags());
        model.addAttribute("authors", authorStorage.findAllAuthors());
        return "homePage-template";
    }

}
