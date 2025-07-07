package com.company.student_management.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "DEPARTMENT", indexes = {
        @Index(name = "IDX_DEPARTMENT_DEPARTMENT_HEAD", columnList = "DEPARTMENT_HEAD_ID")
})
@Entity
public class Department {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DEPARTMENT_NAME")
    private String department_name;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "DEPARTMENT_HEAD_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User department_head;

    @OneToMany(mappedBy = "department")
    private List<Student> students;

    @OneToMany(mappedBy = "department")
    private List<Course> courses;

    public User getDepartment_head() {
        return department_head;
    }

    public void setDepartment_head(User department_head) {
        this.department_head = department_head;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}