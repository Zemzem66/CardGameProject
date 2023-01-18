package Server.HttpServer.UtilsServer;

import Server.HttpServer.Http.ContentType;
import Server.HttpServer.Http.HttpStatus;
import Server.HttpServer.Http.Method;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    @Test
    void testResponse()
    {
        Response response = new Response(HttpStatus.OK, ContentType.PLAIN_TEXT,"Hello");
        assertEquals( response.get(), response.get());
        System.out.println(response.get());
        response.get();
    }
/*
    @Test
    void testBadResponse()
    {
        Response response = new Response(HttpStatus.BAD_REQUEST, ContentType.PLAIN_TEXT,"Test");
        assertEquals( "HTTP/1.1 400 Bad Request\n" +
                "Content-Type: text/plain\n" +
                "Content-Length: 4\n" +
                "Connection: close\n" +
                "\n" +
                "Test", String.valueOf(response.get()));
        System.out.println(response.get());
        response.get();
    }

 */
}

