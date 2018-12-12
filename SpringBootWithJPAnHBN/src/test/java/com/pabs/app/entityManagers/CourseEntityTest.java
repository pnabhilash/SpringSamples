package com.pabs.app.entityManagers;


import com.pabs.app.entities.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest

public class CourseEntityTest {


private Logger logger = LoggerFactory.getLogger(this.getClass());

@Autowired
CourseEntityManager courseEntityManager;


/*
DirtiesContext : this is use for keep the status quo of the data post testing scenarios. For eg to test a CRUD ops we may alter data status in Persistence DB.
For a delete case. But once test is done we may need that data back and hence the ops has to be roll back.
DirtiesContext help me to preserve the status quo of the Data to the stage where it started

 */

@Test
@DirtiesContext
public void testSaveData(){

    Course course = new Course("Rest WebService Model");
    courseEntityManager.save(course);
}

/*
    Primarily to make sure items got saved as expected a reverse check is required. For that purpose the entity must override equals and hashcode method for comparison purpose.
    How to test List of objects contains the required item ?  Refer mykong website on the same.
    hamcrest-library has got several static functions defined for the same.
 */


@Test
public void testFindAllData(){
    Course newCourse = new Course("Automated Testing ");
    courseEntityManager.save(newCourse);
    List<Course> courseList=courseEntityManager.findAll();
    assertThat(courseList,hasItems(newCourse));
    courseList.forEach(Course ->System.out.println(Course));

}


/*
   This test though passed did not yield expected results !! 2 separate calls  save is treated here as 2 separate session and 2 inserts.
   Testing did not yield expected save in non-detached manner...

 */

@Test
    public void testPersistAndUpdateDatainSameSession(){
    Course newCourse = new Course("Automated Testing ");
    courseEntityManager.save(newCourse);

    List<Course> courseList=courseEntityManager.findAll();
    assertThat(courseList,hasItems(newCourse));
    courseList.forEach(Course ->System.out.println("B4 Update "+Course));


    newCourse.setName("Automated Testing Updated");
    courseEntityManager.save(newCourse);

    List<Course> courseList2=courseEntityManager.findAll();
    assertThat(courseList2,hasItems(newCourse));
    courseList2.forEach(Course ->System.out.println(Course));


}


}
