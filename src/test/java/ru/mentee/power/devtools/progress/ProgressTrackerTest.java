package ru.mentee.power.devtools.progress;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProgressTrackerTest {

    @Test
    void shouldReturnNoDataMessage_whenMenteesIsNull() {
        ProgressTracker tracker = new ProgressTracker();

        String result = tracker.calculateTotalProgress(null);

        assertThat(result).isEqualTo("Нет данных о прогрессе");
    }

    @Test
    void shouldReturnNoDataMessage_whenMenteesIsEmpty() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee[] mentees = new Mentee[0];

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result).isEqualTo("Нет данных о прогрессе");
    }

    @Test
    void shouldCalculateProgress_whenOneMenteeProvided() {
        ProgressTracker tracker = new ProgressTracker();
        Mentee mentee = new Mentee("Dima", "Moscow", "Backend", 5, 12);
        Mentee[] mentees = { mentee };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 5 из 12")
                .contains("осталось 7");
    }

    @Test
    void shouldCalculateProgress_whenMultipleMenteesProvided() {
        ProgressTracker tracker = new ProgressTracker();

        Mentee mentee1 = new Mentee("Dima", "Moscow", "Backend", 10, 12);
        Mentee mentee2 = new Mentee("Stas", "Krasnodar", "Java", 7, 12);

        Mentee[] mentees = { mentee1, mentee2 };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 17 из 24")
                .contains("осталось 7");
    }

    @Test
    void shouldReturnZeroRemaining_whenAllLessonsCompleted() {
        ProgressTracker tracker = new ProgressTracker();

        Mentee mentee1 = new Mentee("Ivan", "Kazan", "Java", 12, 12);
        Mentee mentee2 = new Mentee("Olga", "SPb", "Backend", 12, 12);

        Mentee[] mentees = { mentee1, mentee2 };

        String result = tracker.calculateTotalProgress(mentees);

        assertThat(result)
                .contains("пройдено 24 из 24")
                .contains("осталось 0");
    }

    @Test
    void shouldPrintTotalProgress_whenMainIsExecuted() {
        PrintStream originalOut = System.out;

        // перехватываем вывод в консоль
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        try {
            // when
            ProgressTracker.main(new String[]{});

            // then
            String consoleOutput = out.toString();

            assertThat(consoleOutput)
                    .contains("Суммарно: пройдено")
                    .contains("осталось");
        } finally {
            // обязательно возвращаем stdout обратно
            System.setOut(originalOut);
        }
    }

}