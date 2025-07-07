package com.company.student_management.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "EXAM", indexes = {
        @Index(name = "IDX_EXAM_COURSE", columnList = "COURSE_ID")
})
@Entity
public class Exam {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "EXAM_TITLE")
    private String exam_title;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_")
    private Date date;

    @Column(name = "LOCATION")
    private String location;

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "COURSE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExam_title() {
        return exam_title;
    }

    public void setExam_title(String exam_title) {
        this.exam_title = exam_title;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}