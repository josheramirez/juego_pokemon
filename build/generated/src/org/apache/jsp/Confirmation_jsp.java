package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Confirmation_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    HttpSession objsesion=request.getSession(false);
    String Nombre=(String)objsesion.getAttribute("nombre");
    if (Nombre.equals("")){
        response.sendRedirect("LogIn.jsp");
    }
    
    
   out.println(request.getAttribute("personaje"));

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>    \n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${personaje.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        <br><br><br>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <img src=\"https://fontmeme.com/permalink/190206/cc8bff332df13d63619f061948f54771.png\" alt=\"pokemon-font\" border=\"0\"><br><br>\n");
      out.write("            <h1><strong style=\"font-family: Arial, Helvetica, sans-serif; color: #2a75bb; font-size: 40px; text-decoration: none; padding-right: 5px\">");
out.println(Nombre);
      out.write(".</strong></h1>\n");
      out.write("            <br>\n");
      out.write("        </div>\n");
      out.write("        <div align=\"center\">\n");
      out.write("            <h2> <strong style=\"font-family: Arial, Helvetica, sans-serif; color: #2a75bb; font-size: 25px; text-decoration: none; padding-right: 5px\">Ingresa a tu</strong>\n");
      out.write("                <br>\n");
      out.write("              <a href=\"Personaje.jsp\">\n");
      out.write("                  <img src=\"https://fontmeme.com/permalink/190206/cc9e13605efe0631c4ee6b88902da0b9.png\" alt=\"pokemon-font\" border=\"0\"></a></h2>        \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>");
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
