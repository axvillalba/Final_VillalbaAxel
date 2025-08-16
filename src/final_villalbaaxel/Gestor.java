
package final_villalbaaxel;
import java.util.List;

public interface Gestor<T> {
    void agregar(T elemento);
    List<T> listar();
    void eliminar(String codigo);
    T buscarPorCodigo(String codigo);
}