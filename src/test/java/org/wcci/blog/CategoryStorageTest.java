package org.wcci.blog;

import org.junit.jupiter.api.Test;


public class CategoryStorageTest {

    CategoryRepository categoryRepo;

    @Test
    public void createCategoryStorage(){
        CategoryStorage storageTest = new CategoryStorage(categoryRepo);
    }

    @Test
    public void findAllCategories(){
        CategoryStorage storageTest = new CategoryStorage(categoryRepo);
        Category underTest = new Category("Name of Nation", "Description of Nation" );

        categoryRepo.save(underTest);

        storageTest.getAllCategories();

    }

    @Test
    public void getSpecificCategory(){
        CategoryStorage storageTest = new CategoryStorage(categoryRepo);
        String name = "Demacia";
        storageTest.findCategoryByName(name);


    }
}
