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
//@NamedQuery(name="find_all_Courses_Details", query="Select c from Course c")
public class Student {


    @Id
    @GeneratedValue
    private Long id;


    /*
    ideally @Column used when the column is different from underlying table col name | nullable =false ensure no NULL values are allowed
    refer test cases how null value insert being tested
    */
    @Column(name = "name")
    private String name;


    // LocalDateTime is Java 8 feature which has optimized Date functions a lot
    // Note CreationTimeStamp annotation belongs to Hibernate and Not JPA
    @CreationTimestamp
    private LocalDateTime createdDate;

    // LocalDateTime is Java 8 feature which has optimized Date functions a lot

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    /*
       Defining here ONE-to-ONE mapping relationship. A Student association with a unique passport number.
       Define OneToOne annotation and run the app and see the Student table to see extra col got added !

     */
    @OneToOne
    private Passport passport;


    public Student(){

    }


    public Student(String name){
        this.name=name;
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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("createdDate", createdDate)
                .append("lastUpdatedDate", lastUpdatedDate)
                .append("passport", passport.toString())
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
