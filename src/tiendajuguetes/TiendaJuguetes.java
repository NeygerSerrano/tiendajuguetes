
package tiendajuguetes;

import modelo.productoDAO;
import java.sql.SQLException;
import java.util.Scanner;
import modelo.productoModelo;

public class TiendaJuguetes {

    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        productoDAO pdao = new productoDAO();
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingrese el id del producto:");
        String id = teclado.nextLine();
//        
        System.out.println("Ingrese el nombre del producto:");
        String nombre = teclado.nextLine();
//        
        productoModelo nuevoJuguete = new productoModelo(id, nombre);
        pdao.guardarProducto(nuevoJuguete);
        
        System.out.println("==== Listar Productos ====");
        pdao.consultarProducto();

        System.out.println("Busque un producto por su ID:");
        String buscar = teclado.nextLine();
        
        productoModelo buscado = pdao.buscarProductoPorId(buscar);
        if(buscado != null){
            System.out.println("Juguete encontrado: " + "\n" 
                    + buscado.verInfo());
        }
    }
    
}
