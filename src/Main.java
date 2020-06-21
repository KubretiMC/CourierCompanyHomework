import ChainOfResponsibility.AbroadWorker;
import ChainOfResponsibility.BulgariaWorker;
import ChainOfResponsibility.Worker;
import ChainOfResponsibility.Package;
import ChainOfResponsibility.PlovdivWorker;
import Observer.Boy;
import State.WorkerState;
import State.WaitingForCustomer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Worker abroadWorker = new AbroadWorker("Worker1");
        Worker bulgariaWorker = new BulgariaWorker("Worker2");
        Worker plovdivWorker = new PlovdivWorker("Worker3");

        Boy observer = new Boy("Simeon");

        List<Worker> workers = new ArrayList<>();
        workers.add(abroadWorker);
        workers.add(bulgariaWorker);
        workers.add(plovdivWorker);

        WorkerState waitingForCustomer = new WaitingForCustomer();

        abroadWorker.setNextWorker(bulgariaWorker);
        bulgariaWorker.setNextWorker(plovdivWorker);

        for (int i = 0; i < workers.size(); i++){
            Worker temp = workers.get(i);
            temp.setObserver(observer);
            waitingForCustomer.setState(temp);
        }

        abroadWorker.prepareOrPassToNext(new Package("Package for Plovdiv", Worker.PLOVDIV));
        bulgariaWorker.prepareOrPassToNext(new Package("Package for Burgas", Worker.BULGARIA));
        bulgariaWorker.prepareOrPassToNext(new Package("Package for Plovdiv", Worker.PLOVDIV));
        abroadWorker.prepareOrPassToNext(new Package("Package for France", Worker.ABROAD));
        plovdivWorker.prepareOrPassToNext(new Package("Package for Plovdiv", Worker.PLOVDIV));
    }
}
