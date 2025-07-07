package com.company.student_management.security;

import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.securityflowui.role.annotation.MenuPolicy;
import io.jmix.securityflowui.role.annotation.ViewPolicy;

@ResourceRole(name = "HOD", code = HODRole.CODE)
public interface HODRole {
    String CODE = "h-o-d";

    @MenuPolicy(menuIds = {"Exam.list", "Course.list", "Student.list", "Department.list"})
    @ViewPolicy(viewIds = {"Exam.list", "Course.list", "Student.list", "Department.list"})
    void screens();
}