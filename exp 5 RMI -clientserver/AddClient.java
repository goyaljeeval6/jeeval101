import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AddClient {
    public static void main(String[] args) {
        try {
            Registry registry =
                    LocateRegistry.getRegistry("localhost", 1099);

            AddService service =
                    (AddService) registry.lookup("AdditionService");

            int result = service.add(10, 20);

            System.out.println("Result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}