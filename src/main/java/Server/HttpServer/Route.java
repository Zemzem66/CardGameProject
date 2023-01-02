package Server.HttpServer;

import java.util.HashMap;
import java.util.Map;

public class Route {

    private Map<String, HandleRequestService> serviceRegistry = new HashMap<>();

    public void addService(String route, HandleRequestService service)
    {
        this.serviceRegistry.put(route, service);
    }

    public void removeService(String route)
    {
        this.serviceRegistry.remove(route);
    }

    public HandleRequestService resolve(String route)
    {
        return this.serviceRegistry.get(route);
    }
}
