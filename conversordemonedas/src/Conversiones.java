import java.util.Scanner;

public class Conversiones {
    // nombres sugeridos en la página de la api
    private String monedaBase;
    private String monedaObjetivo;
    private double monto;

    Scanner lecturaDeMonto = new Scanner(System.in);
    ConsultaMonedas conversion;

    // Aquí uso algo que encontré en internet
    public Conversiones (ConsultaMonedas conversion) {
        this.conversion = conversion;
    }

    // generación automática de métodos get
    public String getMonedaBase() {
        return monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public double getMonto() {
        return monto;
    }

    // definición del guardarDatos
    public void guardarDatos (String monedaBase, String monedaObjetivo) {
        // pasamos los códigos de la monedaBase y monedaObjetivo
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;

        // ingreso la cantidad de la monedaBase a convertir en monedaObjetivo
        System.out.println("Ingrese el monto a convertir: ");
        this.monto = lecturaDeMonto.nextDouble();
    }

    // definición del respuesta
    public String respuesta () {
        String mensaje = "El monto de " + getMonto() + " (" + getMonedaBase() + ")" +
                " es equivalentes a: " +
                conversion.buscarMonedas(getMonedaBase(), getMonedaObjetivo(), getMonto()) +
                " (" + getMonedaObjetivo() + ")";

        System.out.println(mensaje);
        return mensaje;
     }
}
