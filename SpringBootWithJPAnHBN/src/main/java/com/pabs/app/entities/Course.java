package com.pabs.app.entities;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity

/*
@Table annotation is used when table name is different from the Entity Class Name
Another point is from the given example of CourseDetails Entity name - the table created would be Course_Details in DB. Hibernate convert based on camel cases to add _ to table name
Refer the sql being fired for the same on the fly
 /@Table(name = "CourseDetails")
 */

/*
A predefined named query applied here - One can define as many as predefined query and apply at the Repository Level
 */
@NamedQuery(name="find_all_Courses_Details", query="Select c from Course c")
public class Course {


    @Id
    @GeneratedValue
    private Long id;


    /*
    ideally used when the column is different from underlying table col name | nullable =false ensure no NULL values are allowed
    refer test cases how null value insert being tested
    */
    @Column(name = "name",nullable=false)
    private String name;


    /*
         Some other Column annotations are unique (for SSN type cols) length limit etc
         Can have separate test cases for testing these conditions

         */
    @Column(name = "isdn",unique = true,length = 8)
    private String courseBookISDN;

    // LocalDateTime is Java 8 feature which has optimized Date functions a lot
    // Note CreationTimeStamp annoation belongs to Hibernate and Not JPA
    @CreationTimestamp
    private LocalDateTime createdDate;

    // LocalDateTime is Java 8 feature which has optimized Date functions a lot

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;




    public Course(){

    }


    public Course(String name){
        this.name=name;
    }


    public Course(String name,String courseBookISDN){
        this.name=name;
        this.courseBookISDN=courseBookISDN;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("courseBookISDN", courseBookISDN)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return name.equals(course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    public String getCourseBookISDN() {
        return courseBookISDN;
    }

    public void setCourseBookISDN(String courseBookISDN) {
        this.courseBookISDN = courseBookISDN;
    }

}
