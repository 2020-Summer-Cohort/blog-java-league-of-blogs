package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogPostController {

    private BlogPostStorage blogPostStorage;
    private CategoryRepository categoryRepo;
    private AuthorRepository authorRepo;
    private TagRepository tagRepo;


    public BlogPostController(BlogPostStorage blogPostStorage, CategoryRepository categoryRepo,  AuthorRepository authorRepo, TagRepository tagRepo) {
        this.blogPostStorage = blogPostStorage;
        this.categoryRepo = categoryRepo;
        this.authorRepo = authorRepo;
        this.tagRepo = tagRepo;
    }

    @RequestMapping("blogs/{name}")
    public String showSingleBlog (@PathVariable String name, Model model){
        model.addAttribute("Category", categoryRepo.findAll());
        model.addAttribute("BlogPost", blogPostStorage.findBlogPostByName(name));
        model.addAttribute("Author", authorRepo.findAll());
        model.addAttribute("Tag", tagRepo.findAll());
        return "blogPost-template";
    }




}
