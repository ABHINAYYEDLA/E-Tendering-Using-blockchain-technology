import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class clientReg extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{ 
   	  PrintWriter out=response.getWriter();
	  response.setContentType("text/html");
	  try{
			
         String cname= request.getParameter("Cname");
		 int mobile=Integer.parseInt(request.getParameter("mno"));
		 int dor= Integer.parseInt(request.getParameter("dor"));
		 String addr= request.getParameter("addr");
		 String email= request.getParameter("email");
		 String Pan= request.getParameter("Pan");
		 Class.forName("com.mysql.jdbc.Driver");
		 String nm="C";
		 for(int i=0;i<email.length();i++)
		 {
			 if(email.charAt(i)=='@')
			 {
				 break;
			 }
			 nm=nm+email.charAt(i);
		 }
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");  
		 Statement stmt=con.createStatement();
		 
		 int i = stmt.executeUpdate("insert into clientcompany values('"+cname+"', '"+mobile+"', '"+email+"','"+dor+"','"+nm+"','"+Pan+"', '"+addr+"', '"+Pan+"')");
		 out.println("Your User Name is: "+nm);
		 
		 }//try
		 catch(Exception e)
		 {
			out.println(e);
		 }
	}//doPost
	
}//clientReg
		 


























