public class Factura {

    public String codigo;
    public Date fechaEmision;
    public float importeFactura;
    public float importeIVA;
    public float importeDeduccion;
    public float importeTotal;
    public int porcentajeDeduccion;
    //Agregamos los atributos privados
    private Deduccion deduccion;
    private Iva iva;

    //Agregamos constructor
    public Factura(Deduccion deduccion, Iva iva) {
        this.deduccion = deduccion;
        this.iva = iva;
    }

    //Modificamos metodo que calcula el total de la factura
    // Método que calcula el total de la factura
    public void calcularTotal() {
        // Calculamos la deducción
        importeDeduccion = deduccion.calculaDeduccion(importeFactura, porcentajeDeduccion);
        // Calculamos el IVA
        importeIVA = iva.calculaIva(importeFactura);
        // Calculamos el total
        importeTotal = (importeFactura - importeDeduccion) + importeIVA;
    }
}


//Consultas:
//1.Cumple el principio de Inversión de dependencia. Justifica la respuesta.
    // NO, ya que la clase depende directamente de las clases Deducción e IVA para realizar el calculo de la factura.
    // Esto hace que la clase Factura este fuertemente acoplada con las implementaciones de Deduccion e Iva para
    // realizar el calculoTotal. 

//2. En caso negativo, refactoriza el código par que cumpla el principio.
    // Se refactoriza, utilizando inyección de dependencias, donde en lugar de llamar las clases directamente en la implementación,
    // se convierten en parametros del constructor, de esta forma, la clase Factura dependera de las abstracciones realizadas directamente
    // en las clases Factura e Iva y no en las implementaciones especificas que se hacen por fuera.