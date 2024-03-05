import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MonServiceRPCServeur extends UnicastRemoteObject implements MonServiceRPCInterface {
    private static final long serialVersionUID = 1L;
	protected MonServiceRPCServeur() throws RemoteException {
        super();
    }

    @Override
    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public static void main(String[] args) {
        // Code pour démarrer le serveur RMI ici
        try {
             MonServiceRPCInterface monService = new MonServiceRPCServeur();
             Registry registry = LocateRegistry.createRegistry(1099);
             registry.rebind("MonServiceRPC", monService);
             System.out.println("Serveur RPC prêt.");
        }
         catch (Exception e) {
             e.printStackTrace();
        }	
    }
}

