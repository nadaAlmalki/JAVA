import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //1.print
        System.out.println("Hello world!");

        //2. Variables
        String std_name = "Nada";
        int age = 25;
        // boolean flase;
        //boolean power = flase;

        //3. Scanner.
        //System.out.println("Plz enter your name:");
        Scanner input = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        // String name = input.nextLine();
        //System.out.println(name);

//4.String Method:
       /* String company ="Twauiq Academy";

        // 5. Opetaintion(B.Camparison, A.Arthimetic , C. Logic)
        //A.Arthimetic (% - * + /)
        //B.Camparison (< > <= >= !=)
        int n1 = 2;
        int n2 =5 ;
        System.out.println(n2 > n1);
        char c1 = 'A';
        char c2 ='a';
        char c3 ='B';
        char c4 ='b';
        System.out.println(c2 < c1);
        // C. Logic
        System.out.print("The result of character is: ");
        System.out.println (c1> c3 && c3<c4);

        // 6. Condition (If , if-else, if-else-if, Switch)
        System.out.println("Plz enter your role:");

        String role= input.nextLine();
        if(role.equals("Admin"))
            System.out.println("Welcome");
        else System.out.println("your role not allowed");

        int age2=input.nextInt();
        if ( age2 == 25){
            System.out.println("Welcome");}
        else System.out.println("your age not allowed");*/


        //Homework:
        //Q#1:

        int num1, num2;
        System.out.println("Please enter the first number");
        num1 = input.nextInt();
        System.out.println("Please enter the second number");
        num2 = input.nextInt();
        int sum = num1 + num2;
        System.out.println(num1 + " + " + num2 + " = " + sum);

        /*System.out.println("Please enter the first number");
        num1=input.nextInt();
        System.out.println("Please enter the second number");
        num2=input.nextInt();*/
        int abs = num1 - num2;
        System.out.println(num1 + " - " + num2 + " = " + abs);

        int multi = num1 * num2;
        System.out.println(num1 + " * " + num2 + " = " + multi);

        int div = num1 / num2;
        System.out.println(num1 + " / " + num2 + " = " + div);

        int mod = num1 % num2;
        System.out.println(num1 + " % " + num2 + " = " + mod);

        //Q2:
       /*System.out.println("Please enter your words");
       String sentence = input.nextLine();
        System.out.println(sentence.toLowerCase());*/
        System.out.println("Question #2");
        String sen = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";

        System.out.println(sen.toLowerCase());

        //Q3:
       /* System.out.println("Question #3");
        String s = " The quick brown fox";
        s.reserve();
*/
        //Q4:
        System.out.println("Question #4");
        int number = input.nextInt();
        if (number % 2 == 0) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        //Q5:
        System.out.println("Question #5");
        String role = str.nextLine();
        if (role.equals("admin")){
            System.out.println("Welcome admin");}
        else if (role.equals("superuser ")) {
                System.out.println("Welcome superuser"); }
            else{
                System.out.println("Welcome user"); }


        //Q6:
        System.out.println("Question #6");
        int number1, number2, number3;
        number1 = 5;
        number2 = 10;
        number3 = 15;
        int total = number1 + number2;
      //  if (Integer.sum(number1, number2) == number3 || Integer.sum(number1, number2) == number3) {
             System.out.println(total == number3 && number3 == total);

        //Q7:
        System.out.println("Question #7");
        System.out.print("Input the 1st number: ");
        int n1 = input.nextInt();
        System.out.print("Input the 2nd  number: ");
        int n2 = input.nextInt();
        System.out.print("Input the 3rd  number: ");
        int n3 = input.nextInt();
        if( n1 > n2 && n1 > n3){
            System.out.println("The greatest number is : " + n1);}
        else if( n2 > n1 && n2 > n3) {
            System.out.println("The greatest number is : " + n2);}
        else {
            System.out.println("The greatest number is : " + n3);}

        //Q8:
        System.out.println("Question #8");
        int daynum = input.nextInt();
        String day = "";
        if (daynum == 1){
            System.out.println("Monday");}
         else if (daynum == 2){
            System.out.println("Tuesday");}
        else if (daynum == 3){
            System.out.println("Wensday");}
        else if (daynum == 4){
            System.out.println("Thursday");}
        else if (daynum == 5){
            System.out.println("Friday");}
        else if (daynum == 6){
            System.out.println("Saturday");}
        else if (daynum == 7){
            System.out.println("Sunday");}
        else{
            System.out.println("Invalid");}

        System.out.println("Question #8");
        int daynum2= input.nextInt();

            }

        }
