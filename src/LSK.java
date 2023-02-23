// Tenemos una interfaz que recoge el comportamiento de los objetos que pueden cargarse en
// memoria y posteriormente guardarse de forma persistente:
public interface RecursoPersistente {
public void load();
public void save();
}
// y 3 clases que implementan dicha interfaz:
public class ConfiguracionSistema implements RecursoPersistente{
public void load(){
System.out.println("Configuracion sistema cargada");
}
public void save(){
System.out.println("Configuracion sistema almacenada");
}
}
public class ConfiguracionUsuario implements RecursoPersistente{
public void load(){
System.out.println("Configuracion usuario cargada");
}
public void save(){
System.out.println("Configuracion usuario almacenada");
}
}
public class ConfiguracionHoraria implements RecursoPersistente{
public void load(){
System.out.println("Configuracion horaria cargada");
}
public void save() {
System.out.println("ERROR, la hora no se puede almacenar, es solo de lectura");
}
}


// De manera que tenemos una clase Configuracion, que es responsable de cargar todas las
// configuraciones disponibles y posteriormente almacenarlas, tal y como se muestra en la
// siguiente clase:
public class Configuracion {
Vector<RecursoPersistente> conf=new Vector<RecursoPersistente>();
public void cargarConfiguracion(){
conf.add(new ConfiguracionSistema());
conf.add(new ConfiguracionUsuario());
conf.add(new ConfiguracionHoraria());
for (Iterator<RecursoPersistente> i = conf.iterator(); i.hasNext(); )
i.next().load();

}
public void salvarConfiguracion(){
for (Iterator<RecursoPersistente> i = conf.iterator(); i.hasNext(); )
i.next().save();

}
}

// Consultas:
// 1. Crea un programa principal que ejecute los métodos de la clase Configuración.
// 2. Cumple la clase Configuracion en Principio OCP. Justifica la respuesta.
// 3. Cumple la clase Configuracion el Principio de Liskov. Justifica la respuesta.
// 4. Refactoriza la aplicación para que cumpla el principio de Liskov. La solución a

// este ejercicio lo puedes encontrar en: https://lassala.net/2010/11/04/a-good-
// example-of-liskov-substitution-principle/

// 5. Explica de forma general (independientemente del ejemplo) cual es el
// problema y la solución propuesta.

// Respuestas:
// 1. 
public class ProgramaPrincipal {
    public static void main(String[] args) {
        Configuracion configuracion = new Configuracion();
        
        // Cargar la configuración
        configuracion.cargarConfiguracion();
        
        // Salvar la configuración
        configuracion.salvarConfiguracion();
    }
}
//

// 2. No cumple, ya que si bien esta abierta a la extensión. Sin embargo, si se quisiera cambiar el comportamiento 
// de la clase Configuracion como por ejemplo, permitir la eliminación de una configuración, se tendría que modificar
// la clase. En este sentido, no se cumple completamente con el Principio OCP, ya que la clase no está completamente cerrada a la modificación.

// 3. Sí cumple, ya que todas las clases que implementan la interfaz RecursoPersistente pueden ser utilizadas de en la
// clase Configuracion sin afectar el funcionamiento del programa. La clase Configuracion no depende de las clases que 
// implementan RecursoPersistente, sino que solo se basa en el hecho de que pueden cargar y guardar datos.
