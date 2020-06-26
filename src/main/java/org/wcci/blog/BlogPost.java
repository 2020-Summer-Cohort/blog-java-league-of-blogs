package org.wcci.blog;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String championName;
    private String championDescription;
    private String nation;
    @ManyToOne
    private Category category;

    protected BlogPost(){}

    public BlogPost(String author, String nation, String championName, String championDescription) {
        this.author = author;
        this.nation = nation;
        this.championName = championName;
        this.championDescription = championDescription;
    }

    public String getChampionName() {
        return championName;
    }

    public String getChampionDescription() {
        return championDescription;
    }

    public String getAuthor() {
        return author;
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
                Objects.equals(author, blogPost.author) &&
                Objects.equals(championName, blogPost.championName) &&
                Objects.equals(championDescription, blogPost.championDescription) &&
                Objects.equals(category, blogPost.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, championName, championDescription, category);
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", championName='" + championName + '\'' +
                ", championDescription='" + championDescription + '\'' +
                ", category=" + category +
                '}';
    }
}
