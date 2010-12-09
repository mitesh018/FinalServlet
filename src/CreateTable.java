

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

public class CreateTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Connection con;
	        Class.forName("com.mysql.jdbc.Driver");
	        String path = "jdbc:mysql://localhost:3306/FindQu";
	        String user = "root";
	        String password = "montu";
	        con = DriverManager.getConnection (path, user, password);
	        Statement st = con.createStatement ();
			PrintWriter out = response.getWriter();
			String SQLQ;
			SQLQ="select * from Quotes";
			st.executeQuery(SQLQ);
			out.println("<html><head></head><body>");
			ResultSet rs1 = st.executeQuery (SQLQ);
			 String col1, col2;
		        while (rs1.next ())
		            {
		           col1 = rs1.getString(1);
		           col2 = rs1.getString(2);
		           out.println ("<h3>" + col1 + " " + col2 + "</h3>");
		            }
		        out.println("</html></body>");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}

}
