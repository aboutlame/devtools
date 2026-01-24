package ru.mentee.power.devtools;

public class LiveCoding {

  public static void printFizzBuzz(int n) {
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        System.out.println("FizzBuzz");
      } else if (i % 3 == 0) {
        System.out.println("Fizz");
      } else if (i % 5 == 0) {
        System.out.println("Buzz");
      } else {
        System.out.println(i);
      }
    }
  }

  public static int sumEven(int[] numbers) {
    int sum = 0;
    for (int num : numbers) {
      if (num % 2 == 0) {
        sum += num;
      }
    }
    return sum;
  }

  public static int findMax(int[] numbers) {
    int maximum = Integer.MIN_VALUE;
    if (numbers.length == 0) {
      return maximum;
    }
    else {
      for (int i = 0; i < numbers.length; i++) {
        if (maximum < numbers[i]) {
          maximum = numbers[i];
        }
      }
      return maximum;
    }
  }
}