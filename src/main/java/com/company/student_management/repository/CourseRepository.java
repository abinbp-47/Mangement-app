package com.company.student_management.repository;

 import com.company.student_management.entity.Course;
 import io.jmix.core.repository.JmixDataRepository;
 import org.springframework.stereotype.Repository;

 import java.util.UUID;

@Repository
public interface CourseRepository extends JmixDataRepository<Course, UUID> {
}