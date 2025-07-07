package com.company.student_management.view.exam;

import com.company.student_management.entity.Exam;
import com.company.student_management.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;


@Route(value = "exams", layout = MainView.class)
@ViewController(id = "Exam.list")
@ViewDescriptor(path = "exam-list-view.xml")
@LookupComponent("examsDataGrid")
@DialogMode(width = "64em")
public class ExamListView extends StandardListView<Exam> {
}