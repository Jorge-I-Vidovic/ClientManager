package ClientManager.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptador {
    public static void main(String[] args) {
        var password = "User1234*";
        System.out.println("Password: " + password);
        System.out.println("Password encriptado: " + encriptPassword(password));
    }

    public static String encriptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
