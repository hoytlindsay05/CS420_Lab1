import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteProcessImpl extends UnicastRemoteObject implements RemoteProcess {
    private static final long serialVersionUID = 1L;
    private VectorClock vectorClock;
    private int processId;

    // Constructor with VectorClock and processId
    public RemoteProcessImpl(VectorClock vectorClock, int processId) throws RemoteException {
        super();
        this.vectorClock = vectorClock;
        this.processId = processId;
    }

    @Override
    public VectorClock getVectorClock() throws RemoteException {
        return vectorClock;
    }

    @Override
    public void sendEvent(int eventId, String data) throws RemoteException {
        vectorClock.increment(processId);
        System.out.println("Event sent with ID: " + eventId + " and data: " + data);
    }
}
