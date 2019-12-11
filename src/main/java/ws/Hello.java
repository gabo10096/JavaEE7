package ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(portName = "HelloPort",
            serviceName = "HelloWebServico",
            targetNamespace = "http://certificatic.org/wsdl",
            endpointInterface = "ws.HelloWs")
public class Hello implements HelloWs {

    @Override
    public String sayHello(String name) {
        return "Hello " + name ;
    }
}
