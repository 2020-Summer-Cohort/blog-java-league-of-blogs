package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorStorage authorStorage;
    private AuthorRepository authorRepo;
    private BlogPostRepository blogRepo;

    public AuthorController(AuthorStorage authorStorage, AuthorRepository authorRepo, BlogPostRepository blogRepo) {
        this.authorStorage = authorStorage;
        this.authorRepo = authorRepo;
        this.blogRepo = blogRepo;
    }

    @RequestMapping("author/{name}")
    public String displayAuthor(@PathVariable String name, Model model){
        model.addAttribute(authorStorage.authorByName(name));
        return "author-template";

    }
}
