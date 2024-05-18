package Network;

public class Message {
    private String username;
    private String data;

    public Message(String username, String data) {
        this.username = username;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getUsername() {
        return username;
    }
}
