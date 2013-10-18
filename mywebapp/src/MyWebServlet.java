import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Webservlet
 */
public class MyWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyWebServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Now processing the get request: "+request.getQueryString());
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Now processing the post request: "+request.getQueryString());
		process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//here we will write all the stuff...
		//get the form parametes
		String name=request.getParameter("nameentered"); //this is same as the name
		String age=request.getParameter("ageentered"); //this is same as the age
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		System.out.println("Read from input stream: "+br.readLine());
		System.out.println("---name:"+name);
		System.out.println("---age:"+age);		
	}
}
