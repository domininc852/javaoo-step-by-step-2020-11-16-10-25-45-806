package practice10;



import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Klass extends Observable {
    private int number;
    private Student leader;
    private List<Student> members=new ArrayList<Student>();

    public Klass(int number) {
        this.number = number;
    }

    public List<Student> getMembers() {
        return members;
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
            setChanged();
            notifyObservers(leader);
        }
    }

    public Student getLeader() {
        return this.leader;
    }

    public void appendMember(Student student) {
        this.members.add(student);
        setChanged();
        notifyObservers(student);

    }
    public boolean isIn(Student student){
        return student.getKlass()==this;
    }
}
