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

    public Category categoryByName(String name) {
        return categoryRepo.categoryByName(name);
    }

    public void save(Category category){
        categoryRepo.save(category);
    }
}
