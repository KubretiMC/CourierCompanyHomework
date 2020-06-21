package ChainOfResponsibility;

public class Package {

    private String name;

    private int workerQualification;

    public Package(String name, int workerQualification) {
        this.setName(name);
        this.workerQualification = workerQualification;
    }

    public int getWorkerQualification() {
        return workerQualification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
