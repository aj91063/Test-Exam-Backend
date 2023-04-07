package com.onexampur.exampur.repository;

import com.onexampur.exampur.model.Quize.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
