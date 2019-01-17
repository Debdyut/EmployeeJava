import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	//Employee emp=new Employee();

    String databaseURL = "jdbc:ucanaccess://d://Database//Employee.accdb";

    //Create Employee
    public boolean createEmp(Employee e)

    {                 

        try(Connection connection = DriverManager.getConnection(databaseURL)) {

       

			String sql = "INSERT into Employee (Employee_ID,Employee_Name, Employee_Age, Phone_Number) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, e.getEmpId());
			preparedStatement.setString(2,e.getName());
			preparedStatement.setInt(3, e.getAge());
			preparedStatement.setString(4, e.getPhNo());
			
			int row=preparedStatement.executeUpdate();

	        if(row>0)	{
	        	System.out.println("Entered successfully");        
	            return true;
	       }
	       else
	       {
	           System.out.println("Error");
	           return false;
	       }

        }
        catch(Exception ex)	{
        	ex.printStackTrace();
        }

        return false;      

    }

   

   

    //Fetch/Select data by attribute

   

    public Employee fetchEmpbyId(int empId)

    {

                    Employee e=new Employee();

                   

                    try(Connection connection = DriverManager.getConnection(databaseURL))

                    {

                                    String sql="select * from Employee where Employee_ID=?";

                                   

                                    PreparedStatement statement=connection.prepareStatement(sql);

                                    ResultSet rs=statement.executeQuery();

                                    statement.setInt(1, e.getEmpId());

                                    while(rs.next())

                                    {

                                                                   

                                                    e.setEmpId(rs.getInt("Employee_ID"));

                                    }

                                   

                    }

                    catch(Exception ex)

                    {

                                    ex.printStackTrace();

                    }

                    return e;

    }

   

    //Fetch all data and store in List

   

    public List<Employee> fetchAllEmployee() throws SQLException

    {

                    List<Employee> employeeList=new ArrayList<>();

                    try(Connection connection = DriverManager.getConnection(databaseURL))

                    {

                                   

                                    String sql="Select * from Employee";

                                   

                                    Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery(sql);

               

                while(rs.next())

                {

                   Employee e=new Employee();

                  

                   e.setEmpId(rs.getInt("Employee_ID"));

                   e.setName(rs.getString("Employee_Name"));

                   e.setAge(rs.getInt("Employee_Age"));

                   e.setPhNo(rs.getString("Phone_Number"));

                  

                   employeeList.add(e);

                  

                }

                

                    }

                    return employeeList;

                   

    }

   

    //Delete Employee

   

    public boolean deleteEmployee(int empId) throws SQLException

    {

                    boolean status =false;

                    Employee e=new Employee();

                    try(Connection connection = DriverManager.getConnection(databaseURL))

                    {

                                      String query = "delete from Employee where Employee_ID = ?";

                                     

                                      PreparedStatement preparedStmt=connection.prepareStatement(query);

                                      preparedStmt.setInt(1, e.getEmpId());

                                     

                                    int deletedRow=  preparedStmt.executeUpdate();

                                     

                                     status=(deletedRow==1?true:false);

                                   

                    }

                    catch(Exception ex)

                    {

                                    ex.printStackTrace();

                    }

                    return status;

                   

    }

   

    //Update Employee

   

    public boolean UpdateEmp(Employee e) throws SQLException

    {

                    try(Connection connection = DriverManager.getConnection(databaseURL))

                    {

                                   

                                    String query = "update Employee set Employee_ID = ?";

                                   

                                     PreparedStatement preparedStmt=connection.prepareStatement(query);

                                   

                                     preparedStmt.setInt(1,e.getEmpId());

                                   

                                    int rowUpdated =preparedStmt.executeUpdate();

                                    connection.close();

                                     

                                     if(rowUpdated>0)

                                                   {

                                                                   System.out.println("Updated successfully");       

                                                                   return true;

                                                   }

                                                   else

                                                   {

                                                                   System.out.println("Error in updating");

                                                                   return false;

                                                                  

                                                    }

                    }

                   

                    catch(Exception ex)

                    {

                                    ex.printStackTrace();

                    }

                   

                    return false;

                   

    }
	
}
