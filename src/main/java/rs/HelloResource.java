package rs;

import ejb.CalculatorBean;

import javax.faces.bean.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("rs")
public class HelloResource {

    @Path("sayHello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject sayHello(){
        return Json.createObjectBuilder()
                .add("message", "Hi there!")
                .build();
    }

    @Path("ejb")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject ejbClient() throws NamingException {
        Context ctx = new InitialContext();
        CalculatorBean calculatorBean = (CalculatorBean) ctx.lookup("java:comp/env/CalculatorBean");
        return Json.createObjectBuilder()
                .add("result",calculatorBean.subtract(1,1))
                .build();
    }

}
