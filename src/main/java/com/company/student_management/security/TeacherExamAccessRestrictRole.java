package com.company.student_management.security;

import com.company.student_management.entity.Exam;
import com.company.student_management.entity.User;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.security.model.RowLevelBiPredicate;
import io.jmix.security.model.RowLevelPolicyAction;
import io.jmix.security.role.annotation.PredicateRowLevelPolicy;
import io.jmix.security.role.annotation.RowLevelRole;
import org.springframework.context.ApplicationContext;

@RowLevelRole(name = "TeacherExamAccessRestrict", code = TeacherExamAccessRestrictRole.CODE)
public interface TeacherExamAccessRestrictRole {
    String CODE = "teacher-exam-access-restrict";

    @PredicateRowLevelPolicy(entityClass = Exam.class, actions = {RowLevelPolicyAction.READ, RowLevelPolicyAction.UPDATE})
    default RowLevelBiPredicate<Exam, ApplicationContext> examPredicate() {
        return (exam, applicationContext) -> {
            CurrentAuthentication currentAuthentication=applicationContext.getBean(CurrentAuthentication.class);
            User currentUser=(User) currentAuthentication.getUser();
            return exam.getCourse().getFaculty().equals(currentUser);
        };
    }
}