package  org.example;

import java.util.ArrayList;

class AuthenticationManager {
    private String username;
    private String password;

    private final ArrayList<User> userList = new ArrayList();


    public AuthenticationManager(){
        
    }

    public void registerUser(String username, String password) throws RegistrationException{
        User newUser = new User(username, password);
        boolean userNameExists = false;

        User userInList = getUserByUsername(username);
        if(userInList instanceof User) userNameExists = true;

        if(userNameExists){
            throw new RegistrationException("username already exists");
        }else {
            userList.add(newUser);
        }
    }

    public void login(String username, String password) throws LoginException,  AccountLockedException{
        
        User currentUser = getUserByUsername(username);
        if(currentUser.getAttempts() == 0 ){
            throw new AccountLockedException("account locked out of login attempts");
        }
        if(currentUser instanceof User && 
            currentUser.getPassword().equals(password)
        ){
            currentUser.resetAttempts();
        }else {
            int currentUserAttempts = currentUser.getAttempts();
            currentUser.setAttempts(currentUserAttempts=-1);
            throw new LoginException("wrong credentials try again...");
        }
    }


    public  User getUserByUsername(String username){
        User foundUser = null; 

        for (User currentUser : userList) {
            if(currentUser.getUsername().equals(username)){
                foundUser = currentUser;
            }  
        }

        return foundUser;
    }


    
}