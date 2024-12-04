package frontend.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithToken {
    private User user;
    private String token;
}
