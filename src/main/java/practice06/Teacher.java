package practice06;

import practice05.Person;

public class Teacher extends Person {
    private Klass klass;
    public Teacher(String name, int age,Klass klass) {
        super(name, age);
        this.klass=klass;
    }

    public Teacher(String name, int age) {
        super(name,age);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        if(klass!=null)
            return super.introduce()+String.format(" I am a Teacher. I teach Class %d.",this.klass.getNumber());
        return super.introduce()+" I am a Teacher. I teach No Class.";
    }


    public String introduceWith(Student student) {
        if (this.klass.getNumber()==student.getKlass().getNumber()){
            return super.introduce()+String.format(" I am a Teacher. I teach %s.",student.getName());
        }
        return super.introduce()+String.format(" I am a Teacher. I don't teach %s.",student.getName());
    }
}
