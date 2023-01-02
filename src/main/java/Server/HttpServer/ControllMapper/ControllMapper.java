package Server.HttpServer.ControllMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControllMapper {
    private ObjectMapper objectMapper;

    public ControllMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ObjectMapper getObjectMapper()
    {
        return objectMapper;
    }
}
