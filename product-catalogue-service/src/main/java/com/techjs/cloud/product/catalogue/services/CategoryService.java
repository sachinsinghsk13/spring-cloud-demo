package com.techjs.cloud.product.catalogue.services;

import com.techjs.cloud.product.catalogue.entities.Category;
import com.techjs.cloud.product.catalogue.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category create(Category c) {
        return repository.save(c);
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getById(Integer id) {
        return repository.findById(id);
    }

    public Category update(Integer id, Category c) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(c.getName());
                    existing.setDescription(c.getDescription());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
