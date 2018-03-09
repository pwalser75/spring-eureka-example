package ch.frostnova.example.eureka.application.client;

import ch.frostnova.example.eureka.application.api.model.Message;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.net.URL;
import java.util.List;

/**
 * Application client
 *
 * @author wap
 * @since 09.03.2018
 */
@SpringBootApplication
public class ApplicationClient implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EurekaClient eurekaClient;


    public static void main(String[] args) {

        new SpringApplicationBuilder(ApplicationClient.class)
                .web(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        final String appId = "application-server";

        logger.info("Looking up application over Eureka");
        Application application = eurekaClient.getApplication(appId);
        List<InstanceInfo> instances = application.getInstances();
        logger.info("Found application: " + application.getName() + " with " + instances.size() + " instance(s)");
        instances.forEach(i ->
                logger.info(String.format("- %s:%d -> %s, name: %s", i.getHostName(), i.getPort(), i.getHomePageUrl(), i.getAppName()))
        );

        if (instances.isEmpty()) {
            logger.error("Service unavailable.");
            System.exit(1);
        }
        InstanceInfo instance = eurekaClient.getNextServerFromEureka(appId, false);


        URL url = new URL(instance.getHomePageUrl());
        logger.info("Using " + url);
        try (HelloClient helloClient = new HelloClient(url)) {

            Message message = helloClient.getHelloMessage();
            System.out.println("Got message:");
            System.out.println("- timestamp: " + message.getTimestamp());
            System.out.println("- message: " + message.getMessage());
        }
    }
}