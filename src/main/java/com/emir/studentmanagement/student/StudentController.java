package com.emir.studentmanagement.student;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController("api/student")
@RequestMapping("api/student")
public class StudentController {
  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudents() {
    return studentService.getStudents();
  }

  @PostMapping
  public Map<String, String> createStudent(@RequestBody Student student) {
    studentService.createStudent(student);

     HashMap<String, String> map = new HashMap<>();

     map.put("message", "Öğrenci başarıyla oluşturuldu.");

     return map;
  }

  @PutMapping("/{id}")
  public Map<String, String> updateStudent(@RequestBody Student student, @PathVariable("id") UUID id){
    studentService.updateStudent(student, id);

    HashMap<String, String> map = new HashMap<>();

    map.put("message", "Öğrenci başarıyla güncellendi.");

    return map;
  }

  @DeleteMapping("/{id}")
  public Map<String, String> deleteStudent(@PathVariable("id") UUID id) {
    studentService.deleteStudent(id);

    HashMap<String, String> map = new HashMap<>();

    map.put("message", "Öğrenci başarıyla silindi.");

    return map;
  }
}
