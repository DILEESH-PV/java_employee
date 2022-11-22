import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Scanner;

public class Employee
{
    public static void main(String[] args) {
        int choice,ecode,salary;
        String name,cname,des,email,psd;
        double ph;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the choice");
            System.out.println("1  Add an employee");
            System.out.println("2  View all employee");
            System.out.println("3  Search an employee");
            System.out.println("4  Update an employee");
            System.out.println("5  Delete an employee");
            System.out.println("6  Display employee details by company");
            System.out.println("7  Total number of employee in same designation");
            System.out.println("8  Display  highest salary ");
            System.out.println("9  Display  lowest salary");
            System.out.println("10 Total salary");
            System.out.println("11 Total number of employees");
            System.out.println("12 Exit\n");

            choice = sc.nextInt();
            switch (choice)
             {
                case 1:
                    System.out.println("Enter the employee code");
                    ecode=sc.nextInt();
                    System.out.println("Enter the employee name");
                    name=sc.next();
                    System.out.println("Enter the employee designation");
                    des=sc.next();
                    System.out.println("Enter the salary");
                    salary=sc.nextInt();
                    System.out.println("Enter the company name");
                    cname=sc.next();
                    System.out.println("Enter the phone number");
                    ph=sc.nextDouble();
                    System.out.println("Enter the email id");
                    email=sc.next();
                    System.out.println("Enter the password");
                    psd=sc.next();
                    System.out.println("New employee added");
                    try
                       {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                           String sql="INSERT INTO `employees`(`EmpCode`, `Name`, `Designation`, `Salary`, `CName`, `PhNo`, `Email`, `Password`) VALUES (?,?,?,?,?,?,?,?)";
                           PreparedStatement stmt= con.prepareStatement(sql);
                           stmt.setInt(1,ecode);
                           stmt.setString(2,name);
                           stmt.setString(3,des);
                           stmt.setInt(4,salary);
                           stmt.setString(5,cname);
                           stmt.setDouble(6,ph);
                           stmt.setString(7,email);
                           stmt.setString(8,psd);
                           stmt.executeUpdate();
                       }
                    catch (Exception e)
                      {
                        System.out.println(e);
                      }
                    break;
                case 2:
                    System.out.println("Selected view all employees");
                    try
                     {
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                         String sql="SELECT `EmpCode`, `Name`, `Designation`, `Salary`, `CName`, `PhNo`, `Email`, `Password` FROM `employees`";
                         Statement stmt= con.createStatement();
                         ResultSet rs= stmt.executeQuery(sql);
                         while(rs.next())
                         {
                             String getEmpcode = rs.getString("EmpCode");
                             String getName = rs.getString("Name");
                             String getDesignation = rs.getString("Designation");
                             String getSalary = rs.getString("Salary");
                             String getCompneyname = rs.getString("CName");
                             String getPh = rs.getString("PhNo");
                             String getEmail = rs.getString("Email");
                             System.out.println("Employee Code     : " + getEmpcode);
                             System.out.println("Name              : " + getName);
                             System.out.println("Designation       : " + getDesignation);
                             System.out.println("Salary            : " + getSalary);
                             System.out.println("Compney Name      : " + getCompneyname);
                             System.out.println("Ph No             : " + getPh);
                             System.out.println("Email             : " + getEmail+"\n");
                         }}
                    catch (Exception e)
                     {
                         System.out.println(e);
                     }
                    break;
                case 3:
                    System.out.println("Enter the employee code for search an employee");
                    int ec=sc.nextInt();
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                        String sql="SELECT `EmpCode`, `Name`, `Designation`, `Salary`, `CName`, `PhNo`, `Email`, `Password` FROM `employees` WHERE`EmpCode`="+ec;
                        Statement stmt= con.createStatement();
                        ResultSet rs= stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            String getEmpcode = rs.getString("EmpCode");
                            String getName = rs.getString("Name");
                            String getDesignation = rs.getString("Designation");
                            String getSalary = rs.getString("Salary");
                            String getCompneyname = rs.getString("CName");
                            String getPh = rs.getString("PhNo");
                            String getEmail = rs.getString("Email");
                            System.out.println("Employee Code     : " + getEmpcode);
                            System.out.println("Name              : " + getName);
                            System.out.println("Designation       : " + getDesignation);
                            System.out.println("Salary            : " + getSalary);
                            System.out.println("Compney Name      : " + getCompneyname);
                            System.out.println("Ph No             : " + getPh);
                            System.out.println("Email             : " + getEmail+"\n");
                        }}
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }


                    break;
                case 4:
                    System.out.println("Enter the employee code");
                    int ec2=sc.nextInt();
                    System.out.println("Enter the employee name to be updated");
                    name=sc.next();
                    System.out.println("Enter the employee designation to be updated");
                    des=sc.next();
                    System.out.println("Enter the salary to be updated");
                    salary=sc.nextInt();
                    System.out.println("Enter the company name to be updated");
                    cname=sc.next();
                    System.out.println("Enter the phone number to be updated");
                    ph=sc.nextDouble();
                    System.out.println("Enter the email id to be updated");
                    email=sc.next();
                    System.out.println("Enter the password to be updated");
                    psd=sc.next();

                    try
                       {

                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                            String sql="UPDATE `employees` SET `Name`='"+name+"',`Designation`='"+des+"',`Salary`='"+salary+"',`CName`='"+cname+"',`PhNo`='"+ph+"',`Email`='"+email+"',`Password`='"+psd+"' WHERE `EmpCode`="+ec2;
                            Statement stmt= con.createStatement();
                            stmt.executeUpdate(sql);
                            System.out.println("updated...");
                       }
                    catch (Exception e)
                       {
                           System.out.println(e);
                       }
                    break;
                case 5:
                        System.out.println("Enter the employee code to be delete");
                        int ec3=sc.nextInt();

                    try
                    {

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                        String sql="DELETE FROM `employees` WHERE`EmpCode`="+ec3;
                        Statement stmt= con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully...");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                 case 6:
                     System.out.println("Enter company name");
                     String cn=sc.next();
                     try {
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                         String sql ="SELECT `EmpCode`, `Name`, `Designation`, `Salary`,`PhNo`, `Email` FROM `employees` WHERE `CName`='"+cn+"'";
                         Statement stmt = con.createStatement();
                         ResultSet rs = stmt.executeQuery(sql);
                         while (rs.next())
                           {
                               String getEmpcode = rs.getString("EmpCode");
                               String getName = rs.getString("Name");
                               String getDesignation = rs.getString("Designation");
                               String getSalary = rs.getString("Salary");
                               String getPh = rs.getString("PhNo");
                               String getEmail = rs.getString("Email");
                               System.out.println("Employee Code     : " + getEmpcode);
                               System.out.println("Name              : " + getName);
                               System.out.println("Designation       : " + getDesignation);
                               System.out.println("Salary            : " + getSalary);
                               System.out.println("Ph No             : " + getPh);
                               System.out.println("Email             : " + getEmail+"\n");

                         }
                     }
                     catch (Exception e)
                     {
                         System.out.println(e);
                     }
                     break;
                 case 7:
                     try {
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                         String sql = "SELECT COUNT(`ID`)`ID`,`Designation` FROM `employees` GROUP BY `Designation`";
                         Statement stmt = con.createStatement();
                         ResultSet rs = stmt.executeQuery(sql);
                         while (rs.next()) {
                             String getId = rs.getString("ID");
                             String getDe = rs.getString("Designation");
                             System.out.println("Count : " + getId + "    " + getDe + "\n");

                         }
                     }
                     catch (Exception e)
                     {
                         System.out.println(e);}break;
                 case 8:
                     try
                     {
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                     String sql = "SELECT MAX(`Salary`)`Salary` FROM `employees` ";
                     Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(sql);
                     while (rs.next())
                     {
                         String getSa = rs.getString("Salary");
                        System.out.println("Highest salary");
                         System.out.println("Salary    : " + getSa+"\n");
                     }
                   }
                   catch (Exception e) {
                       System.out.println(e);
                   }
                     break;
                 case 9:
                     try
                     {
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                         String sql = "SELECT MIN(`Salary`)`Salary` FROM `employees` ";
                         Statement stmt = con.createStatement();
                         ResultSet rs = stmt.executeQuery(sql);
                         while (rs.next())
                         {
                             String getSa = rs.getString("Salary");
                             System.out.println("Lowest salary ");
                             System.out.println("Salary       : " + getSa+"\n");
                         }
                     }
                     catch (Exception e) {
                         System.out.println(e);
                     }
                     break;
                 case 10:
                     try
                     {
                         Class.forName("com.mysql.jdbc.Driver");
                         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                         String sql = "SELECT SUM(`Salary`) `Salary` FROM `employees`";
                         Statement stmt = con.createStatement();
                         ResultSet rs = stmt.executeQuery(sql);
                         while (rs.next())
                         {
                            String getTotal = rs.getString("salary");
                            System.out.println("Total Salary : " +getTotal+"\n" );


                         }
                     }
                     catch (Exception e) {
                         System.out.println(e);
                     }
                     break;
                 case 11:
                     try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                     String sql = "SELECT COUNT(`ID`)`ID`FROM `employees` ";
                     Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery(sql);
                     while (rs.next())
                     {
                         String getEc = rs.getString("ID");
                         System.out.println("Total Employees  : " +getEc+"\n" );

                     }
             }
                     catch (Exception e) {
                System.out.println(e);
            }
            break;

                 case 12:
                    System.exit(0);
                default:
                    System.out.println("please select valid option");

            }

        }
    }
}
