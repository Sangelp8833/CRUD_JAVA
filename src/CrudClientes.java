import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CrudClientes implements CrudRepositorie{

    private List<Cliente> ClienteCrud = new ArrayList<Cliente>();
    public static int control = 0;

    public  CrudClientes(){

    }
    public CrudClientes(Cliente[] baseDatos){
        for (Cliente BD: baseDatos){
            this.ClienteCrud.add(BD);
        }

    }

    @Override
    public List<Cliente> listar() {

        return this.ClienteCrud;
    }

    @Override
    public Cliente porID(Integer id) {
        Cliente c = null;
        for (Cliente cli: this.ClienteCrud){
            if (cli.getId().equals(id)){
                c = new Cliente(cli.getNombre(), cli.getApellido());
            }
        }
        return c;
    }

    @Override
    public void crear(Cliente cliente) {
        this.ClienteCrud.add(cliente);
    }


    @Override
    public void editar(Cliente cliente, Integer ID) {
        Cliente c = this.porID(ID);
        System.out.println("Nombre actual: " + c.getNombre());
        System.out.println("Apellido actual: " + c.getApellido());

        Cliente[] arrayCliente = new Cliente[this.ClienteCrud.size()];
        this.ClienteCrud.toArray(arrayCliente);
        arrayCliente[ID-1].setNombre(cliente.getNombre());
        arrayCliente[ID-1].setApellido(cliente.getApellido());

        System.out.println("Nuevo Nombre: " + arrayCliente[ID-1].getNombre());
        System.out.println("Nuevo apellido: " + arrayCliente[ID-1].getApellido());

        this.ClienteCrud = Arrays.asList(arrayCliente);
    }

    @Override
    public void eliminar(Integer id) {
        this.control = 0;
        this.ClienteCrud.remove(id - 1);
        for(Cliente cli: this.ClienteCrud){
            cli.setIDs(++control);
        }


    }

}
