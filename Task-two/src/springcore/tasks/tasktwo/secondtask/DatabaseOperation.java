package springcore.tasks.tasktwo.secondtask;

public class DatabaseOperation {
    private String url;
    private String username;
    private String password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void openConnection() {
        System.out.println(String.format("Open connection to %s with %s and %s", url, username, password));
    }
    public void closeConnection() {
        System.out.println(String.format("Close connection to %s with %s and %s", url, username, password));
    }
    public void insertData(String data) {
        System.out.println(String.format("Insert data: %s to %s with %s and %s", data, url, username, password));
    }
}
