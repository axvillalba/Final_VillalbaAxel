package final_villalbaaxel;
import java.util.ArrayList;

public interface Gestor<T> {
    void agregar(T elemento);
    ArrayList<T> listar();
    void eliminar(String codigo);
    T buscarPorCodigo(String codigo);
}