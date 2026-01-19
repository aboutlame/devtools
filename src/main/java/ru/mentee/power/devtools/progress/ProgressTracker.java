package ru.mentee.power.devtools.progress;

public class ProgressTracker {
  public String calculateTotalProgress(Mentee[] mentees) {
    if (mentees == null || mentees.length == 0) {
      return "Нет данных о прогрессе";
    }
    int totalCompleted = 0;
    int totalTotal = 0;
    int index = 0;
    while (index < mentees.length) {
      totalCompleted += mentees[index].completedLessons();
      totalTotal += mentees[index].totalLessons();
      index++;
    }
    int totalRemaining = totalTotal - totalCompleted;
    return String.format("Суммарно: пройдено %d из %d уроков, осталось %d уроков",
            totalCompleted, totalTotal, totalRemaining);
  }

  public static void main(String[] args) {
    ProgressTracker tracker = new ProgressTracker();

    // Создаём массив mentee (продолжение DVT-2: добавляем прогресс к личной карточке)
    Mentee[] mentees = {
      new Mentee("Дмитрий", "Москва", "Backend разработка", 5, 12),
      new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
      new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
    };

    String progress = tracker.calculateTotalProgress(mentees);
    System.out.println(progress);
  }
}
