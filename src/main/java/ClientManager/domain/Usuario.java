package ClientManager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Rol> roles;

}
