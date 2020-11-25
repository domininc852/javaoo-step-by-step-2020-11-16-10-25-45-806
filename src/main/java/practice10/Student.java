package practice10;



public class Student extends Person {
    private Klass klass;
    public Student(int id,String name, int age, Klass klass) {
        super(id,name,age);
        this.klass=klass;
    }

    public Klass getKlass() {
        return klass;
    }
    @Override
    public String introduce() {
        if(this.klass.getLeader()==this){
            return super.introduce()+String.format(" I am a Student. I am Leader of Class %d.",this.klass.getNumber());
        }
        return super.introduce()+String.format(" I am a Student. I am at Class %d.",this.klass.getNumber());
    }

    @Override
    public boolean equals(Object obj) {
        return this==obj;
    }
}
