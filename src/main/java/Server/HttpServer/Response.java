package Server.HttpServer;


public class Response {
    private int statusCode;
    private String statusMessage;
    private String contentType;
    private String content;

    private String title;

    public Response (HttpStatus httpStatus, ContentType contentType, String content, String title)
    {
        this.statusCode = httpStatus.statusCode;
        this.statusMessage = httpStatus.statusMessage;
        this.contentType = contentType.type;
        this.content = content;
        this.title = title;
    }

    public String get() {
        return "HTTP/1.1 " + this.statusCode + " " + this.statusMessage + "\r\n" +
                "Content-Type: " + this.contentType + "\r\n" +
                "Content-Length: " + (this.content != null ? this.content.length() : 0) + "\r\n" +
                "Connection: close\r\n" +
                "\r\n" +
                this.content + "Title: " + this.title;

    }
}