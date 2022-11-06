import java.util.Scanner;

public class Employee
{
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the choice");
            System.out.println("1 add an employee");
            System.out.println("2 view all employee");
            System.out.println("3 search an employee");
            System.out.println("4 update the employee");
            System.out.println("5 delete an employee");
            System.out.println("6 exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Selected add employee");
                    break;
                case 2:
                    System.out.println("Selected view all employees");
                    break;
                case 3:
                    System.out.println("Selected search an employee");
                    break;
                case 4:
                    System.out.println("Selected update employee");
                    break;
                case 5:
                    System.out.println("Selected delete employee");
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("please select valid option");

            }

        }
    }
}
