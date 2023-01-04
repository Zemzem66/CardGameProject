package Server.HttpServer.ControllMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControllMapper {
    private ObjectMapper objectMapper;

    public ControllMapper() {
        this.objectMapper = new ObjectMapper();
    }

    public ObjectMapper getObjectMapper()
    {
        return objectMapper;
    }

}
