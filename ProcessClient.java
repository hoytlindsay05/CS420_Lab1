import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;

public class ProcessClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object
            RemoteProcess remoteProcess = (RemoteProcess) Naming.lookup("rmi://localhost:1100/RemoteProcessService");

            // Example usage
            VectorClock vectorClock = remoteProcess.getVectorClock();
            vectorClock.increment(1); // Assuming this is a valid operation for the client

            remoteProcess.sendEvent(1, "Test event");

            System.out.println("Connected to the remote process.");

        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
