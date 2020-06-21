package ChainOfResponsibility;

import State.PreparingPackage;

public class PlovdivWorker extends Worker {

    public PlovdivWorker(String name) {
        super(name);
        this.setQualification(Worker.PLOVDIV);
    }

    @Override
    void preparePackage(Package newPackage) {
        System.out.println(this.getName() + " is preparing " + newPackage.getName());
        this.setState(new PreparingPackage());
    }
}
