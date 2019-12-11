package ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
@EJB(name = "CalculatorBean", beanInterface = CalculatorBean.class)
public class CalculatorBeanImpl implements CalculatorBean {
    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }
}
