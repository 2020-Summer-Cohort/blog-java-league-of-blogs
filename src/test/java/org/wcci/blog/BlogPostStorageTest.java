package org.wcci.blog;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.Mockito.*;


public class BlogPostStorageTest {

    BlogPostRepository blogPostRepo;
    private BlogPostStorage underTest;

    @BeforeEach
    void setUp() {
        blogPostRepo = mock(BlogPostRepository.class);
        underTest = new BlogPostStorage(blogPostRepo);
    }

    @Test
    public void createBlogPostStorage(){
    }

    @Test
    public void findAllBlogs(){
        when(blogPostRepo.findAll()).thenReturn(Collections.EMPTY_LIST);
        Iterable<BlogPost> allPosts = underTest.findAllBlogs();
        assertThat(allPosts).isEmpty();
    }
    @Test
    public void findSpecificBlog(BlogPost blogPost, BlogPostStorage blogStorage){
        BlogPost singlePost = underTest.getSpecificBlog();
        //assertThat(singlePost) = underTest.getSpecificBlog();
    }
}
