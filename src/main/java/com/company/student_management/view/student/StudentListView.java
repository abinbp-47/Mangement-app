package com.company.student_management.view.student;

import com.company.student_management.entity.Student;
import com.company.student_management.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "students", layout = MainView.class)
@ViewController(id = "Student.list")
@ViewDescriptor(path = "student-list-view.xml")
@LookupComponent("studentsDataGrid")
@DialogMode(width = "64em")
public class StudentListView extends StandardListView<Student> {
}