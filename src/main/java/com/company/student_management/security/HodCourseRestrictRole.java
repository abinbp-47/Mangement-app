package com.company.student_management.security;

import com.company.student_management.entity.Course;
import com.company.student_management.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "HodCourseRestrict", code = HodCourseRestrictRole.CODE)
public interface HodCourseRestrictRole {
    String CODE = "hod-course-restrict";

    @PredicateRowLevelPolicy(entityClass = Course.class, actions = {RowLevelPolicyAction.READ, RowLevelPolicyAction.CREATE, RowLevelPolicyAction.UPDATE, RowLevelPolicyAction.DELETE})
    default RowLevelBiPredicate<Course, ApplicationContext> coursePredicate() {
        return (course, applicationContext) -> {
            if (course == null || course.getDepartment() == null || course.getDepartment().getDepartment_head() == null) {
                return false;
            }
            CurrentAuthentication currentAuthentication = applicationContext.getBean(CurrentAuthentication.class);
            User currentUser = (User) currentAuthentication.getUser();
            if (course.getDepartment().getDepartment_head().equals(currentUser)) {
                return true;
            }

            return false;
        };
    }
}