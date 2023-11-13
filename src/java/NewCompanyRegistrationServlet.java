import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewCompanyRegistrationServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw;
        response.setContentType("text/html");
        pw =response.getWriter();
       
        
        String rdate=request.getParameter("rdate");
        String cname=request.getParameter("cname");
        String hrname=request.getParameter("hrname");
        String hrphoneno=request.getParameter("hrphoneno");
        String hremail=request.getParameter("hremail");
        String cadd=request.getParameter("cadd");
        String cdate=request.getParameter("cdate");
        String rby=request.getParameter("rby");
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/jspm_db";
                   String user="root";
                   String Password="";
                   
            Connection con= DriverManager.getConnection(url,user,Password);
            String query="Insert into new_company values(?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt=con.prepareStatement(query);
            
            
            pstmt.setString(1,rdate);
            pstmt.setString(2,cname);
            pstmt.setString(3,hrname);
            pstmt.setString(4,hrphoneno);
            pstmt.setString(5,hremail);
            pstmt.setString(6,cadd);
            pstmt.setString(7,cdate);
            pstmt.setString(8,rby);
            
            
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
