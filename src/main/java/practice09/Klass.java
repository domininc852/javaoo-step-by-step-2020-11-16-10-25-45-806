package practice09;


import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> members=new ArrayList<Student>();

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
        if(!members.contains(leader)){
            System.out.print("It is not one of us.\n");
        }
        else {
            this.leader = leader;
        }
    }

    public Student getLeader() {
        return this.leader;
    }

    public void appendMember(Student student) {
        this.members.add(student);
    }
}
