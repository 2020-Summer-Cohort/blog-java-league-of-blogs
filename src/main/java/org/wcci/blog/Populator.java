package org.wcci.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    BlogPostRepository blogPostRepo;
    @Autowired
    AuthorRepository authorRepo;

    @Override
    public void run(String... args) throws Exception {
        Category demacia = new Category("Demacia", "Demacia Description");
        Category piltover = new Category("Piltover", "Piltover Description");

        categoryRepo.save(demacia);
        categoryRepo.save(piltover);

        BlogPost lux = new BlogPost("Van", "Demacia", "Luxanna Crownguard", "Lux's Description");
        BlogPost jinx = new BlogPost("Van", "Piltover", "Jinx, The Loose Cannon", "Jinx Description");

        blogPostRepo.save(lux);
        blogPostRepo.save(jinx);

        Author van = new Author("Van");
        authorRepo.save(van);
    }
}