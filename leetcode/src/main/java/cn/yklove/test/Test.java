package cn.yklove.test;

/**
 * @author qinggeng
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Class classA = new Class();
        Student studentA = new Student(18, classA);

        // 直接赋值 引用相等
        Student studentC = studentA;
        System.out.println(studentC == studentA);

        // 浅克隆
        Student studentB = studentA.clone();
        // 两个引用不相等
        System.out.println(studentA == studentB);
        // 所在班级 相等
        System.out.println(studentA.getInTheClass() == studentB.getInTheClass());

        StudentDeep studentDeepA = new StudentDeep(18, classA);
        // 深克隆
        StudentDeep studentDeepB = studentDeepA.clone();
        // 两个引用不相等
        System.out.println(studentDeepA == studentDeepB);
        // 所在班级 不相等
        System.out.println(studentDeepA.getInTheClass() == studentDeepB.getInTheClass());
    }
}
