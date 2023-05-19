import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class emiDisplay extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String emi=(String)req.getAttribute("emi");
		String totalAmount=(String)req.getAttribute("totalAmount");
		String extraAmount=(String)req.getAttribute("extraAmount");
		out.println("<html><title>Emi Calculate</title><body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Every Month-EMI</th><th>Total Payable Amount</th><th>Extra Amount</th>");
		out.println("</tr>");
		out.println("<td >"+emi+"</td>");
		out.println("<td >"+totalAmount+"</td>");
		out.println("<td >"+extraAmount+"</td>");
		out.println("</table>");
		out.println("</body></html>");



	}
}