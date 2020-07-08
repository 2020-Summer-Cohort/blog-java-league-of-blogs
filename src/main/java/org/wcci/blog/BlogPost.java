package org.wcci.blog;

import javax.persistence.*;
import java.util.*;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Author authorName;
    private String championName;
    private String championDescription;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Tag> tags;

    protected BlogPost(){}

    public BlogPost(String name, Author authorName, String championName, String championDescription, Category category, Tag ...tags) {
        this.name = name;
        this.authorName = authorName;
        this.championName = championName;
        this.championDescription = championDescription;
        this.category = category;
        this.tags = new ArrayList<>(Arrays.asList(tags));
    }

    public String getName() {
        return name;
    }

    public Collection<Tag> getTags() {
        return tags;
    }

    public Author getAuthor() {
        return authorName;
    }

    public Category getCategory() {
        return category;
    }

    public String getChampionDescription() {
        return championDescription;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPost blogPost = (BlogPost) o;
        return Objects.equals(id, blogPost.id) &&
                Objects.equals(name, blogPost.name) &&
                Objects.equals(authorName, blogPost.authorName) &&
                Objects.equals(championName, blogPost.championName) &&
                Objects.equals(championDescription, blogPost.championDescription) &&
                Objects.equals(category, blogPost.category) &&
                Objects.equals(tags, blogPost.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authorName, championName, championDescription, category, tags);
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + authorName +
                ", championName='" + championName + '\'' +
                ", championDescription='" + championDescription + '\'' +
                ", category=" + category +
                ", tags=" + tags +
                '}';
    }
}
