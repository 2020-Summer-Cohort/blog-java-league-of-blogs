package org.wcci.blog;

public class BlogPostStorage {

    BlogPostRepository blogPostRepo;

    public BlogPostStorage(BlogPostRepository blogPostRepo) {
        this.blogPostRepo = blogPostRepo;
    }

    public void save(BlogPost blogPost) {
        blogPostRepo.save(blogPost);
    }

    public Iterable<BlogPost> findAllBlogs() {
        return blogPostRepo.findAll();
    }
}
