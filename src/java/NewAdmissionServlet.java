import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewAdmissionServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw;
        response.setContentType("text/html");
        pw =response.getWriter();
       
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String branch=request.getParameter("branch");
        String cast=request.getParameter("cast");
        String fees=request.getParameter("fees");
        String phoneno=request.getParameter("phoneno");
        String email=request.getParameter("email");
        String add=request.getParameter("add");
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/jspm_db";
                   String user="root";
                   String Password="";
                   
            Connection con= DriverManager.getConnection(url,user,Password);
            String query="Insert into new_admission values(?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt=con.prepareStatement(query);
            
            
            pstmt.setString(1,fname);
            pstmt.setString(2,lname);
            pstmt.setString(3,branch);
            pstmt.setString(4,cast);
            pstmt.setString(5,fees);
            pstmt.setString(6,phoneno);
            pstmt.setString(7,email);
            pstmt.setString(8,add);
            
            
            int x=pstmt.executeUpdate();
                if(x==1)
                {
                    response.sendRedirect("success.html");
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
       
    }
}
