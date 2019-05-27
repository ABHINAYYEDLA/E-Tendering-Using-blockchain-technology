import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class clientTenderer extends HttpServlet{

 public void doGet(HttpServletRequest req, HttpServletResponse response)
      throws ServletException, IOException {
   response.setContentType("text/html");
   PrintWriter out=response.getWriter();
   String direction=req.getParameter("btn");
   if(direction.equals("ClientReg"))
   {
	  
	   out.print("<html> <body background=img.jpg text=white>");

out.print("<form action=clientReg.com method=post>");
	 
out.print("<table align=center border=0>");
out.print("<tr><td>Enter Company Name : </td>	   <td><input type=text name=Cname></td></tr>");
out.print("<tr><td>Enter Mobile No : </td>	   <td><input type=text name=mno></td></tr>");
out.print("<tr><td>Enter Email : </td>	   <td><input type=text name=email></td></tr>");
out.print("<tr><td>Enter Date of Registration : </td>	   <td><input type=text name=dor></td></tr>");
out.print("<tr><td>Enter Company Address : </td>	   <td><input type=text name=addr></td></tr>");
out.print("<tr><td>Enter Pan Number: </td>	      <td><input type=text  name=Pan></td></tr>");

out.print("<tr><td></td><td><input type=submit value=submit> </td></tr>");

out.print("</table></form></body></html>");   out.close();

	   
   }
	   
   else if(direction.equals("TendererReg"))
   {
	   
	   out.print("<html> <body background=img.jpg text=white>");

out.print("<form action=tendererReg.com method=post>");

	 
out.print("<table align=center border=0>");
out.print("<tr><td>Enter Company Name : </td>	   <td><input type=text name=Cname></td></tr>");


 out.print("<tr><td>Enter RegistrationId : </td>		   <td><input type=text name=Rid></td></tr>");
out.print("<tr><td>Enter Company Address : </td>	   <td><input type=text name=aadr></td></tr>");
out.print("<tr><td>Enter Email : </td>	   <td><input type=text name=email></td></tr>");
 out.print("<tr><td>Enter Pan Number: </td>	      <td><input type=text  name=Pan></td></tr>");
  out.print("<tr><td>Enter Financial Status: </td>	      <td><input type=text  name=fstat></td></tr>");

out.print("<tr><td></td><td><input type=submit value=submit> </td></tr>");

out.print("</table></form></body></html>");   out.close();   
   }
   }
}