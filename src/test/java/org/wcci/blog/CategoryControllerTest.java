package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Collections;

public class CategoryControllerTest {

    CategoryRepository mockRepo = Mockito.mock(CategoryRepository.class);
    CategoryStorage mockStorage = Mockito.mock(CategoryStorage.class);
    TagStorage mockTagStorage = Mockito.mock(TagStorage.class);
    AuthorStorage mockAuthorStorage = Mockito.mock(AuthorStorage.class);
    BlogPostStorage mockBlogPostStorage = Mockito.mock(BlogPostStorage.class);
    CategoryController underTest = new CategoryController(mockStorage, mockRepo, mockTagStorage, mockAuthorStorage, mockBlogPostStorage);
    Model mockModel = Mockito.mock(Model.class);
    BlogPost mockBlog = Mockito.mock(BlogPost.class);

    @Test
    public void categoriesWorksWithRepo(){
        underTest.displayAllCategories(mockModel);
        Mockito.verify(mockRepo).findAll();
        Mockito.verify(mockModel).addAttribute("categories", Collections.EMPTY_LIST);
    }
}
