package org.example.tongHop;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Please enter your name: ");
            String name = sc.nextLine();
            System.out.println("Please enter your age: ");
            String age = sc.nextLine();
            System.out.println("Please enter your email: ");
            String email = sc.nextLine();

            registerUser(name,age,email);
            saveUserToFile(name);
            System.out.println("Login Successful");
        }catch (NumberFormatException e){
            System.err.println("Age is integer");
        }catch (InvalidAgeException | InvalidEmailException | FileNotFoundException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Complete the stream handler registration");
            sc.close();
        }


    }

    public static void registerUser(String name, String ageInput, String email) throws  InvalidAgeException , InvalidEmailException{

       int age = Integer.parseInt(ageInput);

       if(age < 18){
           throw new InvalidAgeException("Age must be greater than 18");
       }

       if(!email.contains("@")){
           throw new InvalidEmailException("Invalid email");
       }

    }

    public static void saveUserToFile(String userData) throws FileNotFoundException {
        boolean existsFile = false;
        if(!existsFile){
            throw  new FileNotFoundException("File not found");
        }
    }
}
