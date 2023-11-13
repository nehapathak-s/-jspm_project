import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DashboardOwner extends HttpServlet 
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
                   PreparedStatement ps_adm=con.prepareStatement("select * from new_admission");
                   PreparedStatement ps_pcash=con.prepareStatement("select * from petty_cash");
                   
                   
            
                     ResultSet rs_adm=ps_adm.executeQuery();
                     ResultSet rs_pcash=ps_pcash.executeQuery();
                     
                     int tot_fees=0;
                     int tot_pcash=0;
                     
                     while(rs_adm.next())
                     {
                         tot_fees=tot_fees+Integer.parseInt(rs_adm.getString(5));
                     }    
                     
                     while(rs_pcash.next())
                     {
                         tot_pcash=tot_pcash+rs_pcash.getInt(6);
                     }    
                     
                    int income_amt= tot_fees-tot_pcash; 
                     
                   out.print("<center><table width=70%  cellpadding=5 border=1 style='margin-top:50px'>");
                   out.print("<h1>JSPM Campus</h1>");
                   out.print("<p>JSPM Campus</p>");
                    
                      out.println("<tr bgcolor='gold'>");
                      out.print("<th><h2>Receipt Amount</h2></th>");
                      out.print("<th><h2>Expences Amount</h2></th>");
                      out.print("<th><h2>Income Amount</h2></th>");
                      out.println("</tr>");
                      
                      
                      out.println("<tr>");
                      out.print("<th><h3>"+tot_fees+"</h3></th>");
                      out.print("<th><h3>"+tot_pcash+"</h3></th>");
                      out.print("<th><h3>"+income_amt+"</h3></th>");
                      out.println("</tr>");
                     
                     
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
