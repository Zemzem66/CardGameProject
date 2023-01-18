package Server.HttpServer.RequestUtils;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.jupiter.api.Assertions.*;

class RequestHandlerTest {

    @Test
    void testPath() throws MalformedURLException {
        URL urlFirst = new URL("http://localhost:10001/cards");
        URL urlSecond = new URL("http://localhost:10001/package");
        URL urlThird = new URL("http://localhost:10001/trade");
        URL urlFourth = new URL("http://localhost:10001/delete");

        assertEquals("/cards", urlFirst.getPath());
        assertEquals("/package", urlSecond.getPath());
        assertEquals("/trade", urlThird.getPath());
        assertEquals("/delete", urlFourth.getPath());
    }
    @Test
    void testPathbyID() throws IOException {
        URL url = new URL("http://localhost:10001/users");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());

        assertEquals("/users",url.getPath());
        assertEquals(null, bufferedReader.readLine());
        bufferedReader.close();
    }







/*
    @Test
    void testRequest() {
    }

    @Test
    void createUserTwo() {
    }

 */
}