
package final_villalbaaxel;

public interface CRUD<T> {
    void crear(T entidad);
    T leer(String id);
    void actualizar(T entidad);
    void eliminar(String id);
}

