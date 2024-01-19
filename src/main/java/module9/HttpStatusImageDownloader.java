package module9;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) throws Exception{

        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String imageUrl = httpStatusChecker.getStatusImage(code);
        System.out.println("Image URL: " + imageUrl);

        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (InputStream in = connection.getInputStream()) {
            String fileName = code + ".jpg";
            Path outputPath = Path.of(fileName);
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image downloaded and saved as: " + fileName);
        }

    }
}
