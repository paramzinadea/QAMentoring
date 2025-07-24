package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //User Input
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter a number to check: ");

        //Check Even or Odd
        Double inputNumber = myObj.nextDouble();
        System.out.println("Number is: " + checkEvenOdd(inputNumber));

        //Calculate Sum
        System.out.println("Please enter a number to calculate a sum: ");
        int n = myObj.nextInt();
        System.out.println("Sum of All Numbers from 1 to " + n + " is: "  + sumNumbers(n));

        //Calculate Max of array
        System.out.println("Please Enter numbers separated by spaces: \n");
        String newString = myObj.nextLine();
        System.out.println("Largest number is: " + findMax(newString));

        //Create an array with the books
        Book[] books = new Book[4];
        books [0] = new Book("Title1", "Author1", 25.0);
        books [1] = new Book("Title2", "Author2", 50.0);
        books [2]= new Book("Title3", "Author3", 75.0);
        books [3]= new Book("Title4", "Author4", 100.0);

        System.out.println("There are 4 books in library, insert the number order to check details: \n");
        int b = myObj.nextInt();
        if(b>0 && b<4){books[b-1].printDetails();}

        //Extend Animals
        Cat cat = new Cat();
        Dog dog = new Dog();
        Animal animal = new Animal();
        System.out.println("Animal make: ");
        animal.makeSound();
        System.out.println("Cat make: ");
        cat.makeSound();
        System.out.println("Dog make: ");
        dog.makeSound();
    }


     //Methods
    public static String checkEvenOdd (Double j ){
        return (j % 2 == 0)? "Even" : "Odd" ;
    }

    public static Integer sumNumbers (int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static Double findMax(String newString){

        if (newString == null) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        String[] splitedString = newString.trim().split("\\s+");
        Double[] numbers = new Double[splitedString.length];
        for (int i = 0; i < splitedString.length; i++)
            numbers[i] = Double.parseDouble(splitedString[i]);  // Convert each to double
    return Arrays.stream(numbers).max(Comparator.naturalOrder()).orElse(null);
    }
}