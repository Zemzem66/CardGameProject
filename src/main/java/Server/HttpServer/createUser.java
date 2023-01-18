package Server.HttpServer;
import Server.HttpServer.ControllMapper.ControllMapper;
import Server.HttpServer.Handle.Dao;
import Server.HttpServer.Http.ContentType;
import Server.HttpServer.Http.HttpStatus;
import Server.HttpServer.UtilsServer.Request;
import Server.HttpServer.UtilsServer.Response;
import Server.HttpServer.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


public class createUser extends ControllMapper {

    private Dao userDao;
    public createUser()
    {
        this.userDao = new Dao();
    }

    public Response getUser(String id)
    {
        try{
            User userData =this.userDao.getUser(Integer.parseInt(id));
            String userDataJSON = this.getObjectMapper().writeValueAsString(userData);

            return new Response(HttpStatus.OK, ContentType.JSON,userDataJSON);
        } catch (JsonProcessingException e) {

            e.printStackTrace();
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR, ContentType.JSON,"ERROR");
        }
    }

    public Response getUser()
    {
        try{
            List userData =this.userDao.getUser();
            String userDataJSON = this.getObjectMapper().writeValueAsString(userData);
            return new Response(HttpStatus.OK, ContentType.JSON, userDataJSON);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR, ContentType.JSON, "ERROR");
        }
    }

    public Response createUser(Request request)
    {
        try {
            User user = this.getObjectMapper().readValue(request.getBody(),User.class);
            //TODO:
            this.userDao.addUser(user);

            return new Response(HttpStatus.OK,ContentType.JSON, "User SuccesfullyAdded");
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR, ContentType.JSON, "Internal Server Error");
    }
}
