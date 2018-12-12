package com.pabs.app.entityManagers;

import com.pabs.app.entities.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager entityManager;


    @Test
    public void jpql_basic_test_select(){
        String testSql=" Select c From Course c";
        Query query=entityManager.createQuery(testSql);
        List<Course> courseList=query.getResultList();
        logger.info("Basic Test 1 {}",courseList);
    }


    /*
       TypedQuery - ensures the type of the Data Entity to be return back

     */

    @Test
    public void jpql_typedQuery_test_select(){
        String testSql=" Select c From Course c";
        TypedQuery <Course> courseListQuery=entityManager.createQuery(testSql,Course.class);
        List<Course> courseList=courseListQuery.getResultList();
        logger.info("Jpql_typedQuery_test_select {}",courseList);
    }


    @Test
    public void jpql_typedQuery_test_WhereCond(){
        String testSql=" Select c From Course c where name like 'A%'";
        TypedQuery <Course> courseListQuery=entityManager.createQuery(testSql,Course.class);
        List<Course> courseList=courseListQuery.getResultList();
        logger.info("Jpql_typedQuery_test_WhereCond {}",courseList);
    }


}
