package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class CategoryStorage {

    private CategoryRepository categoryRepo;

    public CategoryStorage(CategoryRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category findCategoryByName(String name) {
        return categoryRepo.findCategoryByName(name);
    }

    public void save(Category category){
        categoryRepo.save(category);
    }

}
