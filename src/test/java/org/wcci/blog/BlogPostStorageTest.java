package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
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
}
