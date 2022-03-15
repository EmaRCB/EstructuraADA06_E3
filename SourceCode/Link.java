
/**
 * <p>
 * Clase que permite crear un nodo y proporciona los métodos necesarios para
 * gestionarlo
 */
public class Link<T> {
    private T dData;
    private Link<T> next;

    public Link(T dd) {
        dData = dd;
        // poner el siguiente enlace a null porque todavía no se conoce el siguiente
        // nodo para enlazarlo
        next = null;
    }

    public void displayLink() {
        System.out.print("{" + dData.toString() + "} ");
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> n) {
        this.next = n;
    }

    public Link<T> getDato() {
        return null;
    }
}
