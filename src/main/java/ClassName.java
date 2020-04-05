/**
 * @author qinggeng
 */
public class ClassName {

    private int b = 1;

    public ClassName() {
        System.out.println("sssssssssssss");
    }

    public ClassName(String a) {
        this();
        System.out.println(a);
        System.out.println(this.b);
    }

    public static void main(String[] args) {
        new ClassName("asdf");
    }

}
