package ch.frostnova.example.eureka.application.server.ws;

import ch.frostnova.example.eureka.application.server.api.model.Message;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Notes web service endpoint <p>
 * Full local path: <a href="https://localhost/api/notes">https://localhost/api/notes</a>
 */
@Component
@Path("hello")
public class NotesEndpoint {

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
