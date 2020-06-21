package State;

import ChainOfResponsibility.Worker;

public interface WorkerState {

    void setState(Worker worker);
    String getStateName();
}
