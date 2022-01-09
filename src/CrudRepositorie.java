import java.util.List;

public interface CrudRepositorie {

    List<Cliente> listar(); // Listar
    Cliente porID(Integer id); // Obtener cliente por IDvoid
    void crear(Cliente cliente);
    void editar(Cliente cliente, Integer ID);
    void eliminar(Integer id);



}
