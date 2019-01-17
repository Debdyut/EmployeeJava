import java.sql.SQLException;
import java.util.*;


public class EmployeeOperations {

	public static void main(String args[]) throws SQLException

    {

           Scanner sc=new Scanner(System.in);
           EmployeeDAO empDAO=new EmployeeDAO();
           Employee e=new Employee(1009,"Shruti",30,"9125436528");
           System.out.println("Enter your choice: \n 1. Create new Employee \n 2. Fetch detail by Emmployee ID \n 3. Fetch all employee details \n 4. Delete an employee \n 5. Update details ");
           int choice=Integer.parseInt(sc.nextLine());
           if(choice<6 && choice>0)
           {
        	   switch(choice)

           {

           case 1:

           //Create

           System.out.println("Addition of a new Employee: ");

          

           empDAO.createEmp(e);

           break;



           //Fetch

           case 2:

           System.out.println("Fetch Employee by ID");

          

           System.out.println("Enter the employee ID: ");

           int id=Integer.parseInt(sc.nextLine());

          

           if(e.getEmpId()==id)

           {

                  System.out.println("Employee found");

                  System.out.println(empDAO.fetchEmpbyId(id));

           }

           else

           {

                  System.out.println("Employee not found");

           }

           break;

          

           //Fetch all Data

           case 3:

           System.out.println("Fetch all Data");

          

           empDAO.fetchAllEmployee();

           break;

          

           //Delete an employee

           case 4:

          

           System.out.println("Delete the data");

           System.out.println("Enter the employee ID: ");

           int eid=Integer.parseInt(sc.nextLine());

          

           if(e.getEmpId()==eid)

           {

                  System.out.println("Employee Deleted");

                  empDAO.deleteEmployee(eid);

           }

           else

           {

                  System.out.println("Employee not found");

           }

          

           break;

   

           //Update detail

           case 5:

           System.out.println("Update the data");

          

           System.out.println("Enter the employee Id: ");

           int n=Integer.parseInt(sc.nextLine());

          

           if(e.getEmpId()==n)

           {

                  /*System.out.println("Enter the field you want to update : \n 1. Name \n 2. Age \n 3.Phone Number");

                  int ch=Integer.parseInt(sc.nextLine());

                  if(ch==1)

                  {

                        System.out.println("Enter the name: ");

                        String name=sc.nextLine();

                        e.setName(name);

                        empDAO.UpdateEmp(e);

                       

                  }*/

                  System.out.println("Updated ");

                  empDAO.UpdateEmp(e);

           }

           else

                  System.out.println("Not found");

          

   

           break;

    }

   

           }

           else

           {

                  System.out.println("Invalid Choice entered");

           }

}
	
}
