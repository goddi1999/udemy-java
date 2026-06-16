package  org.example;

public class AccountLockedException extends Exception {
        public AccountLockedException(String message) {
            super(message);
        }
    }