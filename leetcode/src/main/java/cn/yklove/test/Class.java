package cn.yklove.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 班级
 */
public class Class implements Cloneable {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        long startTime = System.currentTimeMillis();
        list = list.parallelStream().filter(tmp -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tmp == 2) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime));
        System.out.println(list);
    }

    @Override
    public Class clone() throws CloneNotSupportedException {
        return (Class) super.clone();
    }
}
