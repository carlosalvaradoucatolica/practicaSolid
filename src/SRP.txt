Planteado por profe
___________________________
public class Factura { 
public String codigo; 
public Date fechaEmision; 
public float importeFactura; 
public float importeIVA; 
public float importeDeduccion; 
public float importeTotal; 
public int porcentajeDeduccion; 
// Método que calcula el total de la factura 
public void calcularTotal() { 
// Calculamos la deducción 
importeDeduccion = (importeFactura * porcentajeDeduccion) / 100; 
// Calculamos el IVA 
importeIVA = (float) (importeFactura * 0.16); 
// Calculamos el total 
importeTotal = (importeFactura - importeDeduccion) + importeIVA; 
} 
} 
__________________________________________________
public class Factura { 
    public String codigo; 
    public Date fechaEmision; 
    public float importeFactura; 
    public float importeIVA; 
    public float importeDeduccion; 
    public float importeTotal; 
    public int porcentajeDeduccion; 
// Método que calcula el total de la factura 
    public void calcularTotal() { 
        importeDeduccion = new CalculadorDeduccion().calcular(importeFactura, porcentajeDeduccion);
        importeIVA = new CalculadorIVA().calcular(importeFactura);
        importeTotal = importeFactura - importeDeduccion + importeIVA; 
    } 
}
___________________________________________________
La clase CalculadorDeduccion quedaría así:
// Calculamos la deducción 
public class CalculadorDeduccion {
    public float calcular(float importeFactura, int porcentajeDeduccion) {
        float importeDeduccion;
        if (importeFactura > 10000) {
            importeDeduccion = (importeFactura * porcentajeDeduccion + 3) / 100;
        } else {
            importeDeduccion = (importeFactura * porcentajeDeduccion) / 100;
        }
        return importeDeduccion;
    }
}
______________________________________________________
La clase CalculadorIVA quedaría así:
// Calculamos el IVA 
public class CalculadorIVA {
    private static final float TASA_IVA = 0.16f; // podemos hacerlo constante por ser un valor fijo

    public float calcular(float importeFactura) {
        return importeFactura * TASA_IVA;
    }
}
________________________________________________________
Si el cálculo de la deducción se hiciera en base al importe de la factura, la clase CalculadorDeduccion quedaría así:

public class CalculadorDeduccion {
    public float calcular(float importeFactura, int porcentajeDeduccion) {
        float importeDeduccion;
        if (importeFactura > 10000) {
            importeDeduccion = (importeFactura * porcentajeDeduccion + 3) / 100;
        } else {
            importeDeduccion = (importeFactura * porcentajeDeduccion) / 100;
        }
        return importeDeduccion;
    }
}
_______________________________________________________
2. Cambio del 16% al 18% de IVA:

Para cambiar la tasa de IVA, simplemente tendríamos que modificar la constante TASA_IVA de la clase CalculadorIVA:
// Calculamos el IVA 
public class CalculadorIVA {
    private static final float TASA_IVA = 0.18f;

    public float calcular(float importeFactura) {
        return importeFactura * TASA_IVA;
    }
}
_____________________________________________________________
3. Facturas codigo 0 sin iva.
//Si las facturas de código 0 no deben tener IVA, podemos agregar un booleano a la //clase Factura que indique si se debe aplicar o no el IVA. Luego, en la clase //CalculadorIVA, podemos verificar si se debe aplicar el IVA antes de hacer el //cálculo:
public class CalculadorIVA {
    private static final float TASA_IVA

