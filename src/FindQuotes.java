

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

public class FindQuotes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Connection con;
	        Class.forName("com.mysql.jdbc.Driver");
	        String path = "jdbc:mysql://localhost:3306/FindQu";
	        String user = "root";
	        String password = "montu";
	        con = DriverManager.getConnection (path, user, password);
	        Statement st = con.createStatement ();
			PrintWriter out = response.getWriter();
			//String FindQuotes = request.getParameter("quotes");
			out.println("<html><head>");
			out.println("<title>Resutl for Word</title>");
			out.println("<style type=text/css>body{background-image:url(images/bg.jpg);");
			out.println("background-repeat:repeat-x;}</style>");
			out.println("</head><body>");
			out.println("<table border=0 align=center>");
			out.println("<tr><td colspan=2 ><img src=\"images/banner.jpg\"/></td></tr>");
			out.println("<tr><th>Quotes</th><th>Author</th></tr>");
			String SQLQ = "select * from Quotes where quote like '%"+request.getParameter("quotes")+"%';";
			ResultSet rs1 = st.executeQuery (SQLQ);
			String col1,col2;
			
			while (rs1.next ()){
				
				col1 = rs1.getString(1);
				if(col1==null){
					out.println("<tr><td><h3>Sorry No result  Found</h3></td></tr>");
				}
				col2 = rs1.getString(2);
				out.println("<tr><td>"+col1+"</td><td>"+col2+"</td></tr>");
			}
			
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
