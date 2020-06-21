package Observer;

import ChainOfResponsibility.Worker;
import State.WorkerState;
import State.WaitingForCustomer;

public class Boy {

    private String name;

    public Boy(String name){
        this.name = name;
    }

    public void changeState(Worker worker) {
        WorkerState state = worker.getState();

        if (state.getStateName().equals("PREPARING_THE_PACKAGE")) {
            System.out.println(this.getName() + " is going to carry that package to the storehouse");

            WaitingForCustomer waitingState = new WaitingForCustomer();
            worker.setState(waitingState);
        }
        else {
            System.out.println(this.getName() + " is watching " + worker.getName() + " who is waiting for next customer");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
