package ch.frostnova.example.eureka.application.server.ws;

import ch.frostnova.example.eureka.application.api.model.Message;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Hello web service endpoint
 */
@Component
@Path("hello")
public class HelloEndpoint {

    /**
     * List notes
     *
     * @return list of notes (never null)
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message welcome() {
        return new Message("Aloha");
    }
}
