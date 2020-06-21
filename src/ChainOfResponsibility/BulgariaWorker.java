package ChainOfResponsibility;

import State.PreparingPackage;

public class BulgariaWorker extends Worker {

    public BulgariaWorker(String name) {
        super(name);
        this.setQualification(Worker.BULGARIA);
    }

    @Override
    void preparePackage(Package newPackage) {
        System.out.println(this.getName() + " is preparing " + newPackage.getName());
        this.setState(new PreparingPackage());
    }
}
