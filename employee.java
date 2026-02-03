import java.util.Scanner;
abstract class employee1 {
    protected String name;
    protected double baseSalary;

    employee1(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    abstract double calculateSalary();
    void displayDetails() {
        System.out.println("\nPayroll Details:");
        System.out.println("Name: " + name);
        System.out.println("Role: " + this.getClass().getSimpleName());
        System.out.println("Final Salary: " + (int) calculateSalary());
    }
}


class Developer extends employee1 {
    Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    
    double calculateSalary() {
        return baseSalary * 1.10; 
    }
}
class Manager extends employee1 {
    Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    
    double calculateSalary() {
        return baseSalary * 1.20 + 5000; 
    }
}


public class employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Employee Type:");
        System.out.println("1. Developer");
        System.out.println("2. Manager");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Base Salary: ");
        double salary = sc.nextDouble();

        employee1 emp;
        if (choice == 1) {
            emp = new Developer(name, salary);
        } else if (choice == 2) {
            emp = new Manager(name, salary);
        } else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }

        emp.displayDetails();
        sc.close();
    }
}


