import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteProcess extends Remote {
    VectorClock getVectorClock() throws RemoteException;
    void sendEvent(int eventId, String data) throws RemoteException;
}
