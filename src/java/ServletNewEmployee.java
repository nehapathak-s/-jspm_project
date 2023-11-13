import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletNewEmployee extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw;
        response.setContentType("text/html");
        pw =response.getWriter();
       
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String job=request.getParameter("job");
        String phoneno=request.getParameter("phoneno");
        String email=request.getParameter("email");
        String add=request.getParameter("add");
        String cname=request.getParameter("cname");
        String sal=request.getParameter("sal");
        String exp=request.getParameter("exp");
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/jspm_db";
                   String user="root";
                   String Password="";
                   
            Connection con= DriverManager.getConnection(url,user,Password);
            String query="Insert into newemp values(?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt=con.prepareStatement(query);
            
            
            pstmt.setString(1,fname);
            pstmt.setString(2,lname);
            pstmt.setString(3,job);
            pstmt.setString(4,phoneno);
            pstmt.setString(5,email);
            pstmt.setString(6,add);
            pstmt.setString(7,cname);
            pstmt.setString(8,sal);
            pstmt.setString(9,exp);
            
            
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
