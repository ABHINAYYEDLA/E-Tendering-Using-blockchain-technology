import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class log3 extends HttpServlet{

 public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		  String uname,tid,price,tname,minamt,experience;
		  
		  PrintWriter out=response.getWriter();
		  //PreparedStatement pt=null;
		  try{
				response.setContentType("text/html");
   				uname=request.getParameter("uname");
				tid=request.getParameter("htmlid");
				price=request.getParameter("price");
				tname=request.getParameter("tname");
				minamt=request.getParameter("minamt");
				experience=request.getParameter("experience");
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				//Directory and file creation
				File dir=new File("D:\\"+uname);//change the directory name to some different folder
					 if (!dir.exists())
					    {
           					if (dir.mkdir())
							 {
               						   out.println("Directory is created!");
           						 }
							else 
							 {
               						 out.println("Failed to create directory!");
         					      }
       				     }//directory creation	

					 else
					 {
						  if(dir.isDirectory())
						 {
							 File[] files = dir.listFiles();
							 if(files.length==0)
							 {
								 //the folder is empty need to create a new file
								 File file=new File("C:\\1.txt");             //path name should be changed
								 if (file.createNewFile())
								 {
									//the tender details should be kept here in this file
									FileWriter writer = new FileWriter(file);
									writer.write("Username:"+uname);
									writer.write("\nTender Id:"+tid);
									writer.write("\nTender Name:"+tname);
									writer.write("\nQuoataion Price:"+price);
									writer.write("\nMinimum amount:"+minamt);
									writer.write("\nCompany experience:"+experience);
									writer.write("\nTimestamp:"+timestamp);
									writer.close();
								 }
								 
							 }
						 
					 }
					 }
						
		  }//try
		  catch(Exception e)
		  {
			  out.println(e);
		  }
   }//doget
   // timestamp creation....
   //Timestamp timestamp = new Timestamp(System.currentTimeMillis());

}//log3


