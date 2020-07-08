package org.wcci.blog;

import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String authorName;
    @OneToMany(mappedBy = "authorName")
    private Collection<BlogPost> blogPost;
    private String description;

    protected Author(){}

    public Author(String authorName, String description) {
        this.authorName = authorName;
        this.description = description;
    }

    public String getName() {
        return authorName;
    }
    public String getDescription(){
        return description;
    }
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + authorName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(authorName, author.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, authorName);
    }
}
