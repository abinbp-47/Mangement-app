package com.company.student_management.security;

import com.company.student_management.entity.*;
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

    @MenuPolicy(menuIds = {"Exam.list", "Course.list", "Student.list"})
    @ViewPolicy(viewIds = {"Exam.list", "Course.list", "Student.list", "Department.list"})
    void screens();

    @EntityAttributePolicy(entityClass = Exam.class, attributes = {"date", "exam_title", "location", "course"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Exam.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Exam.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE, EntityPolicyAction.CREATE})
    void exam();

    @EntityAttributePolicy(entityClass = Student.class, attributes = "id", action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Student.class, attributes = {"name", "age", "email", "courses", "department"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Student.class, actions = EntityPolicyAction.ALL)
    void student();

    @EntityAttributePolicy(entityClass = Course.class, attributes = {"id", "department"}, action = EntityAttributePolicyAction.VIEW)
    @EntityAttributePolicy(entityClass = Course.class, attributes = {"courseName", "courseDuration", "faculty", "students"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityPolicy(entityClass = Course.class, actions = EntityPolicyAction.ALL)
    void course();

    @EntityAttributePolicy(entityClass = Department.class, attributes = {"students", "courses"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Department.class, attributes = {"department_name", "department_head", "id"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Department.class, actions = EntityPolicyAction.READ)
    void department();

    @EntityAttributePolicy(entityClass = User.class, attributes = {"firstName", "lastName", "email", "course", "department"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = User.class, actions = EntityPolicyAction.READ)
    void user();
}