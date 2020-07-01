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
    private Author author;
    private String championName;
    private String championDescription;
    @ManyToOne
    private Category category;
    @ManyToMany
    private Collection<Tag> tags;

    protected BlogPost(){}

    public BlogPost(String name, Author author, String championName, String championDescription, Category category, Tag ...tags) {
        this.name = name;
        this.author = author;
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
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public String getChampionName() {
        return championName;
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
                Objects.equals(author, blogPost.author) &&
                Objects.equals(championName, blogPost.championName) &&
                Objects.equals(championDescription, blogPost.championDescription) &&
                Objects.equals(category, blogPost.category) &&
                Objects.equals(tags, blogPost.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, championName, championDescription, category, tags);
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author=" + author +
                ", championName='" + championName + '\'' +
                ", championDescription='" + championDescription + '\'' +
                ", category=" + category +
                ", tags=" + tags +
                '}';
    }
}
