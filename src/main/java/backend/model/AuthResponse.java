package backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private Resp resp;

    @Data
    public static class Resp {
        private String name;
        private String email;
        private String password;
        private long number;
        private int balance;
        private String address;
        private String uid;
        private long pin;
        private String _id;
        private int __v;
    }
}