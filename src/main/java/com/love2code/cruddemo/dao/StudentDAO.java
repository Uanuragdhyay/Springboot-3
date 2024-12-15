package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Student;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void update (Student thestudent);
    void delete (int id);
    int deleteAll();

}




