package modena.infra.response;

import java.util.ArrayList;

public class Response {
    public int status;
    public ArrayList<String> message;

    public Response() {
        message = new ArrayList<String>();
        status = 200;
    }

    public void AddMessage(String message) {
        status = 400;
        this.message.add(message);
    }

    public boolean hasErrors() {
        return !message.isEmpty();
    }

}
