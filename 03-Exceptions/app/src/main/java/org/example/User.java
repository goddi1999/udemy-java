package  org.example;

class User {

    private  String username;
    private  String password;
    private  int attempts;

    public User(){}

    public User(String username, String password){
        this.username =  username;
        this.password =  password;
        this.attempts =  3;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public void updateAttempts(){
        int currentAttempts = getAttempts();
        if(currentAttempts != 0){
            currentAttempts =- 1;
        }
    }

    public void resetAttempts(){
        setAttempts(3);
    }


}