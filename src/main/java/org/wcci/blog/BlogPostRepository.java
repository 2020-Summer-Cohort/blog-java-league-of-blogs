package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

    BlogPost findByName(String name);
}
