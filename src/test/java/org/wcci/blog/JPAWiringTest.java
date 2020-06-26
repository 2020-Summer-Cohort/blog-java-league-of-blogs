package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {
    @Autowired
    CategoryRepository categoryRepo;
    @Autowired
    BlogPostRepository blogPostRepo;
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void reviewsShouldHaveACategory(){
        Category testCategory = new Category("Name of Nation", "Description of Nation");
        BlogPost testBlog = new BlogPost("Van","Luxanna Crownguard", "Lux's Description", "Demacia");
        categoryRepo.save(testCategory);
        blogPostRepo.save(testBlog);

        entityManager.flush();
        entityManager.clear();

        BlogPost retrieveBlogPost = blogPostRepo.findById(testBlog.getId()).get();
        Category retrieveCategory = categoryRepo.findById(testCategory.getId()).get();

        assertThat(retrieveBlogPost).isEqualTo(testBlog);
        assertThat(retrieveCategory.getBlogPost()).containsExactly(testBlog);




    }


}
