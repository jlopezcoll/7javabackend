

import java.io.IOException;
import java.util.Hashtable;
//import java.util.Properties;

import javax.naming.*;
import javax.naming.directory.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    		   throws ServletException, IOException {

    		  final String SUCCESS = "sucess.jsp";
    		  final String FAILURE = "failure.jsp";
    		  String strUrl = "index.jsp";
    		  String username = request.getParameter("username");
    		  String password = request.getParameter("password");

    		  Hashtable<String, String> env = new Hashtable<>();
    		  //Properties env = new Properties();

    		  boolean b = false;

    		  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    		  env.put(Context.PROVIDER_URL, "ldap://192.168.0.157:389");
    		  env.put(Context.SECURITY_AUTHENTICATION, "simple");
    		  env.put(Context.SECURITY_PRINCIPAL, "cn=" + username +", ou=Users, dc=p7j, dc=edu");
    		  env.put(Context.SECURITY_CREDENTIALS, password);

    		  try {
    		   // Create initial context
    		   DirContext ctx = new InitialDirContext(env);

    		   // Close the context when we're done
    		   b = true;
    		   ctx.close();

    		  } catch (NamingException e) {
    		   b = false;
    		  } finally {
    		   if (b) {
    		    System.out.print("Success");
    		    strUrl = SUCCESS;
    		    //request.getRequestDispatcher("sucess.jsp").forward(request,  response);
    		    //response.sendRedirect("sucess.jsp");
    		   } else {
    		    System.out.print("Failure");
    		    //response.sendRedirect("failure.jsp");
    		    strUrl = FAILURE;
    		   }
    		  }
    		  RequestDispatcher rd = request.getRequestDispatcher(strUrl);
    		  rd.forward(request, response);

    		 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		processRequest(request, response);
	}

}
