/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.util.ArrayList;
import CLASES.Client;
import CLASES.Events;
import DATA.DATClient;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


/**
 *
 * @author carlo
 */
public class BLClient {

    DATClient objDatClient = new DATClient();
    BLEvent BLEvents = new BLEvent();
    
    public Client CrearClient(String identification, String password, String names, String lastnames, String mail, String numberPhone){
        
        Client objClient = new Client(0, identification, password, names,lastnames, mail, numberPhone);
        return objClient;

    }
    
    public int insertClientDB(Client ObjCli) throws SQLException, ClassNotFoundException{
        int intRetorno =0;
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
            intRetorno = objDatClient.InsertarCliente(ObjCli);
        return intRetorno;
    } 

    public Client findIdentificationDB(String strCedula) throws ClassNotFoundException, SQLException 
    {
        Client objClient = new Client();
        ResultSet rs = objDatClient.findIdentification(strCedula);
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
                 if (columnName.equals("idClient"))
                    objClient.setIdClient(Integer.parseInt(value));
                if (columnName.equals("identification"))
                    objClient.setIdentification(value);
                if (columnName.equals("password"))
                    objClient.setPassword(value);
                if (columnName.equals("names"))
                    objClient.setNames(value);
                if (columnName.equals("lastNames"))
                    objClient.setLastnames(value);
                if (columnName.equals("mail"))
                    objClient.setMail(value);
                if (columnName.equals("numberPhone"))
                    objClient.setNumberPhone(value);
                
            }           
        }
        System.out.println(objClient);
        return objClient;
    }
    
    public Client findEventsClient(Client objClient) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = objDatClient.findIdentification(objClient.getIdentification());
        ArrayList<Events> ArrayEvents = new ArrayList<Events>();
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
                if (columnName.equals("idClient"))
                    objClient.setIdClient(Integer.valueOf(value));
                if (columnName.equals("identification")){
                    objClient.setIdentification(value);
                    //DIRECCION con composicion
                    ArrayEvents.clear();
                    ArrayEvents = BLEvents.findEvents(objClient.getIdentification());
                    for (Events objEvents : ArrayEvents)
                        objClient.setEvent(objEvents.getIdEvents(), objEvents.getName(), 
                                objEvents.getCost(),objEvents.getDate(),objEvents.getHour(),objEvents.getMinutes(),objEvents.getDescription(),
                                objEvents.getCategory(),objEvents.getPlace().getIdPlace(),objEvents.getPlace().getPrincipalStreet(),
                                objEvents.getPlace().getSecondaryStreet(),objEvents.getPlace().getReference(),
                                objEvents.getPlace().getNeighborhood(),objEvents.getState());
//  
                }
                if (columnName.equals("password"))
                    objClient.setPassword(value);
                if (columnName.equals("names"))
                    objClient.setNames(value);
                if (columnName.equals("lastNames"))
                    objClient.setLastnames(value);
                if (columnName.equals("mail"))
                    objClient.setMail(value);
                if (columnName.equals("numberPhone"))
                    objClient.setNumberPhone(value);
            }
            
        }
        return objClient;
    }
    
    public Client ValidarPassword(Client objClient, String password) {
       
        if (objClient.getPassword().equals(password)) {
            return objClient;
        }
        return null;
    }

    // Method to validate identification
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }

    
    
    // Metodo para buscar cleinte por su id
    public Client buscarClientePorId(String id){
        Client client = new Client();
        
        // Faltaaaa
        
        
        
        
        
        return client;
    }
    
    
    
}
