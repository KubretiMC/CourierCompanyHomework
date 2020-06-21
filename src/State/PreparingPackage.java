package State;

import ChainOfResponsibility.Worker;

public class PreparingPackage implements WorkerState {

    private String name = "PREPARING_THE_PACKAGE";

    @Override
    public void setState(Worker worker) {
        worker.setState(this);
    }

    @Override
    public String getStateName() {
        return this.name;
    }
}
