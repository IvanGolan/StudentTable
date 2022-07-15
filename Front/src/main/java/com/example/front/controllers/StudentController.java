package com.example.front.controllers;

import com.example.front.entities.Student;
import com.example.front.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;
    private List<Student> allStudents;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        allStudents = List.of();
    }

    @GetMapping("/students")
    public String getStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    @GetMapping("students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }
    @PostMapping("/students")
    public String addStudents(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @DeleteMapping(path = "/id/{id}")
    public void removeStudents(@PathVariable Long id){
        studentService.removeStudent(id);
    }

}
