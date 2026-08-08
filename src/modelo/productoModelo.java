
package modelo;


public class productoModelo {
    
    private String idProducto;
    private String nombreProducto;
    
    public productoModelo() {
        
    }
    
    public productoModelo(String id, String nombre) {
        this.idProducto = id;
        this.nombreProducto = nombre;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public String verInfo(){
        
        String info = "ID: " + this.idProducto + "\n"
                + "Nombre: " + this.nombreProducto;
        
        return info;
        
    }
}
