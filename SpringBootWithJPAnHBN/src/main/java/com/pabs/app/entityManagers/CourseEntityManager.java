package com.pabs.app.entityManagers;


import com.pabs.app.entities.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
/*
 Since data  being altered here by CourseEntityManager (by delete/update ops) SpringFramework expect the entity manager does that under
 "Transactional" context. Hence we define here as Transactional. This is mandatory when we use EntityManager persits or merge operations and hence compile
 time issues would be reported.
 */
@Transactional
public class CourseEntityManager {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@PersistenceContext
    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class,id);

    }

    /*
      Refer Junit Test case how to test a List of Course retrieved

     */

    public List<Course> findAll(){
        TypedQuery<Course> namedQuery=entityManager.createNamedQuery("find_all_Courses_Details", Course.class);
        return namedQuery.getResultList();

    }


    public void save(Course course){
        if(course.getId()==null){
            logger.info("New Course detected Saving now ");
            entityManager.persist(course);
        }
        else {
               logger.info("Course existing - Updating details  now ");
                entityManager.merge(course);
        }

    }


    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);

    }


}
