package org.certificatic.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(HelloBean.class)
public class HelloBeanImpl {
    public String getMessageFor (String caller){
        return "hello to you, " + caller + "!";
    }
}
