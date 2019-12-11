package ejb;

import javax.ejb.Local;

@Local
public interface CalculatorBean {
    int add(int a, int b);
    int subtract(int a, int b);
}
