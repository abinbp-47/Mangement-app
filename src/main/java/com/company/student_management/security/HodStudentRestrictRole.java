package com.company.student_management.security;

import com.company.student_management.entity.Student;
import com.company.student_management.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "HodStudentRestrict", code = HodStudentRestrictRole.CODE)
public interface HodStudentRestrictRole {
    String CODE = "hod-student-restrict";

    @PredicateRowLevelPolicy(entityClass = Student.class, actions = {RowLevelPolicyAction.READ, RowLevelPolicyAction.CREATE, RowLevelPolicyAction.UPDATE, RowLevelPolicyAction.DELETE})
    default RowLevelBiPredicate<Student, ApplicationContext> studentPredicate() {
        return (student, applicationContext) -> {
            CurrentAuthentication currentAuthentication=applicationContext.getBean(CurrentAuthentication.class);
            User currentUser=(User) currentAuthentication.getUser();
            return student.getCourses().stream()
                    .anyMatch(course -> currentUser.getCourse().getDepartment().getDepartment_head()
                            .equals(course.getDepartment().getDepartment_head()));
            //return student.getCourses().stream()
            //                    .anyMatch(course -> currentUser.getCourse().getFaculty().equals(course.getFaculty()));
        };
    }
}