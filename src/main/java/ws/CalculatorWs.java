package ws;

import javax.jws.WebService;

@WebService(targetNamespace = "http://certificatic.org/wsdl")
public interface CalculatorWs {
    int sum(int add1, int add2);
    int multiply(int mul1, int mul2);
}
