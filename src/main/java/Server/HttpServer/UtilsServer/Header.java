package Server.HttpServer.UtilsServer;

import javafx.beans.binding.IntegerBinding;

import java.util.HashMap;
import java.util.Map;

public class Header {
    //Length of the content header
    public static final String LengthHeader = "Content-Lenght";
    //Seperator the value of the header name
    public static final String HeaderSeperator= ":";

    private Map<String, String> headers = new HashMap<>();


    public void inges(String HeaderLine)
    {
        final String[] split = HeaderLine.split(HeaderSeperator, 2);
        headers.put(split[0], split[1].trim());
    }
    public String getHeader(String headerName)
    {
        return headers.get(headerName);
    }

    public int getContentLength()
    {
        final String header = headers.get(LengthHeader);
        if(header == null)
        {
            return 0;
        }
        return Integer.parseInt(header);
    }
    public void Print()
    {
        System.out.println(headers);
    }
}
