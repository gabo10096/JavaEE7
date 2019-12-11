package webservices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WriteProductListXML {
    public static void writeXML(){
        List<Product> products = new ArrayList<>();

        products.add(new Product("Widget", 25.00, "el basico"));
        products.add(new Product("Widget Pro", 35.00, "el basico perron"));
        products.add(new Product("Widget Pro XL", 45.00, "el peroon"));

        ProductList productList = new ProductList(products);

        try {
            JAXBContext jc = JAXBContext.newInstance(ProductList.class);
            Marshaller m = jc.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Marshall output
            m.marshal(productList, new File("products.xml"));
            m.marshal(productList, System.out);
        } catch (JAXBException e) {
            System.out.println("JAXB Exception: " + e.getMessage());
        }
    }
}
