/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import CLASES.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Renato
 */
public class DATClient {
    
    DATConexion c = new DATConexion();
    
    public int InsertarCliente(Client ObjCli) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.getConnection().createStatement();
        String Sentencia = "INSERT InTO Client (identification, password, names, lastNames, mail, numberPhone)  VALUES ( " 
                +"'" +ObjCli.getIdentification()+"'"  + "," 
                +"'" +ObjCli.getPassword()+"'" + ","
                +"'" +ObjCli.getNames()+"'" + ","
                +"'" +ObjCli.getLastnames()+"'" + ","
                +"'" +ObjCli.getMail()+"'" + ","
                + ObjCli.getNumberPhone() + ")" ;
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
    public ResultSet findIdentification(String identification) throws ClassNotFoundException, SQLException
    {
        Statement st = c.abrirConexion().createStatement();
        String Sentencia = "SELECT * FROM client WHERE IDENTIFICATION = " + identification ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    
    
}
