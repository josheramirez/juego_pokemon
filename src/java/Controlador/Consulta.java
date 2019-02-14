/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelos.Personaje;
import java.sql.*;

/**
 *
 * @author KATHY
 */
public class Consulta extends Connection_DB{
    
    public boolean autenticacion (String nombre, String contraseña){
    PreparedStatement pSta = null;
    ResultSet rs = null;
    
        try{
            String Consulta = "select * from usuarios where nombre=? and contraseña=?";
            pSta=getConnection_DB ().prepareStatement(Consulta);
            pSta.setString(1, nombre);
            pSta.setString(2, contraseña);
            rs=pSta.executeQuery();
            
            if(rs.absolute(1)){
                return true;
                
            }
            
            
        }catch (Exception e){         
            System.out.println("Error en conexión: "+e);
            
        }finally{
            
            try{
                if (getConnection_DB()!=null){
                    getConnection_DB().close();
            } 
                if (pSta!=null){
                    pSta.close();
                }
                if(rs!=null)
                    rs.close();
             
            }catch (Exception e){         
            System.out.println("Error en conexión: "+e);                     
                      
            }
            
        }
        
        return false;
        
       }
    
    
        public boolean registrar (String nombre, String contraseña, String email, String telefono){
            
            PreparedStatement pSta=null;
            
            try{ 
                String Consulta="insert into usuarios (nombre, contraseña, email, telefono) values (?, ?, ?, ?)";
                pSta =getConnection_DB().prepareStatement(Consulta); 
                pSta.setString(1, nombre);
                pSta.setString(2, contraseña);
                pSta.setString(3, email);
                pSta.setString(4, telefono);
                
                if(pSta.executeUpdate()==1){
                    return true;
                }
                
            }catch (Exception e){
               System.err.println("Error en conexion: "+e); 
            
            }finally{
                try{
                    if(getConnection_DB()!=null) 
                        getConnection_DB().close();
                    if(pSta !=null) 
                        pSta.close();
                    
                }catch(Exception e){
                    System.out.println("Error en conexion: "+e);
            }                   
            
            }
            return false;
        }
        
         public Personaje get_db_Personaje(String nombre,String pass){
            
            PreparedStatement pSta = null;
            ResultSet rs = null;
            Personaje personaje=new Personaje();
            
            try{ 
             
                String Consulta="select * from personajes inner join usuarios on personajes.fk_usuario=usuarios.id where  usuarios.nombre=? and usuarios.contraseña=?";
                pSta=getConnection_DB().prepareStatement(Consulta);
                pSta.setString(1, nombre);
                pSta.setString(2, pass);
                
                rs=pSta.executeQuery();
                
                
                if(rs.absolute(1)){
                personaje.id=rs.getInt("id");
                personaje.nivel=rs.getInt("nivel");
                personaje.usuario=rs.getInt("fk_usuario");
                personaje.nombre=rs.getString("nombre");
                return personaje;
                
                }
                
            }catch (Exception e){
               System.err.println("Error en conexion: "+e); 
            
            }finally{
                try{
                    if(getConnection_DB()!=null) 
                        getConnection_DB().close();
                    if(pSta !=null) 
                        pSta.close();
                    
                }catch(Exception e){
                    System.out.println("Error en conexion: "+e);
            }                   
            
            }
            return personaje;
        }
         
        public static void main(String[] args){

               Consulta co=new Consulta();
               Personaje per=co.get_db_Personaje("joshe", "1234");
               System.out.println(per.nombre);
        }
         
}
