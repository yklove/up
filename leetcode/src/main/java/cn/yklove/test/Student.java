package cn.yklove.test;

/**
 * 学生
 */
public class Student implements Cloneable{

    /**
     * 年龄
     */
    private int age;

    /**
     * 所在班级
     */
    private Class inTheClass;

    public Student(int age, Class inTheClass) {
        this.age = age;
        this.inTheClass = inTheClass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Class getInTheClass() {
        return inTheClass;
    }

    public void setInTheClass(Class inTheClass) {
        this.inTheClass = inTheClass;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
