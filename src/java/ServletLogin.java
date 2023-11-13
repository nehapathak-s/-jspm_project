
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class ServletLogin extends HttpServlet 
{    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException 
    {
       PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        
       String uname=req.getParameter("uname");
       String pass=req.getParameter("pass");
       
       if(uname.equals("admin") && pass.equals("admin123"))
       {
           res.sendRedirect("Dashboard.html");
       }
       else
       {
           out.print("<br> <h2> Invalid User </h2> ");
       }
          
    }
}
