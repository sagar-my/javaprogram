import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class register extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res){
        try{
            res.setContentType("text/html");
            String a=req.getParameter("first_name");
            String b=req.getParameter("last_name");
            String c=req.getParameter("email");
            String d=req.getParameter("job_role");
            String e=req.getParameter("address");
            String f=req.getParameter("City");
            String g=req.getParameter("Pincode");
            
            PrintWriter pw=res.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysagar","root","");
        PreparedStatement pst=con.prepareStatement("insert into information values(?,?,?,?,?,?,?)");
                    pst.setString(1,a);
pst.setString(2,b);
pst.setString(3,c);
pst.setString(4,d);
pst.setString(5,e);
pst.setString(6,f);
pst.setString(7,g);
int u=pst.executeUpdate();
if(u>0)
res.sendRedirect("wel.html");
        }
        catch(Exception ett){
            try
{
PrintWriter out=res.getWriter();

out.print(ett);
}
catch(Exception et)
{

}
        }
        
    }
}