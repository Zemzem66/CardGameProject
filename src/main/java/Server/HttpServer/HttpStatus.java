package Server.HttpServer;

public enum HttpStatus {
    OK(200, "OK"),
    FORBIDDEN(403, "Forbidden");
/*
    String meinTitle() {
        return "CardGame";
    }
 */

    public final int statusCode;
    public final String statusMessage;

    HttpStatus(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}