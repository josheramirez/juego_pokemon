/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
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
            
}
