package frontend.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseWrapper {
    private String token;
    private User resp;
}
