package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MenteeTest {

    @Test
    void shouldThrowException_whenCompletedLessonsIsNegative() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Mentee("Dima", "Moscow", "Backend", -1, 10)
        );

        assertEquals("Некорректные значения прогресса!", exception.getMessage());
    }
}
