import java.rmi.Naming;

public class CalcClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote object from the registry
            ICalc calc = (ICalc) Naming.lookup("rmi://localhost/calc");

            // Call remote methods and print results
            System.out.println("Addition: " + calc.add(5, 3));
            System.out.println("Subtraction: " + calc.sub(5, 3));
            System.out.println("Multiplication: " + calc.mul(5, 3));
            System.out.println("Division: " + calc.div(5, 3));

        } catch (Exception e) {
            System.out.println("Client Exception: " + e);
            e.printStackTrace();
        }
    }
}
