package com.example.subleasesite.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmailOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmailOptional.isPresent()) {
            throw new IllegalArgumentException("Student Already Exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        Optional<Student> studentByIdOptional = studentRepository.findById(studentId);
        if (studentByIdOptional.isEmpty()) {
            throw new IllegalArgumentException(String.format("Student By ID %d Does Not Exist", studentId));
        }
        studentRepository.delete(studentByIdOptional.get());
    }
}
