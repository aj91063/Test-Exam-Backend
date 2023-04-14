package com.onexampur.exampur.servises;

import com.onexampur.exampur.model.Quize.Category;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);
    public Category updateCategory(Category category);

    public Set<Category> getCategories();

    public Category getCategory(Long categoryId);

    Category getCategoryByTitle(String title);

    public  void deleteCategory(Long categoryId);

}
