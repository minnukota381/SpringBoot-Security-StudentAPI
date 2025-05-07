package com.main.controller;

import com.main.entity.Students;
import com.main.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping
    public List<Students> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Students getStudent(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody Students student) {
        repo.save(student);
    }

    @PutMapping("/update/{id}")
    public Students updateStudent(@PathVariable int id, @RequestBody Students updatedStudent) {
        Students existingStudent = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setUsername(updatedStudent.getUsername());
        existingStudent.setPassword(updatedStudent.getPassword());

        repo.save(existingStudent);
        return existingStudent;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        Students student = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        repo.delete(student);
    }
}
