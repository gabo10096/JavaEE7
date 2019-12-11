package jms;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("jms")
public class JMSSender {

    @EJB
    private JMSMessage jmsMessage;

    @Path("sender/{message}")
    @GET
    public String sendMessageJMS(
            @DefaultValue("Default message") @PathParam("message") String message){
        try {
            jmsMessage.sendMessage(message);
        }catch (JMSException e){
            System.out.println(e.getMessage());
        }
        return "message send";
    }

}
