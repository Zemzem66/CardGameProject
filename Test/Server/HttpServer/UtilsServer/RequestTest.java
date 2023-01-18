package Server.HttpServer.UtilsServer;

import Server.HttpServer.Http.Method;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {
    @Test
    void getPathname() {
    }

    @Test
    void testGetParamsWithId() {
        Request request = new Request();
        request.setPathname("/echo/1");
        request.setParams("id=99");
        assertEquals("/echo/1",request.getPathname());
        assertEquals("id=99", request.getParams());
    }

    @Test
    void testGetServiceRouteWithSlash() {
        Request request = new Request();
        request.setPathname("/");
        assertNull(request.getServiceRoute());
    }

    @Test
    void testBasicRoute() {
        Request request = new Request();
        request.setPathname("/echo");
        assertEquals("/echo", request.getServiceRoute());
    }

    @Test
    void testAdvancedRoute() {
        Request request = new Request();
        request.setPathname("/echo/1/cards");

        assertEquals("/echo", request.getServiceRoute());
        assertEquals("1", request.getPathParts().get(1));
        assertEquals("cards", request.getPathParts().get(2));
    }

    @Test
    void testGetServicePackages()
    {
        Request request = new Request();
        request.setPathname("/test134/2/packages");
        assertEquals("/test134", request.getServiceRoute());
        assertEquals("2", request.getPathParts().get(1));
        assertEquals("packages", request.getPathParts().get(2));
    }
    @Test
    void testMethodPut()
    {
        Request request = new Request();
        request.setMethod(Method.PUT);
        assertEquals(Method.PUT,request.getMethod());
    }
    @Test
    void testMethodDelete()
    {
        Request request = new Request();
        request.setMethod(Method.DELETE);
        assertEquals(Method.DELETE,request.getMethod());
    }
    @Test
    void testMethodPOST()
    {
        Request request = new Request();
        request.setMethod(Method.POST);
        assertEquals(Method.POST,request.getMethod());
    }
    @Test
    void testMethodGet()
    {
        Request request = new Request();
        request.setMethod(Method.GET);
        assertEquals(Method.GET,request.getMethod());
    }

    @Test
    void testBodyParts()
    {
        Request request = new Request();
        request.setBody("Name: WaterGoblin");
        assertEquals("Name: WaterGoblin", request.getBody());
    }
    @Test
    void testBodyEntire()
    {
        Request request = new Request();
        request.setBody("\\\"Id\\\":\\\"2272ba48-6662-404d-a9a1-41a9bed316d9\\\", \\\"Name\\\":\\\"WaterGoblin\\\", \\\"Damage\\\": 11.0");
        assertEquals("\\\"Id\\\":\\\"2272ba48-6662-404d-a9a1-41a9bed316d9\\\", \\\"Name\\\":\\\"WaterGoblin\\\", \\\"Damage\\\": 11.0",request.getBody());
    }
}