package org.wcci.blog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private long id;
    private String tag;
    @ManyToMany(mappedBy = "tags")
    Collection<BlogPost> blogs;

    protected Tag (){}

    public Tag(String tag, BlogPost ...blogs){
        this.tag = tag;
        this.blogs = new ArrayList<>(Arrays.asList(blogs));

    }
    public Collection<BlogPost> getBlogs(){
        return blogs;
    }
    public long getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

}
