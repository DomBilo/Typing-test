package TypingTestVT;

public class User {
    private String name;
    private String password;
    private int displayResults;

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }
    @Override
    public String toString() {
        String tmp = "The name is: " + this.name + "\n"
                + "The password: " + this.password;

        return tmp;
    }
}
