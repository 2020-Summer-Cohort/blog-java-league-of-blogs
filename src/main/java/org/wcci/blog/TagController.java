package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class TagController {

    private TagStorage tagStorage;
    private TagRepository tagRepo;
    private BlogPostStorage blogStorage;
    private CategoryRepository categoryRepo;

    public TagController(TagStorage tagStorage, TagRepository tagRepo, BlogPostStorage blogStorage, CategoryRepository categoryRepo) {
        this.tagStorage = tagStorage;
        this.tagRepo = tagRepo;
        this.blogStorage = blogStorage;
        this.categoryRepo = categoryRepo;
    }

    @RequestMapping("tags/{tags}")
    public String displaySingleTag(@PathVariable String tag, Model model){
        model.addAttribute("category", categoryRepo.findAll());
        model.addAttribute("tags", tagStorage.findTagByTag(tag));
        return "tag-template";
    }
}
