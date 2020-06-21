package ChainOfResponsibility;

import State.PreparingPackage;

public class AbroadWorker extends Worker {

    public AbroadWorker(String name) {
        super(name);
        this.setQualification(Worker.ABROAD);
    }

    @Override
    void preparePackage(Package newPackage) {
        System.out.println(this.getName() + " is preparing " + newPackage.getName());
        this.setState(new PreparingPackage());
    }
}
