/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiendainve.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Garcia
 */
public class conectionDB {

    protected Connection conn;

    protected void cerrar(PreparedStatement stm) throws Exception {
        stm.close();
    }

    protected void cerrar(ResultSet rst) throws Exception {
        rst.close();
    }

    public conectionDB() {
        String driver = "org.postgresql.Driver";  // Driver JDBC de PostgreSQL
        String user = "postgres";  // Tu usuario
        String pwd = "";       // Tu contraseña
        String host = "localhost"; // Dirección del servidor de base de datos
        String port = "";      // Puerto por defecto de PostgreSQL
        String basedatos = "inventariostore"; // El nombre de tu base de datos

        // URL de conexión para PostgreSQL
        String server = "jdbc:postgresql://" + host + ":" + port +"/" + basedatos;
        try {
            // Cargar el driver
            Class.forName(driver);
            // Conectar a la base de datos
            conn = DriverManager.getConnection(server, user, pwd);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e);
        }  
    }
    
     public Object[] numeros(int inicio, int fin){
     Object[] num = new Object[(fin-inicio+1)];
     
     int y=0;
     for(int x=inicio; x<=fin; x++){
     num[y]=x;
     y++;
     }
     
     return num;
     }   
}
