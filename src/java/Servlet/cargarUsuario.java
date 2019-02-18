/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Consulta;
import Modelos.Personaje;
import Modelos.Pokemon;
import Modelos.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WarPc
 */
public class cargarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                        
        HttpSession HS = request.getSession();
        Usuario usuario =(Usuario)HS.getAttribute("usuario");
        out.println(usuario.id);
                
            Consulta C = new Consulta();
            
            if(usuario.id==0){
            response.sendRedirect("index.jsp");
            }
            String character;
            int i = 1;
           
            Personaje personaje=C.cargarPersonaje(usuario.id);
            //character = RS.getString(1);
            HS.setAttribute("personaje", personaje); 
            
            Pokemon pokemon=C.cargarPokemons(usuario.id);
			 
			while(RS.next()){
				if(RS.getBoolean(9)){
				request.setAttribute("pkmn"+i, RS.getString(1));
				i++;
				}
			}
			while(i <= 6){
				request.setAttribute("pkmn"+i,"pic/PKball.png");
				i++;
			}
			request.getRequestDispatcher("perfil.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.err.println("Error: "+ex);
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
