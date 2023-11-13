import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DisplayPettyCashServlet extends HttpServlet 
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
                   PreparedStatement ps=con.prepareStatement("select * from petty_cash");
                   
                   
                   out.print("<center><table width=100%  cellpadding=5 border=1>");
                   out.print("<h1>Petty Cash Details</h1>");
                    
                     
                     ResultSet rs=ps.executeQuery();
                     
                     ResultSetMetaData rsmd=rs.getMetaData();
                     int total=rsmd.getColumnCount();
                     
                     out.println("<tr bgcolor='gold'>");

                   
                      out.print("<th>Purchased Date</th>");
                      out.print("<th>Purchased Day</th>");
                      out.print("<th>ProducT Name</th>");
                      out.print("<th>Rate</th>");
                      out.print("<th>Quantity</th>");
                      out.print("<th>Bill Amount</th>");
                      out.print("<th>Purchased From</th>");
                      out.print("<th>Purchased By</th>");
                      out.print("<th>Purpose Of Purchase</th>");
                      out.print("<th>Approval By</th>");
                      
                     
                      
                     
                      out.println("<tr>");
                      
                     while(rs.next())
                     {
                         out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td></tr>");
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
