package com.example.front.services;

import com.example.front.entities.Student;
import com.example.front.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public void removeStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id){
         return studentRepository.findById(id).get();
    }
    public void updateStudent(Student student){
        studentRepository.save(student);
    }

}
