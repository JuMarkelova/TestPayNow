package frontend.entity;

public class UserResponseWrapper {
    private String token;
    private User resp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getResp() {
        return resp;
    }

    public void setResp(User resp) {
        this.resp = resp;
    }
}
