package com.company.student_management.security;

import com.company.student_management.entity.Course;
import com.company.student_management.entity.Student;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "Teacher", code = TeacherRole.CODE)
public interface TeacherRole {
    String CODE = "teacher";

    @MenuPolicy(menuIds = "Student.list")
    @ViewPolicy(viewIds = "Student.list")
    void screens();

    @EntityPolicy(entityClass = Course.class, actions = EntityPolicyAction.READ)
    void course();

    @EntityPolicy(entityClass = Student.class, actions = {EntityPolicyAction.CREATE, EntityPolicyAction.READ, EntityPolicyAction.UPDATE})
    void student();
}