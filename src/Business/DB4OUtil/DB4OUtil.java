package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.EcoSystem;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;

/**
 *
 * @author anushaprakash
 */
public class DB4OUtil {

    private static final String FILENAME = "Databank.db4o";
    //private static final String FILENAME = "/Users/anushaprakash/Downloads/Integrated-Hospital-Management-System-INFO5100-AED-main/Databank.db4o";
    //private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString(); // path to the data store
    private static DB4OUtil dB4OUtil;
    private ObjectContainer conn;

    public synchronized static DB4OUtil getInstance() {
        if (dB4OUtil == null) {
            dB4OUtil = new DB4OUtil();
            dB4OUtil.createConnection(); // Initialize the connection when the instance is created
        }
        return dB4OUtil;
    }

    private void createConnection() {
        try {
            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            // config.common().add(new TransparentPersistenceSupport());
            config.common().activationDepth(Integer.MAX_VALUE);
            config.common().updateDepth(Integer.MAX_VALUE);
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            conn = Db4oEmbedded.openFile(config, FILENAME);
        } catch (Exception ex) {
            System.err.println("Error creating connection: " + ex.getMessage());
        }
    }

    protected synchronized void shutdown() {
        if (conn != null) {
            conn.close();
            conn = null; // Set to null to avoid using a closed connection
        }
    }

    public synchronized void storeSystem(EcoSystem system) {
        try {
            if (conn == null) {
                createConnection(); // Ensure the connection is created
            }
            conn.store(system);
            conn.commit();
        } catch (Exception ex) {
            System.err.println("Error storing system: " + ex.getMessage());
        }
    }

    public EcoSystem retrieveSystem() {
        EcoSystem system = null;
        try {
            if (conn == null) {
                createConnection(); // Ensure the connection is created
            }
            ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class); // Change to the object you want to save
            if (systems.size() == 0) {
                system = ConfigureASystem.configure(); // If there's no System in the record, create a new one
            } else {
                system = systems.get(systems.size() - 1);
            }
        } catch (Exception ex) {
            System.err.println("Error retrieving system: " + ex.getMessage());
        }
        return system;
    }
}