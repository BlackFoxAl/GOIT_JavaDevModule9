package module9;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws Exception {
        String protocol = "https";
        String domen = "http.cat";
        String path = "/" + code + ".jpg";
        try {
            URI uri = new URI(protocol, domen, path, null);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 404) {
                throw new Exception("There is not image for HTTP status " + code);
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return protocol + "://" + domen + path;
    }
}
