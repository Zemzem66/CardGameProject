package Server.HttpServer;
import Server.HttpServer.ControllMapper.ControllMapper;
import Server.HttpServer.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class createUser extends ControllMapper {

    public createUser(ObjectMapper objectMapper) {
        super(objectMapper);
    }

    public Response createUser(Request request)
    {
        try {
            User user = this.getObjectMapper().readValue(request.getBody(),User.class);
            //TODO:
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return createUser(request);
    }
}
