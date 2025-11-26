package ra.demo.DTO;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;
import ra.demo.Model.Status;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDTO {
    @NotBlank(message = "Name not blank")
    private String flightName;

    @NotBlank(message = "Starting Point not blank")
    private String startingPoint;

    @NotBlank(message = "Destination not blank")
    private String destination;

    @NotNull(message = "Date not blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @NotNull(message = "Arrival Date not blank")
    private Double arrivalTime;

    @NotBlank(message = "Time Unit not blank")
    private String timeUnit;

    private MultipartFile travelImage;

    @Enumerated(EnumType.STRING)
    private Status status;
}
