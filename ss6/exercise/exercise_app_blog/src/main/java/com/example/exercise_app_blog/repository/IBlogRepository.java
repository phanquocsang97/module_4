package com.example.exercise_app_blog.repository;

import com.example.exercise_app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllByNameContaining(Pageable pageable,String name);
    @Query(value = "select * from blog b where b.category_id =:categoryId ",nativeQuery = true)
    Page<Blog> findAllByBlog(Pageable pageable, @Param("categoryId") int category);

}
