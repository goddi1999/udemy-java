package org.example;

class Robot {

    // Roboter kann sich in einem von drei Zuständen befinden
    enum RobotState {
        HIGH,
        LOW,
        EMPTY
    }

    RobotState state = RobotState.HIGH;
    int reward = 0; 
    boolean asleep = false;


    public Integer getReward(){
        return reward;
    }
    
    public RobotState getState(){
        return state;
    }

    public boolean getAsleep(){
        return asleep;
    }

    // HIGH -> LOW -> EMPTY
    public void getNext(){
        RobotState currentState = state;
        switch (currentState) {
            case HIGH:
                currentState = RobotState.LOW;
                break;
            case LOW:
                currentState = RobotState.EMPTY;
                break;
            default:
                currentState = RobotState.HIGH;
                break;
        }
    }


    // idle  dafür einen Reward von +1.
    // Gibt die Nachricht

    public void idle(){
        reward = reward + 1;
        System.out.println("Idling successful, gained one reward, now in state  " +  getState());
    }


    // Roboter bereits in State HIGH ist, passiert nichts und eine entsprechende Nachricht wird zurückgegeben.
    // allen anderen Fällen wird der Zustand auf HIGH gesetzt und ebenfalls eine Nachricht zurückgegeben.
    public void recharge(){

        RobotState currentState = getState();

        switch(currentState) {
            case HIGH:
                System.out.println("you already on state high");
                break;
            case LOW:  case EMPTY:
                currentState = RobotState.HIGH;
                System.out.println("recharges succeeded: " + currentState);
                break;
        }
    }

    // zufällige zahl ermittelt
    public void work(){
        double randomNum = (Math.random() * 10) + 0;
    }
  

}