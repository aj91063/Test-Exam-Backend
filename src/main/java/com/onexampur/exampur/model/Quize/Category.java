package com.onexampur.exampur.model.Quize;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    @Column(name = "title")
    private String title;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quize> quizzes = new LinkedHashSet<>();
    public Category() {
    }


    public Category(Long cid, String title, String description, Set<Quize> quizzes) {
        this.cid = cid;
        this.title = title;
        this.description = description;
        this.quizzes = quizzes;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Quize> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(Set<Quize> quizzes) {
        this.quizzes = quizzes;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
