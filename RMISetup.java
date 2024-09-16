import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class RMISetup {
    public static void main(String[] args) {
        try {
            // Number of processes (example: 3)
            int numProcesses = 3;
            VectorClockImpl vectorClock = new VectorClockImpl(numProcesses);
            int processId = 1; // Example process ID

            RemoteProcessImpl remoteProcess = new RemoteProcessImpl(vectorClock, processId);

            // Create registry on a specific port (e.g., 1100)
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("RemoteProcessService", remoteProcess);

            System.out.println("Server ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
