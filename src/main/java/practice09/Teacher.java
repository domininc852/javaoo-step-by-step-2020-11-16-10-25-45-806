package practice09;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> classes=new LinkedList<Klass>();
    public Teacher(int id,String name, int age, List<Klass> classes) {
        super(id,name, age);
        this.classes=classes;
    }

    public Teacher(int id,String name, int age) {
        super(id,name,age);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        if(classes.size()!=0)
            return super.introduce()+String.format(" I am a Teacher. I teach Class %s.",this.classes.stream().map(klass->String.valueOf(klass.getNumber())).collect(Collectors.joining(", ")));
        return super.introduce()+" I am a Teacher. I teach No Class.";
    }

    public boolean isTeaching(Student student) {
        return classes.stream().filter(klass -> klass.isIn(student)).count() > 0;
    }


    public String introduceWith(Student student) {
        if (this.isTeaching(student)){
            return super.introduce()+String.format(" I am a Teacher. I teach %s.",student.getName());
        }
        return super.introduce()+String.format(" I am a Teacher. I don't teach %s.",student.getName());
    }

}
