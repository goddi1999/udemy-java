package org.example;

class Robot {

    // Roboter kann sich in einem von drei Zuständen befinden
    enum RobotState {
        HIGH,
        LOW,
        EMPTY
    }

    private RobotState state = RobotState.HIGH;
    private int reward = 0; 
    private boolean asleep = false;

    public Robot(Integer reward, RobotState state, boolean asleep) {
        this.reward = reward;
        this.state = state;
        this.asleep = asleep;
    }

    public Robot(){

    }

    public Integer getReward(){
        return reward;
    }
    
    public RobotState getState(){
        return state;
    }

    public boolean getAsleep(){
        return asleep;
    }

        public void setReward(Integer reward) {
        this.reward = reward;
    }

    public void setState(RobotState state) {
        this.state = state;
    }

    public void setAsleep(boolean asleep) {
        this.asleep = asleep;
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

    public String idle(){
        reward =+ 1;
        return  "Idling successful, gained one reward, now in state  " +  getState();
    }


    // Roboter bereits in State HIGH ist, passiert nichts und eine entsprechende Nachricht wird zurückgegeben.
    // allen anderen Fällen wird der Zustand auf HIGH gesetzt und ebenfalls eine Nachricht zurückgegeben.
    public String recharge(){
        String message = "";

        RobotState currentState = getState();

        switch(currentState) {
            case HIGH:
                message = "WARNING: you already on state high not need to recharge";
                break;
            case LOW:  case EMPTY:
                currentState = RobotState.HIGH;
                message = "SUCCESS: recharges succeeded: " + currentState;
                break;
        }


        return message;
    }

    // zufällige zahl ermittelt
    public String work(){
        double randomNum = (Math.random());
        String message = "";
        int currentReward = getReward();
        boolean currentAsleep = getAsleep();


        if(randomNum  <= 0.60){
            getNext();
        }

        if(state == RobotState.EMPTY){
            setAsleep(!currentAsleep);
            setReward( currentReward =- 5);
            message = "MODE-EMPTY: Robot is empty asleep";
        }else {
            setReward( currentReward =+ 5);
            message = "MODEW-WORKING: working";

        }

        return message;
    }
  

}