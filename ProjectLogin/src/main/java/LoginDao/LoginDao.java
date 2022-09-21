package LoginDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import DBconnection.DBconnection;
import LoginBean.LoginBean;

public class LoginDao {
	
	public String namedb ="";

	public String authenticateUser(LoginBean loginBean)
	{
	    String userName = loginBean.getUserName();
	    String password = loginBean.getPassword();
	    
	    Connection con = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	 
	    String nameDB="";
	    String userNameDB = "";
	    String passwordDB = "";
	    String roleDB = "";
	    //String name="";
	    
	    try
	    {
	        con = DBconnection.createConnection();
	        statement = (Statement) con.createStatement();
	        resultSet = statement.executeQuery("select name, username, password, role from loginpage");
	 
	        while(resultSet.next())
	        {
	            userNameDB = resultSet.getString("username");
	            passwordDB = resultSet.getString("password");
	            roleDB = resultSet.getString("role");
	            nameDB = resultSet.getString("name");
	            //System.out.println(roleDB);
	 
	            if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("manager")) {
	    
	            //System.out.println(nameDB);
	            namedb = nameDB;
	            
	            return "Manager_Role";
	            }
	            else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("user")) {
		        //System.out.println(userName);
	            namedb = nameDB;
		        return "User_Role";
	            }
	        }
	        
	    }
	    catch(SQLException e)
	    {
	        e.printStackTrace();
	    }
	    return "Invalid userid or password";
	}

}
