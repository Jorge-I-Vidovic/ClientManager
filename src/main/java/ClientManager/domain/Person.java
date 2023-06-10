package ClientManager.domain;
import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "test.persona")
public class Person {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
}
