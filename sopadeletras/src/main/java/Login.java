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
    
    protected void procesoAutentificacionLDAP(HttpServletRequest request, HttpServletResponse response)
    		   throws ServletException, IOException {

    		  final String SUCCESS = "sucess.jsp";
    		  final String FAILURE = "failure.jsp";
    		  String strUrl = "index.jsp";
    		  String username = request.getParameter("username");
    		  String password = request.getParameter("password");

    		  Hashtable<String, String> env = new Hashtable<>();
    		  //Properties env = new Properties();
    		  
    		  //Variable control autentidicación
    		  boolean autentificado = false;
    		  
    		  //Declaramos parametros para la conexión LDAP
    		  env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
    		  env.put(Context.PROVIDER_URL, "ldap://192.168.0.157:389");
    		  env.put(Context.SECURITY_AUTHENTICATION, "simple");
    		  env.put(Context.SECURITY_PRINCIPAL, "cn=" + username +", ou=Users, dc=p7j, dc=edu");
    		  env.put(Context.SECURITY_CREDENTIALS, password);

    		  try {
    		   // Creamos el contexto inicial
    		   DirContext ctx = new InitialDirContext(env);

    		   // Establecemos variable y cerramos el contexto
    		   autentificado = true;
    		   ctx.close();

    		  } catch (NamingException e) {
    			  autentificado = false;
    		  } finally {
    			  if (autentificado) {
    				  System.out.print("Success");
    				  strUrl = SUCCESS;
    			   }else {
    				  System.out.print("Failure");
    				  strUrl = FAILURE;
    		   }
    		  }
    		  //Enviamos a JSP correspondiente
    		  RequestDispatcher rd = request.getRequestDispatcher(strUrl);
    		  rd.forward(request, response);

    		 }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		procesoAutentificacionLDAP(request, response);
	}

}
