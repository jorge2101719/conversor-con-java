import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcion = -1;

        ConsultaMonedas consulta = new ConsultaMonedas();

        Conversiones conversiones = new Conversiones(consulta);

        // el menú lo hago según lo visto en clases
        String menuPrincipal = """
                \n***************************************************************
                Bienvenido al conversor de monedas. Por favor, escoja su opción
                1) Dólar ===> Peso (Argentina)
                2) Peso (Argentina) ===> Dólar
                3) Dólar ===> Real (Brasil)
                4) Real (Brasil) ===> Dólar
                5) Dólar ===> Pesos (Chile)
                6) Pesos (Chile) ===> Dólar
                7) Dólar ===> Euro
                8) Euro ===> Dólar
                9) Salir
                \n***************************************************************
                Eliga una de las alternativas anteriores
                """;

        while (opcion != 9) {
            try {
                System.out.println(menuPrincipal);
                // capturo la alternativa ingresada con nextInt, mostrado en clases
                opcion = lectura.nextInt();

                // situaciones tratadas con switch
                switch (opcion) {
                    case 1:
                        System.out.println("Convertirá Dólares en Pesos Argentinos");
                        conversiones.guardarDatos("USD", "ARS");
                        conversiones.respuesta();
                        break;
                    case 2:
                        System.out.println("Convertirá Pesos Argentinos en Dólares");
                        conversiones.guardarDatos("ARS", "USD");
                        conversiones.respuesta();
                        break;
                    case 3:
                        System.out.println("Convertirá Dólares en Reales (Brasil)");
                        conversiones.guardarDatos("USD", "BRL");
                        conversiones.respuesta();
                        break;
                    case 4:
                        System.out.println("Convertirá Reales (Brasil) a Dólares");
                        conversiones.guardarDatos("BRL", "USD");
                        conversiones.respuesta();
                        break;
                    case 5:
                        System.out.println("Convertirá Dólares en Pesos Chilenos");
                        conversiones.guardarDatos("USD", "CLP");
                        conversiones.respuesta();
                        break;
                    case 6:
                        System.out.println("Convertirá Pesos Chilenos en Dólares");
                        conversiones.guardarDatos("CLP", "USD");
                        conversiones.respuesta();
                        break;
                    case 7:
                        System.out.println("Convertirá Dólares en Euros");
                        conversiones.guardarDatos("USD", "EUR");
                        conversiones.respuesta();
                        break;
                    case 8:
                        System.out.println("Convertirá Euros en Dólares");
                        conversiones.guardarDatos("EUR", "USD");
                        conversiones.respuesta();
                        break;
                    case 9:
                        System.out.println("Graciaas por preferirnos");
                        break;
                    default:
                        System.out.println("La alternativa elegida no está en la lista. Intente nuevamente");
                }

            } catch (NumberFormatException e) {
                throw new RuntimeException("Houston, tenemos un problema..." + e.getMessage());
            }
        }
        System.out.println("El programa finalizó con éxito");
    }
}
