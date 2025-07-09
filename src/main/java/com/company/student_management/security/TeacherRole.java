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
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Teacher", code = TeacherRole.CODE)
public interface TeacherRole {
    String CODE = "teacher";

    @MenuPolicy(menuIds = {"Student.list", "Exam.list"})
    @ViewPolicy(viewIds = {"Student.list", "Exam.list", "Student.detail"})
    void screens();

    @EntityAttributePolicy(entityClass = Student.class, attributes = {"name", "id", "age", "email", "courses"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Student.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.UPDATE, EntityPolicyAction.READ})
    void student();

    @EntityPolicy(entityClass = Course.class, actions = EntityPolicyAction.READ)
    void course();

    @EntityPolicy(entityClass = Exam.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void exam();

    @EntityPolicy(entityClass = Department.class, actions = EntityPolicyAction.READ)
    void department();

    @SpecificPolicy(resources = "ui.loginToUi")
    void specific();
}