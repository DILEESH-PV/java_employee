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
            System.out.println("1 add an employee");
            System.out.println("2 view all employee");
            System.out.println("3 search an employee");
            System.out.println("4 update the employee");
            System.out.println("5 delete an employee");
            System.out.println("6 exit");
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
                    System.exit(0);
                default:
                    System.out.println("please select valid option");

            }

        }
    }
}
