package ru.mentee.power.devtools;

public class LiveCoding {
  public static void main(String[] args) {
    printFizzBuzz(15);
    System.out.println(findMax(new int[] {3, 7, 2, 9, 1}));
    System.out.println(findMax(new int[] {-5, -1, -10}));
    System.out.println(findMax(new int[] {42}));
    System.out.println(findMax(new int[] {}));
    System.out.println(sumEven(new int[] {}));
    System.out.println(sumEven(new int[] {1, 2, 3, 4, 5, 6}));
  }

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