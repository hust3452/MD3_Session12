package ra.demo.Model.Login;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue
    private long customerId;

    @Column(nullable = false)
    private String customerName;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;
}