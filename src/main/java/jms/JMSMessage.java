package jms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

@Stateless
public class JMSMessage {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource
    private Queue queue;

    public void sendMessage(String text) throws JMSException{
        Connection connection = null;
        Session session = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message = session.createTextMessage(text);
            producer.send(message);
        }finally {
            if (session != null) session.close();
            if (connection != null) connection.close();
        }
    }

    public String receivedMessage() throws  JMSException{
        Connection connection = null;
        Session session = null;
        MessageConsumer consumer = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(queue);
            TextMessage message = (TextMessage) consumer.receive(1000);
            return message != null ? message.getText() : null;
        }finally {
            if (consumer != null) consumer.close();
            if (session != null) session.close();
            if (connection != null) connection.close();
        }

    }
}
