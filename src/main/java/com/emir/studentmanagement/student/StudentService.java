package com.emir.studentmanagement.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

  public void createStudent(Student student) throws StudentServerErrorException {
    try {
      studentRepository.save(student);
    } catch (Exception ex){
      throw new StudentServerErrorException(ex);
    }
  }

  public void updateStudent(Student student, UUID id) {
    student.setId(id);
    studentRepository.save(student);
  }

  public void deleteStudent(UUID id) {
    studentRepository.deleteById(id);
  }

  public Student getStudent(UUID id) throws StudentNotFoundException {
    var student=  studentRepository.findById(id);
    if (student.isEmpty()) {
      throw new StudentNotFoundException();
    }

    return student.get();
  }
}
