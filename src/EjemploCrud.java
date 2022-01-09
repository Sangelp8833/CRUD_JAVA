import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EjemploCrud {
    public static void main(String[] args) {

        // ******************* BASE DE DATOS INICIAL *****************

        Cliente[] clienteBaseDatos = new Cliente[4];

        clienteBaseDatos[0] = new Cliente("Samuel","Ángel");
        clienteBaseDatos[1] = new Cliente("Ivonnet", "Quiroz");
        clienteBaseDatos[2] = new Cliente( "Andromeda", "Doe");
        clienteBaseDatos[3] = new Cliente( "Coraline", "Doe");


        // **************** FINAL BASE DE DATOS INCIAL ***************


        //  *************** INICIO DEL PROGRAMA ***************e

        String nombre;
        String apellido;
        List<Cliente> clientesList = new ArrayList<Cliente>();
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < clienteBaseDatos.length; i++){
            clientesList.add(clienteBaseDatos[i]);
        }

        CrudClientes clientesCrud = new CrudClientes(clienteBaseDatos);

        System.out.println("..... INICIANDO EL PROGRAMA .....");
        System.out.println("\n¿QUÉ ACCIÓN DESEA REALIZAR?" + "\n" + "MARQUE " +
                "\n(1) - Para crear un nuevo cliente" +
                "\n(2) - Para editar" +
                "\n(3) - Para eliminar algún cliente" +
                "\n(4) - Para Listar los clientes" +
                "\n(5) - Si conoce el ID del cliente marquelo para obtener su información");

        String opcion = s.nextLine();
        Integer ID ;


        while (Integer.parseInt(opcion) != 9) {

            switch (Integer.parseInt(opcion)){
                case 1:
                    System.out.println("\n**** Para crear un nuevo cliente siga los siguientes pasos ****");
                    System.out.println("1. Ingrese el nombre: ");
                    nombre = s.nextLine();
                    System.out.println("2. Ingrese el apellido: ");
                    apellido = s.nextLine();
                    clientesCrud.crear(new Cliente(nombre, apellido));
                    break;
                case 2:
                    Cliente editarCliente = null;
                    String nombreEditado;
                    String apellidoEditado;
                    System.out.println("\n**** Ingrese el ID del cliente que desea editar ****");
                    ID = s.nextInt();
                    s.nextLine();
                    System.out.println("Edite el nombre: ");
                    nombreEditado = s.nextLine();
                    System.out.println("Edite el apellido: ");
                    apellidoEditado = s.nextLine();
                    editarCliente = new Cliente(nombreEditado, apellidoEditado);
                    clientesCrud.editar(editarCliente, ID);
                    break;
                case 3:
                    System.out.println("\n**** Ingrese el ID del c1liente que desea eliminar ****");
                    ID = s.nextInt();
                    s.nextLine();
                    clientesCrud.eliminar(ID);

                    break;
                case 4:
                    System.out.println("\n**** El listado de clientes es el siguiente ****");
                    List<Cliente> listarClientes = clientesCrud.listar();
                    listarClientes.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("\n**** Ingrese el ID del cliente ****");
                    ID = s.nextInt();
                    s.nextLine();
                    System.out.println("Los datos del cliente solicitados son: ");
                    System.out.println("ID: " + ID);
                    System.out.println("Nombre: " + clientesCrud.porID(ID).getNombre());
                    System.out.println("Apellido: " + clientesCrud.porID(ID).getApellido());
                    break;


            }
            System.out.println("\n¿QUÉ ACCIÓN DESEA REALIZAR?" + "\n" + "MARQUE " +
                    "\n(1) - Para crear un nuevo cliente" +
                    "\n(2) - Para editar" +
                    "\n(3) - Para eliminar algún cliente" +
                    "\n(4) - Para Listar los clientes" +
                    "\n(5) - Si conoce el ID del cliente marquelo para obtener su información");

            opcion = s.nextLine();
        }


    }
}
