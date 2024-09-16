import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

public class VectorClockImpl extends UnicastRemoteObject implements VectorClock, Serializable {
    private static final long serialVersionUID = 1L;
    private int[] clock;

    // Constructor with number of processes
    public VectorClockImpl(int numProcesses) throws RemoteException {
        super();
        clock = new int[numProcesses];
    }

    @Override
    public int[] getClock() throws RemoteException {
        return clock;
    }

    @Override
    public void increment(int processId) throws RemoteException {
        if (processId >= 0 && processId < clock.length) {
            clock[processId]++;
        }
    }

    @Override
    public void update(int[] remoteClock) throws RemoteException {
        for (int i = 0; i < clock.length; i++) {
            clock[i] = Math.max(clock[i], remoteClock[i]);
        }
    }

    @Override
    public int[] merge(int[] clock1, int[] clock2) throws RemoteException {
        int[] mergedClock = new int[Math.max(clock1.length, clock2.length)];
        for (int i = 0; i < mergedClock.length; i++) {
            mergedClock[i] = Math.max(i < clock1.length ? clock1[i] : 0,
                                      i < clock2.length ? clock2[i] : 0);
        }
        return mergedClock;
    }
}
