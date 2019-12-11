package ws;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Calc {

    @WebMethod
    public String squared(@WebParam(name = "number") String number){
        int n = Integer.valueOf(number);
        return String.valueOf(n*n);
    }
}
