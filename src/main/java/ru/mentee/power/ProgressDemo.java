package ru.mentee.power;

public class ProgressDemo {
  public static void main(String[] args) {
    MenteeProgress dmitryTimoshenko = new MenteeProgress("Dmitry Timoshenko", 2, 10);

    System.out.println(dmitryTimoshenko.summary());
    if (dmitryTimoshenko.readyForSprint()) {
        System.out.println("Status: sprint ready");
    } else {
      System.out.println("Status: backlog first");
    }
    System.out.println("feature/DVT-3");
    System.out.println("+ feature/DVT-4");
  }
}
