package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogPostController {

    private BlogPostStorage blogPostStorage;
    private CategoryStorage categoryStorage;
    private AuthorStorage authorStorage;
    private TagStorage tagStorage;


    public BlogPostController(BlogPostStorage blogPostStorage, CategoryStorage categoryStorage,  AuthorStorage authorStorage, TagStorage tagStorage) {
        this.blogPostStorage = blogPostStorage;
        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
        this.tagStorage = tagStorage;
    }

    @RequestMapping("blog/{name}")
    public String showSingleBlog (@PathVariable String name, Model model){
        model.addAttribute("Category", categoryStorage.getAllCategories());
        model.addAttribute("BlogPost", blogPostStorage.findBlogPostByName(name));
        model.addAttribute("Author", authorStorage.findByAuthorName(name));
        model.addAttribute("Tag", tagStorage.findAllTags());
        return "blogPost-template";
    }




}
