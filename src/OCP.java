
public abstract class Figura {
    public void dibujar() {
    };
}

public abstract class Cuadrado extends Figura {
}

public abstract class Circulo extends Figura {
}

public abstract class Rombo extends Figura {
}

public class Figuras {
    Vector<Cuadrado> cuadrados = new Vector<Cuadrado>();
    Vector<Circulo> circulos = new Vector<Circulo>();

    public void addFigura(Figura2 f) {
        figuras.add(f);
    }

    public void dibujarFiguras() {
        for (Figura2 f : figuras) {
            f.dibujar();
        }
    }
}

// Consultas:
// 1. ¿Cumple la clase Figuras el Principio OCP. Justifica tu respuesta.
    //Respuesta: NO, ya que no está cerrada para la modificación y abierta para la extensión.
    // Si se desea agregar una nueva figura a la clase figura, el dia de mañana que se implemente un rombo por ejemplo,
    // se tendría que editar dicha clase "Figuras", por tanto no cumple con el principio OCP.
// 2. En caso de que no lo cumpla, modifica las clase para cumpla este criterio.
    // Codigo se modifica, agregando metodo generico addFigura y dibujarFigura, que recibe cualquier tipo de Figura
// 3. ¿Consideras que la tarea realizada es una refactorización? Justifica tu respuesta. 
    // Respuesta: Si, pues se realizan cambios a fin de cumplir con el principio OCP
    // sin cambiar en absoluto la funcionalidad del codigo.
