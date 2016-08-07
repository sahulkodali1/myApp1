package com.myApp1.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp1.Model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer>{

}
