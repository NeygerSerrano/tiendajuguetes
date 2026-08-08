
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import config.conexion;

public class productoDAO {
    
    private Connection db;
    private conexion conn;
    
    public productoDAO() throws SQLException {
        this.conn = new conexion();
    }
    
    public void consultarProducto() throws SQLException {
        String sql = "SELECT * FROM producto";
        
        try {
            this.db = (Connection) this.conn.hacerConexion();
            PreparedStatement stmt = this.db.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            
            while (res.next()) {
                String id = res.getString("id_producto");
                String nombre = res.getString("nombre_producto");
                System.out.println("- Codigo: " + id + "\n" +
                        "- Nombre: " + nombre + "\n");
            }
            this.db.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void guardarProducto(productoModelo objProducto) throws SQLException {
        String sql = "INSERT INTO producto (id_producto, nombre_producto) VALUES (?, ?)";
        
        try {
            this.db = (Connection) this.conn.hacerConexion();
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, objProducto.getIdProducto());
            stmt.setString(2, objProducto.getNombreProducto());
            stmt.executeUpdate();
            System.out.println("Producto guardado con exito...");
            this.db.close();
        } catch (SQLException e) {
            
            System.out.println("Error..." + e);
            
        }
    }
    
    public productoModelo buscarProductoPorId(String id) throws SQLException {
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        
        try {
            this.db = (Connection) this.conn.hacerConexion();
            PreparedStatement stmt = this.db.prepareStatement(sql);
            stmt.setString(1, id);
            
            try(ResultSet res = stmt.executeQuery()) {
                if(res.next()) {
                    return new productoModelo(res.getString("id_producto"), res.getString("nombre_producto"));
                }
            }
            this.db.close();
        } catch (SQLException e) {
            
            System.out.println("Error..." + e);
            
        }
        return null;
    }
}
