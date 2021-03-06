/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import CLASES.Events;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Renato
 */
public class DATEvent {
    
    static DATConexion c = new DATConexion();
    
    public static ResultSet findEventsClient(String identification) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        
        String Sentencia ="select event.idEvent,nameEvent, cost, date, hour, minutes, description, idCat, idPlace, idState from client, event "
                + "where client.idClient = event.idClient and client.identification = "+identification +" order by 1" ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public static boolean insertEvent(Events objEvents, int IdCli) 
             throws ClassNotFoundException, SQLException{
        PreparedStatement ps = null;
        Connection con = c.abrirConexion();
        String sql = "INSERT INTO EVENT(nameEvent, cost, date, hour, minutes, description, idCat, idPlace, idClient, idState, idAdmin) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, objEvents.getName());
            ps.setDouble(2, objEvents.getCost());
            ps.setDate(3, objEvents.getDate());
            ps.setString(4, objEvents.getHour());
            ps.setString(5, objEvents.getMinutes());
            ps.setString(6, objEvents.getDescription());
            ps.setInt(7, objEvents.getCategory().getIdCat());
            ps.setInt(8, objEvents.getPlace().getIdPlace());
            ps.setInt(9, IdCli);
            ps.setInt(10, 1);
            ps.setInt(11, 1);
            ps.execute();
            return true ;
        } catch (Exception e) {
            System.err.println(e);
        }  
        return false;
    } 
    
    
    
    // Metodo para listar los eventos 
    public ResultSet listEventsWhereState(int targetState)  throws ClassNotFoundException, SQLException{
        
        
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM event WHERE event.idState = "+targetState);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    
    }
    
    /// Metodo para ecnontrar un evento s=por su id
    public ResultSet findEventById(int targetId) throws ClassNotFoundException, SQLException{
    
                
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = String.format("SELECT * FROM event WHERE event.idEvent = "+targetId);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    
    }
    
    


    
}
