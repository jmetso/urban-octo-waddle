package uow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsConsumer.class);

    @JmsListener(destination = "test", containerFactory = "myFactory")
    public void receiveMessage(String message) {
        LOGGER.info("Received message: "+message);
    }

}
