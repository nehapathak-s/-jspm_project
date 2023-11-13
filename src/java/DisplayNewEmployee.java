import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayNewEmployee extends HttpServlet 
{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();
       
       
        try
        {
                   Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/jspm_db";
                   String user="root";
                   String Password="";
                   
                   Connection con= DriverManager.getConnection(url,user,Password);
                   PreparedStatement ps=con.prepareStatement("select * from newemp");
                   
                   
                   out.print("<center><table width=100%  cellpadding=5 border=1>");
                   out.print("<h1>New Employee Details</h1>");
                    
                     
                     ResultSet rs=ps.executeQuery();
                     
                     ResultSetMetaData rsmd=rs.getMetaData();
                     int total=rsmd.getColumnCount();
                     
                     out.println("<tr bgcolor='gold'>");

                   
                      out.print("<th>First Name</th>");
                      out.print("<th>Last Name</th>");
                      out.print("<th>Job</th>");
                      out.print("<th>Phone No</th>");
                      out.print("<th>Email</th>");
                      out.print("<th>Local_Adress</th>");
                      out.print("<th>Pre_Comp_Name</th>");
                      out.print("<th>Pre_Salary</th>");
                      out.print("<th>Experience</th>");
                     
                      
                     
                      out.println("<tr>");
                      
                     while(rs.next())
                     {
                         out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td></tr>");
                     }    
                     
                     
                     out.print("<table></center>");
       
                                             
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            out.close();
        }    
        
       
    
    }
  
    
}
