package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class TagStorage {

    TagRepository tagRepo;

    public TagStorage(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }

    public Iterable<Tag> findAllTags() {
        return tagRepo.findAll();
    }
    public Tag findTagByTag (String tag){
        return tagRepo.findTagByTag(tag);
    }
    public void save (Tag tag){
        tagRepo.save(tag);
    }
    public Tag tagById (Long id){
        return tagRepo.findTagById(id);
    }

}
