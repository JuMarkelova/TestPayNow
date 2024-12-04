package frontend.entity;

import lombok.*;

//добавить lombok
//готово
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
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
