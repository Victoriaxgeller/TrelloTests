package api;

//TODO Add Lombok plugin for getters & setters generating
public class Board {
    private String name;
    private String id;
    private boolean closed;
    private String url;

    private String key = "9573304914308fbbbb60defc7e1de580";
    private String token = "02127a2751edd61503d444847454fd0af0fcdd996cdbbc91a5a6521b05b6b70b";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
