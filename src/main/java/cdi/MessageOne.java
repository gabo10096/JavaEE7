package cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MessageOne implements Message {

    public MessageOne(){

    }

    @Override
    public String get() {
        return "Message from cdi.MessageOne";
    }
}
