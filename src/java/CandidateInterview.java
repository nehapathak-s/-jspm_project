import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CandidateInterview extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw;
        response.setContentType("text/html");
        pw =response.getWriter();
       
        String date=request.getParameter("showdate");
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String branch=request.getParameter("branch");
        String tech=request.getParameter("tech");
        String apty=request.getParameter("apty");
        String hr=request.getParameter("hr");
        String tm=request.getParameter("tm");
        String res=request.getParameter("res");
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/jspm_db";
                   String user="root";
                   String Password="";
                   
            Connection con= DriverManager.getConnection(url,user,Password);
            String query="Insert into interview values(?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt=con.prepareStatement(query);
            
            pstmt.setString(1,date);
            pstmt.setString(2,fname);
            pstmt.setString(3,lname);
            pstmt.setString(4,branch);
            pstmt.setString(5,tech);
            pstmt.setString(6,apty);
            pstmt.setString(7,hr);
            pstmt.setString(8,tm);
            pstmt.setString(9,res);
            
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
