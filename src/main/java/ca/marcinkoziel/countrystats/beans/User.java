package ca.marcinkoziel.countrystats.beans;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String email;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Authority> authorities;
    @NonNull
    private boolean enabled;

}
