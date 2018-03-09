package ch.frostnova.example.eureka.application.client;

import ch.frostnova.example.eureka.application.api.model.Message;
import ch.frostnova.util.check.Check;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.net.URL;

/**
 * Hello REST client
 *
 * @author wap
 * @since 09.03.2018
 */
public class HelloClient implements AutoCloseable {

    private final URL baseURL;
    private final Client client;

    public HelloClient(URL baseURL) {
        this.baseURL = Check.required(baseURL, "baseURL");

        ClientBuilder clientBuilder = createClientBuilder();
        client = clientBuilder.build();
    }

    public final void close() {
        client.close();
    }

    private static ClientBuilder createClientBuilder() {

        return ClientBuilder.newBuilder()
                .property(ClientProperties.CONNECT_TIMEOUT, 500)
                .property(ClientProperties.READ_TIMEOUT, 5000)
                .property(LoggingFeature.LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
                .property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "WARNING");
    }

    public Message getHelloMessage() {

        return client.target(baseURL + "api/hello")
                .request()
                .get(Message.class);
    }

}