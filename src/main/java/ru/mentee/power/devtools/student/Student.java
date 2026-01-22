package ru.mentee.power.devtools.student;

public record Student(String name, String city, String email) {
  public Student{
    if (email == null || email.isBlank() || !email.contains("@") || !email.contains(".")) {
      throw new IllegalArgumentException("Email is not valid");
    }
  }
}