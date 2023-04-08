package com.onexampur.exampur.controller;


import com.onexampur.exampur.model.Quize.Category;
import com.onexampur.exampur.servises.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    /*Save Category*/
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        final Category saveCategory = this.categoryService.addCategory(category);
        return ResponseEntity.ok(saveCategory);
    }

    /* Get only one Category
    * using categoryId
     */
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategory(@PathVariable(value = "categoryId",required = true) Long categoryId){
        final Category getCategory = this.categoryService.getCategory(categoryId);
        return ResponseEntity.ok(getCategory);
    }

    /* Get all Categories */

    @GetMapping("/allCategories")
    public ResponseEntity<?> getAllCategories(){
        return ResponseEntity.ok(this.categoryService.getCategories());
    }


    /* Update category */
    @PutMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(this.categoryService.updateCategory(category));
    }

    /*delete Category */
    @DeleteMapping("/deleteCategory/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "categoryId", required = true) Long categoryId){
                this.categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("successfully deleted");
    }

}
