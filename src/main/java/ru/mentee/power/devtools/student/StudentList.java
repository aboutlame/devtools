package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
  private List<Student> studentList;

  private static final int MAX_SIZE = 10;

  public StudentList() {
    studentList = new ArrayList<>();
  }

  public void addStudent(Student student) {
    if (student != null) {
      studentList.add(student);
    }
  }

  public List<Student> getStudentsFromSpecificCity(String city) {
    return studentList.stream().filter(s -> s.city().equals(city)).toList();
  }
}