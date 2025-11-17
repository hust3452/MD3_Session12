package ra.demo.DTO.Product;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter

public class ProductDTO {

    @NotBlank(message = "title can not blank")
    private String title;

    @NotBlank(message = "author can not blank")
    private String author;

    @NotNull(message = "price can not null")
    @Min(1)
    private Double price;

    @NotNull(message = "Public Year can not null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicYear;

    private MultipartFile image;
}
