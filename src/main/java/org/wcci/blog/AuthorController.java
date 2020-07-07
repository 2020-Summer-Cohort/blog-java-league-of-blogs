package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorStorage authorStorage;
    private AuthorRepository authorRepo;
    private BlogPostStorage blogStorage;

    public AuthorController(AuthorStorage authorStorage, AuthorRepository authorRepo, BlogPostStorage blogStorage) {
        this.authorStorage = authorStorage;
        this.authorRepo = authorRepo;
        this.blogStorage = blogStorage;
    }

    @RequestMapping("author/{name}")
    public String displayAuthor(@PathVariable String name, Model model){
        model.addAttribute(authorStorage.findAuthorByName(name));
        model.addAttribute(blogStorage.findAllBlogs());
        return "author-template";

    }
}
