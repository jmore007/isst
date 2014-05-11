
public class Producto {
    private int  id, idcategoria,disponibilidad,precio,idmenu;
    private String nombre, descripcion ,ingredientes;
    
    public Producto( int id, String nombre , String descripcion, String ingredientes, int idmenu,int idcategoria, int disponibilidad, int precio){
        this.id = id;
        this.idcategoria = idcategoria;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
        this.idmenu =idmenu;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
         
        
    }
}
