package com.pabs.app.entities;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

/*
@Table annotation is used when table description is different from the Entity Class Name
Another point is from the given example of CourseDetails Entity description - the table created would be Course_Details in DB. Hibernate convert based on camel cases to add _ to table description
Refer the sql being fired for the same on the fly
 /@Table(description = "CourseDetails")
 */

/*
A predefined named query applied here - One can define as many as predefined query and apply at the Repository Level
 */
//@NamedQuery(name="find_all_Courses_Details", query="Select c from Course c")
public class Review {


    @Id
    @GeneratedValue
    private Long id;


    /*
    ideally @Column used when the column is different from underlying table col description | nullable =false ensure no NULL values are allowed
    refer test cases how null value insert being tested
    */
    @Column(name = "ReviewDescription")
    private String description;

    @Column(name="CourseRating")
    private String rating;


    // LocalDateTime is Java 8 feature which has optimized Date functions a lot
    // Note CreationTimeStamp annotation belongs to Hibernate and Not JPA
    @CreationTimestamp
    private LocalDateTime createdDate;

    // LocalDateTime is Java 8 feature which has optimized Date functions a lot

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;



    public Review(){

    }


    public Review(String description){
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return new ToStringBuilder("Review Status ")
                .append("id", id)
                .append("description", description)
                .append("rating", rating)
                .append("createdDate", createdDate)
                .append("lastUpdatedDate", lastUpdatedDate)
                .toString();
    }
}
