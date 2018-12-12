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

    /**
     * Saving and updating same session though persist operations is called only once
     * Since explicit detach is called any changes happens to the same object get updated and commiitted to persistent object
     */

    public void saveAndUpdateInSameSession(){
        Course course=new Course("Automated Testing for IPhone Apps ");
        entityManager.persist(course);
        course.setName("Automated Testing for IPhone Apps- Updated 2019 "); // In DB this result would be seen.
    }

    /**
     * Per se, entityManager.flush methods would invoke automatic call - immediate call to persist data to underlying DB mechanism.
     *
     * This call actually call sql query fire to the db. In a way a DB constraints if any - such as column width data type can be
     * instantly noticed here
     *
     *
     */


    public void saveAndUpdateInSameSessionButFlush(){

        Course course=new Course("Artifiical Intelligene Decoded  ");
        entityManager.persist(course);
        entityManager.flush();
        course.setName("Artifiical Intelligene Decoded - Updated 2019"); // In DB this result would be seen

    }


    public void saveAndUpdateWithDetachedObjectInSameSession(){
        Course course=new Course("Component Based Design ");
        entityManager.persist(course);
        entityManager.flush();  // At this stage - course get saved to db.
        entityManager.detach(course); // detaching the object from the current session  alternative is em.clear method !!
        course.setName("Component Based Design - Updated 2019"); // this will be ignored !!

    }



    public void saveAndUpdateWithSessionRefresh(){
        Course course=new Course("Component Based Design for MicroService ");
        entityManager.persist(course);
        entityManager.flush();  // At this stage - course get saved to db.
        course.setName("Component Based Design for MicroService- Updated 2019");
        entityManager.refresh(course);  // This will bring back the data in db at the stage of flush point. The setName will not be reflected as it did not get persisted to db.ßßß

    }








    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);

    }


}
