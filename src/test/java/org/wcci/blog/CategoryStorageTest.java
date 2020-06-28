package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class CategoryStorageTest {

    TestEntityManager entityManager;
    private CategoryRepository categoryRepo;

    @Test
    public void createCategoryStorage(){
        CategoryStorage storageTest = new CategoryStorage(categoryRepo);
    }

    @Test
    public void findAllCategories(){
        CategoryStorage storageTest = new CategoryStorage(categoryRepo);
        Category underTest = new Category();
        categoryRepo.save(underTest);

        entityManager.flush();
        entityManager.clear();

        storageTest.getAllCategories();
    }

    @Test
    public void getSpecificCategory(){
        CategoryStorage storageTest = new CategoryStorage(categoryRepo);
        String name = "Demacia";
        storageTest.categoryByName(name);


    }
}
