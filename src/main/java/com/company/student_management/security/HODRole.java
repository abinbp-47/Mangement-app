package com.company.student_management.security;

import com.company.student_management.entity.Course;
import com.company.student_management.entity.Department;
import com.company.student_management.entity.Exam;
import com.company.student_management.entity.Student;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "HOD", code = HODRole.CODE)
public interface HODRole {
    String CODE = "h-o-d";

    @MenuPolicy(menuIds = {"Exam.list", "Course.list", "Student.list", "Department.list"})
    @ViewPolicy(viewIds = {"Exam.list", "Course.list", "Student.list", "Department.list"})
    void screens();

    @EntityPolicy(entityClass = Department.class, actions = EntityPolicyAction.READ)
    void department();

    @EntityPolicy(entityClass = Exam.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.CREATE, EntityPolicyAction.UPDATE})
    void exam();

    @EntityAttributePolicy(entityClass = Student.class, attributes = "*", action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Student.class, actions = EntityPolicyAction.ALL)
    void student();

    @EntityPolicy(entityClass = Course.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void course();
}