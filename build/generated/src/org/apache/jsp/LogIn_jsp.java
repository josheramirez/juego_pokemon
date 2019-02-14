package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class LogIn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
  
     //String username=(String)session.getAttribute("error");
        //out.println(username);
    
    String bandera=request.getParameter("error");
    if(request.getParameter("error") == null){
        //out.println("sin mensaje");
    }
    else{
        //out.println("con mensaje");
    }

      out.write("\n");
      out.write("\n");
      out.write("      \n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Iniciar sesión</title>\n");
      out.write("        <script src=\"JS/Main.js\"></script>\n");
      out.write("                        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <br><br><br>\n");
      out.write("        \n");
      out.write("        <div align=\"center\" style=\"\">\n");
      out.write("        <a href=\"https://fontmeme.com/pokemon-font/\">\n");
      out.write("            <img src=\"https://fontmeme.com/permalink/190205/5d9c6ccdd715da482642db91a622a156.png\" alt=\"pokemon-font\" border=\"0\"></a>\n");
      out.write("        </div>        \n");
      out.write("        ");
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        <div align=\"center\">\n");
      out.write("               <form action=\"login\" method=\"post\" id=\"formInicio\">\n");
      out.write("               <label><strong style=\"font-family: Arial, Helvetica, sans-serif; color: #2a75bb; font-size: 17px; text-decoration: none; padding-right: 5px\">Nombre</strong></label>\n");
      out.write("                <br>\n");
      out.write("                <input title=\"Completa este campo\" type=\"text\" name=\"nombre\" id=\"txtNombre\" required placeholder=\"Juan Perez\">\n");
      out.write("                <br>\n");
      out.write("                <label><strong style=\"font-family: Arial, Helvetica, sans-serif; color: #2a75bb; font-size: 17px; text-decoration: none; padding-right: 5px\">Contraseña</strong></label>\n");
      out.write("                <br>\n");
      out.write("            <input title=\"Completa este campo\" type=\"password\" name=\"pass\" id=\"passwordPass\" required><br>\n");
      out.write("            <br>            \t\n");
      out.write("            <input align=\"center\" type=\"submit\" value=\"Iniciar sesión\" id=\"btnIniciar\" style=\"height:40px; width:200px; border: 3px solid #2a75bb; background-color: #ffcb05; border-radius: 12px;font-size: 18px; color: #2a75bb; font-family: Arial, Helvetica, sans-serif\">\n");
      out.write("                                      \n");
      out.write("</form>\n");
      out.write("                <br><br><br>\n");
      out.write("                <strong style=\"font-family: Arial, Helvetica, sans-serif; color: #2a75bb; font-size: 16px; text-decoration: none; padding-right: 5px\">¿No tienes una cuenta?</strong>\n");
      out.write("                        <br>\n");
      out.write("\t\t\t<a href=\"NewUser.jsp\">\n");
      out.write("                            <img src=\"https://fontmeme.com/permalink/190205/ed2db4da11755ee2ef3c8a5bb5933002.png\" alt=\"pokemon-font\" border=\"0\"></a>\n");
      out.write("                        \n");
      out.write("                    ");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>    \n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
