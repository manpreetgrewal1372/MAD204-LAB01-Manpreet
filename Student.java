/**
 * F2025 MAD204-01 - Lab 1
 * Name: Manpreet Singh (A00198842)
 * Date: 2025-09-16
 * Student class to hold student info and grades.
 */


/**
 * Represents a student with id, name, and an array of grades.
 * Provides methods to set grades, compute average, and return letter grade.
 */
public class Student
{
    String name;
    int id;
    double[] grades = new double[5];

    public Student(String n, int i)
    {
        name = n;
        id = i;
    }

    // put grade into array (0..4)
    public void setGrade(int index, double val)
    {
        if (index >= 0 && index < grades.length)
        {
            grades[index] = val;
        }
    }


    /**
     * Calculates the average of the five grades.
     * @return average grade as double
     */
    public double average()    //Used to find average of all grades
    {
        double total = 0;
        for (double g : grades) total += g;
        return total / grades.length;
    }

    public char letterGrade()
    {
        double avg = average();
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        return 'F';
    }

    public String toString()
    {
        return "ID:" + id + ", Name:" + name +
                ", Avg:" + String.format("%.1f", average()) +
                " (" + letterGrade() + ")";
    }
}
