import java.util.List;
import java.util.Scanner;

public class Cliente {

    private Integer id;
    private String nombre;
    private String apellido;
    private static int ultimoId;
    private Scanner s = new Scanner(System.in);


    public Cliente(){
        this.id = ++ultimoId;
    }

    public Cliente(String nombre, String apellido){
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getId(){
        return  id;
    }

    public String getNombre(){
        return  nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return  apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }


    public void setIDs(int newId){
        this.id = newId;
        this.ultimoId = newId;
    }


    @Override
    public String toString() {
        return  "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
