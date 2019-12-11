package ws;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(portName = "CalculatorPort",
        serviceName = "CalculatorWebServico",
        targetNamespace = "http://certificatic.org/wsdl",
        endpointInterface = "ws.CalculatorWs")
public class Calculator implements CalculatorWs {
    @Override
    public int sum(int add1, int add2) {
        return add1+add2;
    }

    @Override
    public int multiply(int mul1, int mul2) {
        return mul1*mul2;
    }
}
