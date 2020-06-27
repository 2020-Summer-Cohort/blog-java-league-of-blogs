package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.Collections;

public class CategoryControllerTest {

    @Test
    public void categoriesWorksWithRepo(){
        CategoryRepository mockRepo = Mockito.mock(CategoryRepository.class);
        CategoryController underTest = new CategoryController(mockRepo);
        Model mockModel = Mockito.mock(Model.class);

        underTest.displayAllCategories(mockModel);
        Mockito.verify(mockRepo).findAll();
        Mockito.verify(mockModel).addAttribute("categories", Collections.EMPTY_LIST);
    }
}
