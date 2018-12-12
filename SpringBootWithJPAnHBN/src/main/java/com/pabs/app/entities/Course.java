package com.pabs.app.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Objects;

@Entity
/*
A predefined named query applied here - One can define as many as predefined query and apply at the Repository Level.


 */
@NamedQuery(name="find_all_Courses_Details", query="Select c from Course c")
public class Course {


    @Id
    @GeneratedValue
    private Long id;



    private String name;


    public Course(){

    }


    public Course(String name){
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


    @Override
    public String toString() {
        return new org.apache.commons.lang.builder.ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
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

}
