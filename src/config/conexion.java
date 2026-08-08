
package config;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    
    private String url;
    private String usuario;
    private String clave;
    private Connection conex;
    
    public conexion() throws SQLException {
        
        this.url = "jdbc:mysql://localhost:3306/juguetes";
        this.usuario = "root";
        this.clave = "";
        
    }
    
    public Connection hacerConexion() throws SQLException {
        
        try {
            
            this.conex = DriverManager.getConnection(this.url, this.usuario, this.clave);
            System.out.println("Conexion exitosa...");
            
        } catch (SQLException e) {
            
            System.out.println("Error:... " + e);
            
        }
        return conex;
        
    }
    
    public void cerrarConexion() throws SQLException {
        
        this.conex.close();
        System.out.println("Conexion finalizada...");
        
    }
    
//    public void consultarInfo() throws SQLException {
//        String textoSql = "SELECT * FROM producto";
//        PreparedStatement consulta = this.conex.prepareStatement(textoSql);
//        
//        ResultSet resultado = consulta.executeQuery();
//        System.out.println(resultado.toString());
//        System.out.println("Se ejecuto metodo de consultar informacion...");
//        
//        System.out.println("");
//        
//        System.out.println(resultado.next());
//        
//        if(resultado.next() == true) {
//            String producto = resultado.getString("nombre_producto");
//            System.out.println("Nombre producto: " + producto);
//        }
//    }
}
