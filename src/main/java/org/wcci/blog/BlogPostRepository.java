package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostStorage extends CrudRepository<BlogPost, Long> {

    BlogPost blogPostByName(String name);
}
