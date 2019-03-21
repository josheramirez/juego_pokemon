/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelos.Personaje;
import Modelos.Pokedex;
import Modelos.Pokemon;
import Modelos.Usuario;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author KATHY
 */
public class Consultas extends Connection_DB{

    
    public boolean autenticacion (String nombre, String contraseña){
    PreparedStatement pSta = null;
    ResultSet rs = null;
    
        try{
            String Consulta = "select * from usuarios where nombre=? and contraseña=?";
            pSta=getConnection_DB().prepareStatement(Consulta);
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
        
         public Personaje getPersonaje(String nombre,String contraseña){
            
            PreparedStatement pSta = null;
            ResultSet rs = null;
            Personaje personaje=new Personaje();
            
            try{ 
             
                String Consulta="select * from personajes inner join usuarios on personajes.fk_usuario=usuarios.id where  usuarios.nombre=? and usuarios.contraseña=?";
                pSta=getConnection_DB().prepareStatement(Consulta);
                pSta.setString(1, nombre);
                pSta.setString(2, contraseña);
                
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
         
         
        public Usuario getUsuario(String nombre, String contraseña){
            
            PreparedStatement pSta = null;
            ResultSet rs = null;
            Usuario usuario=new Usuario();
            
            try{ 
                String Consulta="select * from usuarios where  usuarios.nombre=? and usuarios.contraseña=?";
                pSta=getConnection_DB().prepareStatement(Consulta);
                pSta.setString(1, nombre);
                pSta.setString(2, contraseña);
                rs=pSta.executeQuery();
                
                if(rs.absolute(1)){
                    usuario.id=rs.getInt("id");
                    usuario.nombre=rs.getString("nombre");
                    usuario.contraseña=rs.getString("contraseña");
                    usuario.email=rs.getString("email");
                    usuario.fecha_creacion=rs.getString("fecha_creacion");
                    return usuario;
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
            return usuario;
        }
        
        public boolean crearPersonaje(String nombre,int fk_usuario,String genero,String raza,String equipo, String COjos, String CPelo){
		PreparedStatement P = null;
		try{
			String consulta = "insert into personajes (nombre,fk_usuario,genero,raza,equipo,color_ojos,color_pelo) values (?,?,?,?,?,?,?)";
			P =getConnection_DB().prepareStatement(consulta);
			P.setString(1, nombre);
			P.setInt(2, fk_usuario);
			P.setString(3, genero);
			P.setString(4, raza);
			P.setString(5, equipo);
			P.setString(6, COjos);
			P.setString(7, CPelo);
			if(P.executeUpdate() == 1){
                            return true;
			}
		}
		catch(SQLException e){
			System.err.println("Error: "+e);
		}
		finally{
			try{
				if(getConnection_DB() != null) getConnection_DB().close();
				if(P != null) P.close();
			}
			catch(SQLException e){
			}
		}
		return false;
	}
        
        public Personaje cargarPersonaje(int id){
            PreparedStatement PS = null;
            ResultSet rs = null;
            Personaje per=new Personaje();
            try{
                String consulta = "select * from personajes inner join usuarios on personajes.fk_usuario=usuarios.id where usuarios.id=?";
                PS = getConnection_DB().prepareStatement(consulta);
                PS.setInt(1, id);
                rs = PS.executeQuery();
                if(rs.absolute(1)){
                    
                   // personajes.nombre, personajes.nivel, personajes.genero, personajes.raza, personajes.equipo, personajes.color_ojos, personajes.color_pelo, personajes.medalla1, personajes.medalla2, personajes.medalla3, personajes.pokemoneda, personajes.experiencia
                    per.id=rs.getInt("id");
                    per.nombre=rs.getString("nombre");
                    per.nivel=rs.getInt("nivel");
                    per.genero=rs.getString("genero");
                    per.raza=rs.getString("raza");
                    per.equipo=rs.getString("equipo");
                    per.color_ojos=rs.getString("color_ojos");
                    per.color_pelo=rs.getString("color_pelo");
                    per.medalla_1=rs.getString("medalla_1");
                    per.medalla_2=rs.getString("medalla_2");
                    per.medalla_3=rs.getString("medalla_3");
                    per.pokemonedas=rs.getInt("pokemonedas");
                    per.experiencia=rs.getInt("experiencia"); 
                    
                    return per;
                }    
            }
            catch(SQLException e){
			System.err.println("Error: "+e);
            }
            finally{
                    try{
                        if(getConnection_DB() != null) {getConnection_DB().close();}
                        if(PS!= null) {PS.close();} 
                    }
                    catch(SQLException e){
                    }
            }
            return per;
	}
        
            public ArrayList<Pokemon> cargarPokemons(int usuario_id){
            PreparedStatement PS = null;
            ResultSet rs = null;
            ArrayList<Pokemon> lista_pokemon=new ArrayList<Pokemon>();
            
            try{
                String consulta = "select * from pokedexs inner join personajes on pokedexs.fk_personaje = personajes.id inner join usuarios on personajes.fk_usuario = usuarios.id inner join pokemons on pokedexs.fk_pokemon = pokemons.id where usuarios.nombre = ?";
                PS = getConnection_DB().prepareStatement(consulta);
                PS.setInt(1, usuario_id);
                rs = PS.executeQuery();
  
                if(rs.next()){
                    Pokedex pokemon=new Pokedex();
                    pokemon.id=rs.getInt("id");
                    pokemon.fk_pokemon=rs.getInt("fk_pokemon");
                    pokemon.fk_personaje=rs.getInt("fk_personaje");
                    pokemon.salud=rs.getInt("salud");
                    pokemon.estado=rs.getBoolean("estado");
                }
                return lista_pokemon;
            }
            catch(SQLException e){
			System.err.println("Error: "+e);
            }
            finally{
                    try{
                        if(getConnection_DB() != null) {getConnection_DB().close();}
                        if(PS!= null) {PS.close();} 
                    }
                    catch(SQLException e){
                    }
            }
            return lista_pokemon;
            }
           
            
            public ArrayList<Pokemon> cargarPokemonAll(){
            PreparedStatement PS = null;
            ResultSet rs = null;
            ArrayList<Pokemon> lista_pokemon=new ArrayList<Pokemon>();
            
            try{
                String consulta = "select * from pokemones";
                PS = getConnection_DB().prepareStatement(consulta);
                rs = PS.executeQuery();

                while(rs.next()){
                    Pokemon pokemon=new Pokemon();
                    pokemon.id=rs.getInt("id");
                    pokemon.imagen=rs.getString("imagen");
                    pokemon.pokedex=rs.getInt("pokedex");
                    pokemon.nombre=rs.getString("name");
                    pokemon.salud=rs.getInt("hp");
                    pokemon.ataque=rs.getInt("attack");
                    pokemon.ataque_especial=rs.getInt("special_attack");
                    pokemon.defensa_especial=rs.getInt("special_defence");
                    pokemon.defensa=rs.getInt("defence");
                    pokemon.tipo_1=rs.getString("type_1");
                    pokemon.tipo_2=rs.getString("type_2");
                    lista_pokemon.add(pokemon);
                }
                return lista_pokemon;
            }
            catch(SQLException e){
			System.err.println("Error: "+e);
            }
            finally{
                    try{
                        if(getConnection_DB() != null) {getConnection_DB().close();}
                        if(PS!= null) {PS.close();} 
                    }
                    catch(SQLException e){
                    }
            }
            return lista_pokemon;
            }
            
            public void guardarPokemon(int pokemon_id, int personaje_id, String[] datos){
                PreparedStatement pSta=null;
                try{ 
                    String Consulta="insert into pokedexs (fk_pokemon, fk_personaje, salud, estado) values (?, ?, (SELECT hp FROM pokemones WHERE id=?), ?)";
                    pSta =getConnection_DB().prepareStatement(Consulta); 
                    pSta.setInt(1, pokemon_id);
                    pSta.setInt(2, personaje_id);
                    pSta.setInt(3, pokemon_id);
                    pSta.setInt(4, 1);

                    if(pSta.executeUpdate()==1){
                         System.out.println("ingresado");
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
            }
         
        public static void main(String[] args){

               Consultas co=new Consultas();
               //Personaje per=co.getPersonaje("joshe", "1234");
               //System.out.println(per.nombre);
               
            
               //co.guardarPokemon(4, 1);
               //System.out.println(co.cargarPokemonAll().size());
        }
         
}
