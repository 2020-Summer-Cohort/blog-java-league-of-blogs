package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Collections;

public class CategoryControllerTest {

    CategoryRepository mockRepo = Mockito.mock(CategoryRepository.class);
    CategoryController underTest = new CategoryController(mockRepo);
    Model mockModel = Mockito.mock(Model.class);
    BlogPost mockBlog = Mockito.mock(BlogPost.class);

    @Test
    public void categoriesWorksWithRepo(){
        underTest.displayAllCategories(mockModel);
        Mockito.verify(mockRepo).findAll();
        Mockito.verify(mockModel).addAttribute("categories", Collections.EMPTY_LIST);
    }
    /*@Test
    public void categoriesReturnsBlog(){
        underTest.showSingleBlog(mockModel);
        Mockito.verify(mockRepo).findById(mockBlog.getId());

    }*/
}
