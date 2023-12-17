// Login.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login {
    private static final String CREDENTIALS_FILE = "credentials.txt";
    private static final Map<String, String> userCredentials = loadCredentials();

    private static Map<String, String> loadCredentials() {
        Map<String, String> credentials = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CREDENTIALS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    credentials.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return credentials;
    }

    public static boolean authenticate(String username, String password) {
        String storedPassword = userCredentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static String getPassword(String username) {
        return userCredentials.get(username);
    }
}
