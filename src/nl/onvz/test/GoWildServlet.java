package nl.onvz.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoWildServlet
 */
@WebServlet("/GoWildServlet")
public class GoWildServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
    /**
     * Default constructor. 
     */
    public GoWildServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Memory Intensive
		writeToScreen(response, request, true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// CPU Intensive
		writeToScreen(response, request, false);
		
	}
	
	private void writeToScreen(HttpServletResponse response,HttpServletRequest request, boolean memoryintensive) throws IOException{
		response.setContentType("text/html");
		Calculator calculator = new Calculator();
		PrintWriter out = response.getWriter();
		
		/*
		* Write the HTML to the response
		*/
		out.println("<html>");
		out.println("<head>");
		out.println("<title> A very simple servlet example</title>");
		out.println("</head>");
		out.println("<body>");
		Date startdate = new Date();
		
		if (memoryintensive == false){
			for (long l=0; l < 300000; l++) {
				if (calculator.isPrime(l)) out.println(l);
			}
		} else {
			long numberofprimenumbers = Long.parseLong(request.getParameter("numberofprimenumbers"));
			int amountOfBytes = Integer.parseInt(request.getParameter("amountOfBytes"));
			ArrayList<ByteObject> list = calculator.fillMemoryWithRandombytes(numberofprimenumbers, amountOfBytes);

			calculator = null;
			out.println("<br /><br /><br />Prime numbers were added to memory, but now released<br />");
		}
		out.println("<br /><br /><br />Start: " + startdate + "<br />");
		out.println("End: " + new Date() + "<br />");
		
		
		out.println("<a href=\"/SimpleScaleApplication/index.html\">"+"Click here to go back to input page "+"</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
