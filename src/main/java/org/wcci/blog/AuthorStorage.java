package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class AuthorStorage {

    AuthorRepository authorRepo;

    public AuthorStorage(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepo.findAll();
    }

    public Author authorByName(String name) {
        return authorRepo.authorByName(name);
    }
}
