/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;


import CLASES.State;
import DATA.DATState;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Renato
 */
public class BLState {
    
    static DATState objDATState = new DATState();
    
    public State findStateDB(String idPlace) throws ClassNotFoundException, SQLException 
    {
        State objState = new State();
        ResultSet rs = objDATState.findState(idPlace);
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        //Envia los datos al objeto
        while (rs.next()) {
            for (String columnName : columns){
                String value = rs.getString(columnName);
                if (columnName.equals("idState"))
                    objState.setIdState(Integer.parseInt(value));
                if (columnName.equals("state"))
                    objState.setState(Integer.parseInt(value));
                if (columnName.equals("description"))
                    objState.setDescription(value);
            }           
        }
        return objState;
    }
    
    
    
    
    // Metood para listar estado
    public ArrayList listStates() {
        ArrayList<State> statesArray = new ArrayList();
        try {
            ResultSet rs = objDATState.listStates();

            while (rs.next()) {
                // Obtenemos los datos del rs
                int idState = rs.getInt("idState");
                int state = rs.getInt("state");
  
                String descripcion = rs.getString("descripcion");

                // Creamos un objeto state
                State objState = new State(idState, state, descripcion);

                // Lo agregamos al array
                statesArray.add(objState);
            }
            return statesArray;

        } catch (Exception e) {
            System.err.println("Ha ocurrido una excepcion mientras se listaba los estados");
            return statesArray;
        }

    }
}
