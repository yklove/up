package cn.yklove;

/**
 * @author qinggeng
 */
public class Child extends Dad {

    public Child() {

    }

    public static void main(String[] args) {
        Dad dad = new Dad();
        Child child = new Child();
        System.out.println(dad.getValue() + "," + child.getValue());
    }
}
