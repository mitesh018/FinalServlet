

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			final String user ="admin";
			final String pass="admin";
			Connection con;
	        Class.forName("com.mysql.jdbc.Driver");
	        String path = "jdbc:mysql://localhost:3306/FindQu";
	        String sqluser = "root";
	        String sqlpassword = "montu";
	        con = DriverManager.getConnection (path, sqluser, sqlpassword);
	        Statement st = con.createStatement ();
			PrintWriter out = response.getWriter();
			String UserName = request.getParameter("username");
			String Password = request.getParameter("password");
			String author = request.getParameter("author");
			String qu = request.getParameter("qu");
			if(author != null){
				UserName = "admin";
				Password = "admin";
				String SQLQ = "insert into quotes (quote,author) values("+
				"\"" + qu + "\"" + "," +
				"\"" + author+ "\""  +
	            ")";
				st.executeUpdate(SQLQ);
			}
			out.println("<html><head>");
			out.println("<title>Resutl for Word</title>");
			out.println("<style type=text/css>body{background-image:url(images/bg.jpg);}input{color:#ff0000;font-face:Calibri;font-weight:bold;}span{font-face:Calibri;font-size: 20px;}");
			out.println("background-repeat:repeat-x;}</style>");
			out.println("</head><body>");
			out.println("<table border=0 align=center>");
			out.println("<tr><td colspan=2 ><img src=\"images/banner.jpg\"/></td></tr>");
			out.println("<form action=AdminControl  method=POST>");
			if(user.equals(UserName)&& pass.equals(Password))
			{
				out.println("<tr><th align=right>Quotes</th><th align =left>Author</th></tr>");
				out.println("<tr><td align=right><input type=text name=qu size=50></td> <td aligne=left><input type=text name=author></td></tr>");
				out.println("<tr><td align=right><input type=submit value=Add name=Add></td></tr>");
				
			}
			else
			{
				out.println("<tr><td><span>UserName :-</span></td><td><input type=\"text\" name=\"username\" id=\"username\"></td></tr>");
				out.println("<tr><td><span>Password :-</span></td><td><input type=\"password\" name=\"password\" id=\"password\"></td></tr>");
				out.println("<tr><td><input type=submit value=\"Enter\"></td></tr>");
			}
			
			out.println("</form>");
			out.println("</table>");
			
			out.println("</body></html>");
			out.close();
}
			catch(ClassNotFoundException e){System.out.println(e);}
			catch(SQLException e){System.out.println(e);}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
