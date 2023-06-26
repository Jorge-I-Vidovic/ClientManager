package ClientManager.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptPassword {
    public static void main(String[] args) {
        var password = "root9876";
        System.out.println("Password: " + password);
        System.out.println("Password encript: " + encriptPassword(password));
    }

    public static String encriptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
