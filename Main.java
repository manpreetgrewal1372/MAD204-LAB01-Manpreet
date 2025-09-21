/**
 * F2025 MAD204-01 - Lab 1
 * Name: Manpreet Singh (A00198842)
 * Date: 2025-09-16
 * Gradebook & Utilities app.
 */

import java.util.*;

public class Main
{
    static ArrayList<Student> list = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)   //Starting of main function
    {
        boolean run = true;
        while (run)     //Used while loop
        {
            System.out.println("\n1.Add student\n2.Enter grades\n3.Show all\n4.Utilities\n5.Exit");
            System.out.print("Choice: ");
            String ch = in.nextLine();
            switch (ch)    //Used switch statement to call function based on the case
            {
                case "1": addStudent();
                break;
                case "2": enterGrades();
                break;
                case "3": showAll();
                break;
                case "4": utilities();
                break;
                case "5": run = false;
                break;
                default: System.out.println("Please choose only given value!");
            }
        }
    }

    static void addStudent()    // used addStudent() function to add new Student
    {
        String again;
        do
        {
            System.out.print("Enter Student Name: ");
            String n = in.nextLine();
            System.out.print("Enter Student ID: ");
            int id = safeInt();
            list.add(new Student(n, id));
            System.out.print("You wanna add more? (y/n): ");
            again = in.nextLine();
        }
        while (again.equalsIgnoreCase("y"));
    }

    static void enterGrades()     //Used enterGrades() function to enter the grades
    {
        if (list.isEmpty())
        {
            System.out.println("No students.");
            return;
        }
        System.out.print("Student name: ");
        String nm = in.nextLine();
        for (Student s : list)
        {
            if (s.name.equals(nm))
            {
                for (int i = 0; i < 5; i++)
                {
                    System.out.print("Grade " + (i+1) + ": ");
                    s.setGrade(i, safeDouble());
                }
                return;
            }
        }
        System.out.println("Not found.");
    }

    static void showAll()         // used showALL() function to show the available data
    {
        if (list.isEmpty()) System.out.println("No data.");
        else for (Student s : list) System.out.println(s);
    }

    static void utilities()
    {
        System.out.println("\nUtils:\n1.Operator\n2.Casting\n3.Countdown");
        String c = in.nextLine();
        switch (c)
        {
            case "1": operators();
            break;
            case "2": casting();
            break;
            case "3":
                System.out.print("Number: ");
                countdown(safeInt());
                break;
            default: System.out.println("??");
        }
    }

    static void operators()     //used to operate the arithmetical computations
    {
        System.out.println("2 + 3 * 4 = " + (2 + 3 * 4));
        System.out.println("(2 + 3) * 4 = " + ((2 + 3) * 4));
    }

    static void casting()
    {
        int a = 45;
        double b = a;
        double x = 78.9;
        int y = (int)x;
        System.out.println("int->double " + b);
        System.out.println("double->int " + y);
    }

    static void countdown(int n)
    {
        if (n < 0) { System.out.println("negatives no!"); return; }
        if (n == 0) { System.out.println("0...Done"); return; }
        System.out.println(n);
        countdown(n - 1);
    }

    // quick helpers for input
    static int safeInt()
    {
        while (true)
        {
            try
            {
                return Integer.parseInt(in.nextLine());
            }
            catch (Exception e)
            {
                System.out.print("Enter only integer please: ");
            }
        }
    }
    static double safeDouble()
    {
        while (true)
        {
            try
            {
                return Double.parseDouble(in.nextLine());
            }
            catch (Exception e)
            {
                System.out.print("Enter number please: ");
            }
        }
    }
}
