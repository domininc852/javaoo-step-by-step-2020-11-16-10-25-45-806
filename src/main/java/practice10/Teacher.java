package practice10;

import java.util.*;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observer {
    private List<Klass> classes = new LinkedList<Klass>();

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (Klass klass : classes) {
            klass.addObserver(this);
        }
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public List<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        if (classes.size() != 0)
            return super.introduce() + String.format(" I am a Teacher. I teach Class %s.", this.classes.stream().map(klass -> String.valueOf(klass.getNumber())).collect(Collectors.joining(", ")));
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public boolean isTeaching(Student student) {
        return classes.stream().filter(klass -> klass.isIn(student)).count() > 0;
    }


    public String introduceWith(Student student) {
        if (this.isTeaching(student)) {
            return super.introduce() + String.format(" I am a Teacher. I teach %s.", student.getName());
        }
        return super.introduce() + String.format(" I am a Teacher. I don't teach %s.", student.getName());
    }

    @Override
    public void update(Observable o, Object arg) {
        Student student = (Student) arg;
        Optional<Klass> filer_class = classes.stream().filter(klass -> klass.getLeader() == arg).findFirst();
        if (filer_class.isPresent()) {
            System.out.print(String.format("I am %s. I know %s become Leader of Class %d.\n", this.getName(), student.getName(), filer_class.get().getNumber()));
            return;
        }
        Klass filer_class2 = classes.stream().filter(klass -> klass.getMembers().get(klass.getMembers().size() - 1) == arg).findFirst().get();
        System.out.print(String.format("I am %s. I know %s has joined Class %d.\n", this.getName(), student.getName(), filer_class2.getNumber()));


    }
}
