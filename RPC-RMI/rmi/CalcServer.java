import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalcServer {
    public static void main(String[] args) {
        try {
            // Start the RMI registry programmatically on port 1099
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI Registry started on port 1099");

            // Create the remote object
            CalcImpl calc = new CalcImpl();

            // Bind the remote object to the registry with the name "calc"
            Naming.rebind("rmi://localhost/calc", calc);

            System.out.println("RMI Server is running at rmi://localhost/calc");
        } catch (Exception e) {
            System.out.println("Server Exception: " + e);
            e.printStackTrace();
        }
    }
}
