package lesson0906.Day2101;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Calculator {
    Calculator c;
    public Calculator(){
    }
    @Before
    public void newCal(){
        c = new Calculator();
        System.out.println("build Calculator");
    }
    @After
    public void delCal(){
        c = null;
        System.out.println("destroy Calculator");
    }
    @Test
    public void plus(){
        System.out.println("plus method");
    }
    @Test
    public void minus(){
        System.out.println("minus method");
    }
    @Test
    public void multi(){
        System.out.println("multi method");
    }
    @Test
    public void divide(){
        System.out.println("divide method");
    }
}
