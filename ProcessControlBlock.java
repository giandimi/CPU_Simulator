import java.util.ArrayList;

public class ProcessControlBlock {

    private final int pid;
    private ProcessState state;
    // the following two ArrayLists should record when the process starts/stops
    // for statistical purposes
    private ArrayList<Integer> startTimes; // when the process starts running
    private ArrayList<Integer> stopTimes;  // when the process stops running

    private static int pidTotal= 0;

    public ProcessControlBlock() {
        this.state = ProcessState.NEW;
        this.startTimes = new ArrayList<Integer>();
        this.stopTimes = new ArrayList<Integer>();
        this.pid = pidTotal; // change this line
        pidTotal++;

    }

    public ProcessState getState() {
        return this.state;
    }

    public void setState(ProcessState state, int currentClockTime) {


        if (state == ProcessState.RUNNING){
            this.startTimes.add(currentClockTime);
        } else if (state == ProcessState.READY) {
            this.stopTimes.add(currentClockTime);
            if (this.state == ProcessState.NEW) { CPU.clock++; }
        } else {
            this.stopTimes.add(currentClockTime);
        }
        this.state = state;
    }

    public int getPid() {
        return this.pid;
    }

    public ArrayList<Integer> getStartTimes() {
        return startTimes;
    }

    public ArrayList<Integer> getStopTimes() {
        return stopTimes;
    }

}
