package com.pabs.app.entityManagers;


import com.pabs.app.entities.Passport;
import com.pabs.app.entities.Student;
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
 Since data  being altered here by StudentEntityManager (by delete/update ops) SpringFramework expect the entity manager does that under
 "Transactional" context. Hence we define here as Transactional. This is mandatory when we use EntityManager persits or merge operations and hence compile
 time issues would be reported.
 */
@Transactional
public class StudentEntityManager {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@PersistenceContext
    @Autowired
    EntityManager entityManager;

    public Student findById(Long id){
        return entityManager.find(Student.class,id);

    }

    /*
      Refer Junit Test case how to test a List of Student retrieved

     */

    public List<Student> findAll(){
        TypedQuery<Student> namedQuery=entityManager.createNamedQuery("find_all_Students_Details", Student.class);
        return namedQuery.getResultList();

    }


    public void save(Student student){
        if(student.getId()==null){
            logger.info("New Student detected Saving now ");
            entityManager.persist(student);
        }
        else {
               logger.info("Student existing - Updating details  now ");
                entityManager.merge(student);
        }

    }
    /*
        Saving a data with one to one mapping here.
        Care to be taken that unique id does not clash with Generated id by the hibernate.
        Also the FK value to be persisted first and then followed by the owner of the relation ship.

        Thus in this case Student owns the Passport FK and thus Passport get persisted first followed by Student


     */

    public Student saveStudentWithPassport(){
        Passport passport=new Passport("666");
        entityManager.persist(passport);   // First Passport has to be persisted else FK violence issue arise (org.hibernate.TransientPropertyValueException:)

        Student student =new Student("George Bush");
        student.setPassport(passport);
        entityManager.persist(student);

        return  student;

    }


    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);

    }


}
