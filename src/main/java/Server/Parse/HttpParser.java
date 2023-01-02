package Server.Parse;


import Server.HttpServer.RequestBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class HttpParser {

    public RequestBuilder parseHttpRequest(InputStream inputStream)
    {
        //Ist eine bruecken zwischen inputstream, byte to decodes it to specific charackterset
        InputStreamReader reader = new InputStreamReader(inputStream , StandardCharsets.US_ASCII);
        RequestBuilder httpRequest = new RequestBuilder();
        parseRequestLine(reader,httpRequest);
        parseHeaders(reader,httpRequest);
        parseBody(reader,httpRequest);
        return httpRequest;

    }

    private void parseRequestLine(InputStreamReader reader, RequestBuilder httpRequest) {

    }

    private void parseHeaders(InputStreamReader reader, RequestBuilder httpRequest) {
    }

    private void parseBody(InputStreamReader reader, RequestBuilder httpRequest) {

    }
}
