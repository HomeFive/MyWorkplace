package lesson0831.Day1608;

public class Student {
    private String name;
    private Double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Student() {}

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }
}
