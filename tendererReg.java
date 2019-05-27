import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class tendererReg extends HttpServlet
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
		 String fstat= request.getParameter("fstat");
		 String nm="T";
		 for(int i=0;i<email.length();i++)
		 {
			 if(email.charAt(i)=='@')
			 {
				 break;
			 }
			 nm=nm+email.charAt(i);
		 }
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");  
		 Statement stmt=con.createStatement();
		 
		int i = stmt.executeUpdate("insert into tenderer values('"+cname+"', '"+mobile+"', '"+email+"','"+dor+"','"+nm+"','"+Pan+"', '"+addr+"', '"+Pan+"',, '"+fstat+"')");
		 out.println("Your User Name is:"+nm);
		 }//try
		 catch(Exception e)
		 {
			out.println(e);
		 }
	}//doPost
	
}//tendererReg
	