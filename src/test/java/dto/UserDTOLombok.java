package dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class UserDTOLombok {
    private String email;
    private String password;
}
