package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

    Tag findTagByTag(String tag);

    Tag findTagById(Long id);
}
