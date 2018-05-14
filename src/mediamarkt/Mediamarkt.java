
package mediamarkt;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mediamarkt {

    public static void cargaDatos(){
        try {
            //1.Crea Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //2.Creo la conexion contra ña BD
            Connection conexion=
                    DriverManager.getConnection("jdbc://localhost/mediamarkt","root","");
            
            //3.Crear el Statament
            Statement s=conexion.createStatement();
            
            //4. Trabajo con las consultas
            ResultSet rs=s.executeQuery("SELECT id, nombre, precio FROM PRODUCTOS");
            while(rs.next()){
                System.out.println(rs.getInt("id")+" "+
                        rs.getString("nombre")+" "+
                        rs.getFloat("precio"));
            }
            
            //5.Cerrar Conexion
            rs.close();
            s.close();
            conexion.close();
            
        } catch (Exception ex) {
            System.out.println("Error al acceder a la base de datos");
            //Muestra la informacion del error
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        cargaDatos();
    }
    
}
