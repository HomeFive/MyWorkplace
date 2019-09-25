package lesson0906.Day2112;

public class TestAnno2 {
    @Book(value="Java",price=101,authors = {"JK","ed"})
    public void showBook(){
        System.out.println("show book");
    }
}
