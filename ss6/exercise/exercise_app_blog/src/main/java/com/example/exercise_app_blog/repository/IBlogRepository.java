package com.example.exercise_app_blog.repository;

import com.example.exercise_app_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {

}
