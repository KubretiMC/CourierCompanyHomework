package ChainOfResponsibility;

import Observer.Boy;
import State.WorkerState;

public abstract class Worker {

    public static final int PLOVDIV = 1;
    public static final int BULGARIA = 2;
    public static final int ABROAD = 3;

    private String name;
    private Boy observer;
    private WorkerState state;
    private int qualification;
    private Worker nextWorker;

    public Worker(String name) {
        this.name = name;
    }

    abstract void preparePackage(Package newPackage);

    public void notifyObserver() {
        observer.changeState(this);
    }

    public void prepareOrPassToNext(Package newPackage) {
        String stateName = this.state.getStateName();

        if (this.qualification == newPackage.getWorkerQualification() && stateName.equals("WAITING_FOR_CUSTOMER")) {
            this.preparePackage(newPackage);
        }
        else {
            this.nextWorker.prepareOrPassToNext(newPackage);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setObserver(Boy observer) {
        this.observer = observer;
    }

    public WorkerState getState() {
        return state;
    }

    public void setState(WorkerState state) {
        this.state = state;
        this.notifyObserver();
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public void setNextWorker(Worker nextWorker) {
        this.nextWorker = nextWorker;
    }
}
