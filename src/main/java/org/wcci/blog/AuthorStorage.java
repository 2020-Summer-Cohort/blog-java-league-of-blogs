package org.wcci.blog;

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
