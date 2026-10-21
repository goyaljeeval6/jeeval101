import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AddServer {
    public static void main(String[] args) {
        try {
            AddService service = new AddServiceImpl();

            Registry registry =
                    LocateRegistry.createRegistry(1099);

            registry.rebind("AdditionService", service);

            System.out.println("Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}