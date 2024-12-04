package frontend.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserWithToken {
    private User user;
    private String token;
}
