package webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductList {
    @XmlElement(name = "product")
    private List<Product> products = new ArrayList<>();

    public ProductList (){}

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
