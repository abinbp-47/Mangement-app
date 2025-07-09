package com.company.student_management.security;

import com.company.student_management.entity.Course;
import com.company.student_management.entity.Exam;
import com.company.student_management.entity.Student;
import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Teacher", code = TeacherRole.CODE)
public interface TeacherRole {
    String CODE = "teacher";

    @MenuPolicy(menuIds = {"Student.list", "Exam.list"})
    @ViewPolicy(viewIds = {"Student.list", "Exam.list"})
    void screens();

    @EntityAttributePolicy(entityClass = Student.class, attributes = {"email", "age", "name"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Student.class, attributes = {"id", "department", "courses"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Student.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void student();

    @EntityAttributePolicy(entityClass = Course.class, attributes = {"faculty", "students"}, action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Course.class, attributes = {"id", "courseName", "courseDuration", "department"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Course.class, actions = EntityPolicyAction.UPDATE)
    void course();

    @EntityAttributePolicy(entityClass = Exam.class, attributes = "course", action = EntityAttributePolicyAction.MODIFY)
    @EntityAttributePolicy(entityClass = Exam.class, attributes = {"id", "exam_title", "date", "location"}, action = EntityAttributePolicyAction.VIEW)
    @EntityPolicy(entityClass = Exam.class, actions = {EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void exam();
}