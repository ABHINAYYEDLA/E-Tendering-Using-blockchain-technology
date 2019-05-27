import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class log2 extends HttpServlet{

 public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		  PrintWriter out=response.getWriter();
		  //PreparedStatement pt=null;
		  try{
   response.setContentType("text/html");
   
   out.print("<html> <body background=img.jpg text=green>");
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root"); 
	PreparedStatement st=null;
					String htmlid=request.getParameter("htmlid");
					st = con.prepareStatement("SELECT * FROM tenderinfo where tid=?"); 
					st.setString(1,htmlid);
					ResultSet rs=st.executeQuery();
					out.print("<form action=log3.com method=post>");
					//out.print(<table align=center border=0>);
					out.print("<input type=hidden id=uname value="+request.getParameter("uname")+">");
					while(rs.next())
						{
	  
						     
							out.print("<table align=center border=0>");
							out.print("<tr><td>TENDER ID : </td>	   <td> <input type=text name=tid value="+htmlid+"readonly=readonly </td></tr>");
							out.print("<tr><td>TENDER NAME :</td>	   <td> <input type=text name=tname value="+rs.getString(1)+"readonly=readonly </td></tr>");
							out.print("<tr><td>MINIMUM AMOUNT: </td>	   <td> <input type=text name=minamnt value="+rs.getInt(5)+"readonly=readonly </td></tr>");
							out.print("<tr><td>QUOTING PRICE : </td>		   <td><input type=text name=price></td></tr>");
							out.print("<tr><td>COMPANY EXPERIENCE: </td>	   <td><input type=text name=experience></td></tr>");
							  
						}
						out.print("<tr><td></td><td><input type=submit value=submit> </td></tr>");
							out.print("</table></form></body></html>"); 			   
		
		  }//try
		  catch(Exception e)
		  {
			  out.println(e);
		  }
   }//doget
   // timestamp creation....
   //Timestamp timestamp = new Timestamp(System.currentTimeMillis());

}//log2

