package ws;

import javax.jws.WebService;

@WebService(targetNamespace = "http://certificatic.org/wsdl")
public interface HelloWs {
    public String sayHello(String name);
}