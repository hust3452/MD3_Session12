package ra.demo.Model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flight")
@Setter
@Getter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String flightName;

    @Column(nullable = false)
    private String startingPoint;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private LocalDate departureDate;

    @Column(nullable = false)
    private Double arrivalTime;

    @Column(nullable = false)
    private String timeUnit;

    private String travelImage;

    @Enumerated(EnumType.STRING)
    private Status status;
}
