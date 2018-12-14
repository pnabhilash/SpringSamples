package com.pabs.app.entities;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity

/*
@Table annotation is used when table number is different from the Entity Class Name
Another point is from the given example of CourseDetails Entity number - the table created would be Course_Details in DB. Hibernate convert based on camel cases to add _ to table number
Refer the sql being fired for the same on the fly
 /@Table(number = "CourseDetails")
 */

/*
A predefined named query applied here - One can define as many as predefined query and apply at the Repository Level
 */
//@NamedQuery(name="find_all_Courses_Details", query="Select c from Pa c")
public class Passport {


    @Id
    @GeneratedValue
    private Long id;


    /*
    ideally @Column used when the column is different from underlying table col number | nullable =false ensure no NULL values are allowed
    refer test cases how null value insert being tested
    */
    @Column(name ="number")
    private String number;


    // LocalDateTime is Java 8 feature which has optimized Date functions a lot
    // Note CreationTimeStamp annotation belongs to Hibernate and Not JPA
    @CreationTimestamp
    private LocalDateTime createdDate;

    // LocalDateTime is Java 8 feature which has optimized Date functions a lot

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;



    public Passport(){

    }


    public Passport(String number){
        this.number = number;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport student = (Passport) o;
        return number.equals(student.number);
    }

    @Override
    public String toString() {
        return new ToStringBuilder("Passport")
                .append("id", id)
                .append("number", number)
                .append("createdDate", createdDate)
                .append("lastUpdatedDate", lastUpdatedDate)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


}
