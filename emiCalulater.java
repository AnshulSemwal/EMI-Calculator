import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class emiCalulater extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		int principal = Integer.parseInt(req.getParameter("principal"));
		float rateOfInterest = (float)Integer.parseInt(req.getParameter("rateOfInterest"));
		int months = Integer.parseInt(req.getParameter("months"));

		rateOfInterest = rateOfInterest/(12*100);
		double emi= (principal*rateOfInterest*Math.pow(1+rateOfInterest,months))/(Math.pow(1+rateOfInterest,months)-1);

		out.println(emi);
		
		double totalAmount = (float)(emi * 12);
		
		out.println(totalAmount);
		
		float extraAmount =(float) (totalAmount - principal);

		out.println(extraAmount);

		String emi1 = String.valueOf(emi);
		String totalAmount1=String.valueOf(totalAmount);
		String extraAmount1 =String.valueOf(extraAmount);

		req.setAttribute("emi",emi1);
		req.setAttribute("totalAmount",totalAmount1);
		req.setAttribute("extraAmount",extraAmount1);

		RequestDispatcher rd=req.getRequestDispatcher("/display");
		rd.forward(req,res);
		
	}

}