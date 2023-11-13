import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletNewUser extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw;
        response.setContentType("text/html");
        pw =response.getWriter();
       
        
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String uname=request.getParameter("uname");
        String pass=request.getParameter("pass");
//        String rpass=request.getParameter("rpass");
        String phoneno=request.getParameter("phoneno");
        String email=request.getParameter("email");
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/jspm_db";
                   String user="root";
                   String Password="";
                   
            Connection con= DriverManager.getConnection(url,user,Password);
            String query="Insert into newuser values(?,?,?,?,?,?);";
            PreparedStatement pstmt=con.prepareStatement(query);
            
            
            pstmt.setString(1,fname);
            pstmt.setString(2,lname);
            pstmt.setString(3,uname);
            pstmt.setString(4,pass);
//            pstmt.setString(5,rpass);
            pstmt.setString(5,phoneno);
            pstmt.setString(6,email);
            
            
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
