package webservices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class WriteProductXML {
    public static void writeXML(){

        Product p = new Product("Widget", 25.00, "Alto");
        System.out.println(p);
        try {
            JAXBContext jc = JAXBContext.newInstance(Product.class);
            Marshaller m = jc.createMarshaller();
            // Marshall output
            m.marshal(p, new File("product.xml"));
            m.marshal(p, System.out);
        } catch (JAXBException e) {
            System.out.println("JAXB Exception: " + e.getMessage());
        }
    }
}
