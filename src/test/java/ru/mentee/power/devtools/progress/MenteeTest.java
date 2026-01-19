package ru.mentee.power.devtools.progress;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MenteeTest {

  @Test
  void shouldThrowExceptionWhenCompletedLessonsIsNegative() {
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> new Mentee("Dima", "Moscow", "Backend", -1, 10)
    );

    assertEquals("Некорректные значения прогресса!", exception.getMessage());
  }
}
