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
    @Autowired
    TagRepository tagRepo;

    @Override
    public void run(String... args) throws Exception {
        Author van = new Author("Van", "Van's Description");
        Author ban = new Author("Ban", "Ban's Description");
        authorRepo.save(van);
        authorRepo.save(ban);

        Tag mage = new Tag("mage");
        Tag adc = new Tag("adc");

        tagRepo.save(mage);
        tagRepo.save(adc);

        Category demacia = new Category("Demacia", "Demacia Description");
        Category piltover = new Category("Piltover", "Piltover Description");

        categoryRepo.save(demacia);
        categoryRepo.save(piltover);

        BlogPost lux = new BlogPost("lux",van, "Luxanna Crownguard", "Lux's Description", demacia, mage);
        BlogPost jinx = new BlogPost("jinx",van, "Jinx, The Loose Cannon", "Jinx Description", piltover, adc);

        blogPostRepo.save(lux);
        blogPostRepo.save(jinx);



    }
}
