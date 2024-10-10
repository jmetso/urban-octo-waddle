package uow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping(value = "/send", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public void send(@RequestParam(value="message", defaultValue = "Hi!") String message) {
        LOGGER.info("Sending message: "+message);
        try {
            this.jmsTemplate.convertAndSend("test", message);
        } catch (org.springframework.jms.JmsException e) {
            LOGGER.error("Failed to send message.", e);
        }
    }

}
