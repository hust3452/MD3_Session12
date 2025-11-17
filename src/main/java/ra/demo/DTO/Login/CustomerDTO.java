package ra.demo.DTO.Login;


import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import ra.demo.Model.Login.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    @NotBlank(message = "Customer Name can not blank")
    private String customerName;

    @NotBlank(message = "email can not blank")
    @Email(message = "email validate fails")
    private String email;

    @NotBlank(message = "password can not blank")
    @Length(min = 6)
    private String password;

    @NotBlank(message = "phone can not blank")
    @Pattern(regexp = "^(84|03|05|07|08|09)[0-9]{8}$", message = "Phone invalid")
    private String phone;
}

