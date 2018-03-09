package ch.frostnova.example.eureka.application.api.model;

import ch.frostnova.example.eureka.application.api.converter.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

/**
 * Message DTO
 *
 * @author wap
 * @since 09.03.2018
 */
@XmlRootElement
public class Message {

    private LocalDateTime timestamp;

    private String message;

    public Message() {

    }

    public Message(String message) {
        this.message = message;
        timestamp = LocalDateTime.now();
    }

    @XmlElement(name = "timestamp")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
