package org.wcci.blog;


public class BlogPostController {

    private CategoryRepository categoryRepo;
    private BlogPostStorage blogPostStorage;
    private AuthorRepository authorRepo;
    private TagRepository tagRepo;


    public BlogPostController(CategoryRepository categoryRepo, BlogPostStorage blogPostStorage, AuthorRepository authorRepo, TagRepository tagRepo) {
        this.categoryRepo = categoryRepo;
        this.blogPostStorage = blogPostStorage;
        this.authorRepo = authorRepo;
        this.tagRepo = tagRepo;
    }




}
