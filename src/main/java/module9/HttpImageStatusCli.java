package module9;

import java.util.Scanner;

public class HttpImageStatusCli {
    void askStatus() {
        Scanner scanner = new Scanner(System.in);

        try (scanner) {
            System.out.print("Enter HTTP status code: ");
            String userInput = scanner.nextLine();
            int statusCode = Integer.parseInt(userInput);
            new HttpStatusImageDownloader().downloadStatusImage(statusCode);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
