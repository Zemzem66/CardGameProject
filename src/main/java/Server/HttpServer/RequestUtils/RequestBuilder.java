package Server.HttpServer.RequestUtils;

import Server.HttpServer.Http.Method;
import Server.HttpServer.UtilsServer.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Locale;

public class RequestBuilder {
    public Request buildRequest(BufferedReader bufferedReader) throws IOException
    {
        Request request = new Request();
        String firstline = bufferedReader.readLine();

        if (firstline != null) {
            String[] splitFirstline = firstline.split(" ");

            request.setMethod(getMethod(splitFirstline[0]));
            setPathname(request, splitFirstline[1]);

            String line = bufferedReader.readLine();
            while (!line.isEmpty()) {
                String[] headerRow = line.split(":", 2);
                request.addHeader(headerRow[0], headerRow[1].trim());
                line = bufferedReader.readLine();
            }

            if (request.getContentLength() > 0 ) {
                char[] charBuffer = new char[request.getContentLength()];
                bufferedReader.read(charBuffer, 0, request.getContentLength());
                request.setBody(new String(charBuffer));
            }
        }
        return request;
    }

    private Method getMethod(String methodString)
    {
        return Method.valueOf(methodString.toUpperCase());
    }

    private void setPathname(Request request, String path){
        boolean hasParams = path.indexOf("?") != -1;
        if(hasParams)
        {
            String[] pathParts = path.split("\\?");
            request.setPathname(pathParts[0]);
            request.setParams(pathParts[1]);
        }
        else {
            request.setPathname(path);
            request.setParams(null);
        }
    }
}