package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelos.Usuario;

public final class crearPersonaje_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Crear personaje</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/JP.css\">\n");
      out.write("    </head>\n");
      out.write("    <body bgcolor=\"#f0f0fd\">\n");
      out.write("\t");

        // capturo la variable de sesion "usuario" enviado por el servlet Inicio_Sesion
	HttpSession HS = request.getSession();
	//Usuario usuario = (Usuario)HS.getAttribute("usuario");
        Usuario usuario = new Usuario();
        usuario.nombre="pokejoshe";
        
        
        // redirijo a index en caso que no exista usuario
        if(usuario == null){
		response.sendRedirect("index.jsp");
	}
	
      out.write("\n");
      out.write("        \n");
      out.write("\t<div id='StarterM' align='center'>\n");
      out.write("\t\t<h1>Bienvenido!</h1>\n");
      out.write("\t\t<div>\n");
      out.write("\t\t<p>\n");
      out.write("\t\t\tAntes de empezar a jugar debes crear tu personaje.\n");
      out.write("\t\t</p>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div><button onclick='ShowAll()' type='button'>Continuar</button></div>\n");
      out.write("\t</div>\n");
      out.write("\t<div id='CContent'>\n");
      out.write("\t\t<div align=\"left\" id=\"CrearPersonajeB\">\n");
      out.write("\t\t\t<img hspace=\"20px\" vspace=\"5px\" id=\"CrearPersonajeIMG\" src=\"https://fontmeme.com/permalink/190118/b3cb4a64dfbb869a9fe1f6656b30823e.png\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"height: 50px\"></div>\n");
      out.write("\t\t<div align=\"center\">\n");
      out.write("\t\t\t<div id=\"CrearPersonajeForm\" align=\"center\">\n");
      out.write("\t\t\t\t<form action=\"crearPersonaje\" method=\"get\" id=\"CrearPersonaje\">\n");
      out.write("\t\t\t\t\t<fieldset>\n");
      out.write("\t\t\t\t\t\t<legend>Crear personaje</legend>\n");
      out.write("\t\t\t\t\t\t<input maxlength=\"50\" id=\"usuario\" name=\"usuario\" type=\"text\" value=\"");
      out.print( usuario.nombre);
      out.write("\" readonly>\n");
      out.write("\t\t\t\t\t\t<hr><div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"nombre\" id=\"nombre\" required placeholder=\"Nombre del Personaje\"><div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"Genero\" id=\"Hombr\" value=\"Hombr\" onclick='GenderC(this.id)' checked>\n");
      out.write("\t\t\t\t\t\t<label for=\"Hombr\">Hombre</label>\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"Genero\" id=\"Mujer\" value=\"Mujer\" onclick='GenderC(this.id)'>\n");
      out.write("\t\t\t\t\t\t<label for=\"Mujer\">Mujer</label><div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<div align=\"left\">\n");
      out.write("\t\t\t\t\t\t\t<div id=\"CharacterCMas\">\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id=\"CharGH\" src=\"pic/Hombr.png\" onclick='GenderCP(this.id)'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharRazaH' src=\"pic/Hombr/raza/Europ.png\" onclick='GenderCP(\"CharGH\")'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharEqH' src=\"pic/Hombr/equipo/Zaf.png\" onclick='GenderCP(\"CharGH\")'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharCOH' src=\"pic/Hombr/colorOjos/Marr.png\" onclick='GenderCP(\"CharGH\")'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharCPH' src=\"pic/Hombr/colorPelo/Cast.png\" onclick='GenderCP(\"CharGH\")'>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div id=\"CharacterCFem\">\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id=\"CharGM\" src=\"pic/Mujer.png\" onclick='GenderCP(this.id)'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharRazaM' src=\"pic/Mujer/raza/Europ.png\" onclick='GenderCP(\"CharGM\")'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharEqM' src=\"pic/Mujer/equipo/Zaf.png\" onclick='GenderCP(\"CharGM\")'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharCOM' src=\"pic/Mujer/colorOjos/Marr.png\" onclick='GenderCP(\"CharGM\")'>\n");
      out.write("\t\t\t\t\t\t\t\t<img class=\"character\" id='CharCPM' src=\"pic/Mujer/colorPelo/Cast.png\" onclick='GenderCP(\"CharGM\")'>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 200px\"></div>\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<label for=\"Raza\">Tono de piel:</label>\n");
      out.write("\t\t\t\t\t\t<select name=\"Raza\" id=\"Raza\" onchange='ChangeR(this.value)'>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Europ\">Claro</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Moren\">Oscuro</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Asian\">Más claro</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Latin\">Menos oscuro</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<label for=\"COjos\">Color de Ojos:</label>\n");
      out.write("\t\t\t\t\t\t<select name=\"COjos\" id=\"COjos\" onchange='ChangeCO(this.value)'>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Marr\">Marrones</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Azul\">Azules</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Verd\">Verdes</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Purp\">Púrpura</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Rojo\">Rojos</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Gris\">Grises</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Amar\">Amarillos</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<label for=\"CPelo\">Color de Pelo:</label>\n");
      out.write("\t\t\t\t\t\t<select name=\"CPelo\" id=\"CPelo\" onchange='ChangeCP(this.value)'>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Cast\">Castaño</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Negr\">Negro</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Rubi\">Rubio</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Blan\">Blanco</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Purp\">Púrpura</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Rojo\">Rojo</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<label for=\"Equipo\">Equipo:</label>\n");
      out.write("\t\t\t\t\t\t<select name=\"Equipo\" id=\"Equipo\" onchange='ChangeEq(this.value)'>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Zaf\">Zafiro</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Esm\">Esmeralda</option>\n");
      out.write("\t\t\t\t\t\t\t<option value=\"Rub\">Rubí</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t<div style=\"height: 10px\"></div>\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Listo!\">\n");
      out.write("\t\t\t\t\t</fieldset>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<script src=\"js/CPersonaje.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
