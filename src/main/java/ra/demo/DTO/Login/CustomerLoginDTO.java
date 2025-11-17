package ra.demo.DTO.Login;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerLoginDTO {
    @NotBlank(message = "email can not null")
    private String email;

    @NotBlank(message = "password can not null")
    private String password;
}
