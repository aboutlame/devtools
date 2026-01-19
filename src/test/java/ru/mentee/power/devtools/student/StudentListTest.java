package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StudentListTest {

  @Test
  void shouldAddStudentsIfNotNull() {
    Student student = new Student("Dima", "Moscow");
    StudentList list = new StudentList();

    list.addStudent(student);

    assertThat(list.getStudentsFromSpecificCity("Moscow")).containsExactly(student);
  }
}