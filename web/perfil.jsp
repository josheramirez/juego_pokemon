<%@page import="Modelos.Pokemon"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelos.Usuario"%>
<%@page import="Modelos.Personaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	HttpSession HS = request.getSession();
	Usuario usuario = (Usuario)HS.getAttribute("usuario");
        Personaje personaje= (Personaje)HS.getAttribute("personaje");
        
        ArrayList<Pokemon> lista_pokemon=(ArrayList<Pokemon>)request.getAttribute("lista_pokemon");
        
out.println(usuario.toString());
out.println(personaje.toString());
out.println(lista_pokemon.toString());

        
%>    