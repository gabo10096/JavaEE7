package jms;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("jms")
public class JMSConsumer {

    @EJB
    private JMSMessage jmsMessage;

    @Path("consumer")
    @GET
    public String receivedMessageJMS(){
        String msg = null;
        try {
            msg = jmsMessage.receivedMessage();
        }catch (JMSException e){
            System.out.println(e.getMessage());
        }
        return msg != null ? msg: "no new message";
    }

}
