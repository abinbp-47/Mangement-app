package com.company.student_management.view.exam;

import com.company.student_management.entity.Exam;
import com.company.student_management.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "exams/:id", layout = MainView.class)
@ViewController(id = "Exam.detail")
@ViewDescriptor(path = "exam-detail-view.xml")
@EditedEntityContainer("examDc")
public class ExamDetailView extends StandardDetailView<Exam> {
}