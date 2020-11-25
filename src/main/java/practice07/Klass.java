package practice07;

public class Klass {
    private int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return String.format("Class %d",this.number);
    }

    public void assignLeader(Student leader) {
        this.leader=leader;
    }

    public Student getLeader() {
        return this.leader;
    }
}
