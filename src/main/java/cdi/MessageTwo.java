package cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@SecondMessage
public class MessageTwo implements Message {

    public MessageTwo (){

    }

    @Override
    public String get() {
        return "Message from cdi.MessageTwo";
    }
}
