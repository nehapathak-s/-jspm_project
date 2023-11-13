import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PettyCashServlet extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter pw;
        response.setContentType("text/html");
        pw =response.getWriter();
       
        
        String pdate=request.getParameter("pdate");
        String pday=request.getParameter("pday");
        String pname=request.getParameter("pname");
        String rate=request.getParameter("rate");
        String qty=request.getParameter("qty");
        String bill=request.getParameter("bill");
        String pfrom=request.getParameter("pfrom");
        String pby=request.getParameter("pby");
        String purpose=request.getParameter("purpose");
        String aby=request.getParameter("aby");
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
                   String url="jdbc:mysql://localhost:3306/jspm_db";
                   String user="root";
                   String Password="";
                   
            Connection con= DriverManager.getConnection(url,user,Password);
            String query="Insert into petty_cash values(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pstmt=con.prepareStatement(query);
            
            
            pstmt.setString(1,pdate);
            pstmt.setString(2,pday);
            pstmt.setString(3,pname);
            pstmt.setString(4,rate);
            pstmt.setString(5,qty);
            pstmt.setString(6,bill);
            pstmt.setString(7,pfrom);
            pstmt.setString(8,pby);
            pstmt.setString(9,purpose);
            pstmt.setString(10,aby);
            
            
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
