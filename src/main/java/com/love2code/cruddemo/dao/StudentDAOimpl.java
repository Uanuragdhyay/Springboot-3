package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{


//define field for entity manager
    private EntityManager entityManager;
    @Autowired
    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


//inject entity manager using constructor injection





//implement save method




    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
         return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student  ", Student.class);
        //return query results
            return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        theQuery.setParameter("theData",theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student thestudent) {
        entityManager.merge(thestudent);
    }

    @Override
    @Transactional
    public void delete(int id) {
        //retrieve the student of given id
        Student thestudent= entityManager.find(Student.class,id);

        //delete the dtudent
        entityManager.remove(thestudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numStudentsDeleted=entityManager.createQuery("delete FROM Student") .executeUpdate();
        return numStudentsDeleted;
    }


}


