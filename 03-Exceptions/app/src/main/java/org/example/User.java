package  org.example;

class User {

    private  String username;
    private  String password;
    private  int attempts;

    public User(){}

    public User(String username, String password, int attempts){
        this.username =  username;
        this.password =  password;
        this.attempts =  attempts;
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
            
            
        }
    }

}