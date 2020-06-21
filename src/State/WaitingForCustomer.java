package State;

import ChainOfResponsibility.Worker;

public class WaitingForCustomer implements WorkerState {

    private String name = "WAITING_FOR_CUSTOMER";

    @Override
    public void setState(Worker worker) {
        worker.setState(this);
    }

    @Override
    public String getStateName() {
        return this.name;
    }
}
