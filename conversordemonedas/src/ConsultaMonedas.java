import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedas {
    public String buscarMonedas (String monedaBase, String monedaObjetvo, double monto) {
        String urlBase = "https://v6.exchangerate-api.com/v6/064d320ae2a94aa10178f7b1/pair/";

        try {
            URI direccion = URI.create(urlBase +
                    monedaBase + "/" + monedaObjetvo + "/" + monto);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // uso de elementos de la librería Gson, según recomendación de la página ExchangeReta-Api
            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            var fecha = jsonObject.get("time_last_update_utc").getAsString();
            String informacion = """
                  La transacción se ha realizado con éxito.
                  La fecha de hoy es: %s
                    """.formatted(fecha);
            System.out.println(informacion);

            return jsonObject.get("conversion_result").getAsString();
        } catch (NumberFormatException | IOException | InterruptedException e) {
            System.out.println("Se ha producido un error..." + e.getMessage());
        }
        return monedaBase;
    }
}
