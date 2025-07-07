package com.company.student_management.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "COURSE", indexes = {
        @Index(name = "IDX_COURSE_FACULTY", columnList = "FACULTY_ID"),
        @Index(name = "IDX_COURSE_DEPARTMENT", columnList = "DEPARTMENT_ID")
})
@Entity
public class Course {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @Column(name = "COURSE_DURATION")
    private String courseDuration;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "FACULTY_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private User faculty;

    @JoinTable(name = "STUDENT_COURSE_LINK",
            joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Student> students;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "DEPARTMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getFaculty() {
        return faculty;
    }

    public void setFaculty(User faculty) {
        this.faculty = faculty;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}