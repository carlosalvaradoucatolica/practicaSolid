//Se define clase abstracta para hacer herenecia posteriormente y para definir metodo abstracto
public abstract class Figura {
    //Se elimina public por defecto
  abstract void dibujar();
}

public class Cuadrado extends Figura {
    @Override
    void dibujar() {
        //Se implemente metodo para dibujar
        System.out.println("Dibujando Cuadrado");
    }
}

public class Circulo extends Figura {
    @Override
    void dibujar() {
        //Se implemente metodo para dibujar
        System.out.println("Dibujando Circulo");
    }
}

public class Figuras {

  Vector<Cuadrado> cuadrados = new Vector<Cuadrado>();
  Vector<Circulo> circulos = new Vector<Circulo>();

  public void addCirculo(Circulo c) {
    circulos.add(c);
  }

  public void addCuadrado(Cuadrado c) {
    cuadrados.add(c);
  }

  public void dibujarFiguras() {
    Enumeration<Cuadrado> cuads = cuadrados.elements();
    Cuadrado c;
    while (cuads.hasMoreElements()) {
      c = cuads.nextElement();
      c.dibujar();
    }
    Enumeration<Circulo> circs = circulos.elements();
    Circulo ci;
    while (cuads.hasMoreElements()) {
      ci = circs.nextElement();
      ci.dibujar();
    }
  }
}
// Consultas:
// 1. ¿Cumple la clase Figuras el Principio OCP. Justifica tu respuesta.
    // Respuesta: No, ya que si bien está abierta para la extensión, no está cerrada para la modificación, pues se puede
    // modificar el metodo "dibujar" desde la implementación y no desde las clases particulares, inclusive siendo iguales.
// 2. En caso de que no lo cumpla, modifica las clase para cumpla este criterio. Modificado
// 3. ¿Consideras que la tarea realizada es una refactorización? Justifica tu respuesta. 
    // Respuesta: Si, pues se realizan cambios a fin de cumplir con el principio OCP
    // sin cambiar en absoluto la funcionalidad del codigo.
