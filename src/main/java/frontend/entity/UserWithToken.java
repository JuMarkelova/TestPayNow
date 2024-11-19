package frontend.entity;

public class UserWithToken {
    private User user;
    private String token;

    public UserWithToken(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}
