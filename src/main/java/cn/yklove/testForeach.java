package cn.yklove;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testForeach {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");

//        for(String item:list){
//            if("1".equals(item)){
//                list.remove(item);
//            }
//            System.out.println(list.size());
//        }

        for(Iterator var2 = list.iterator(); var2.hasNext(); System.out.println(list.size())) {
            String item = (String)var2.next();
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

    }
    /**
     * 反编译之后的源码
     * for(Iterator var2 = list.iterator(); var2.hasNext(); System.out.println(list.size())) {
     *     String item = (String)var2.next();
     *     if ("1".equals(item)) {
     *         list.remove(item);
     *     }
     * }
     * list中原先是1,2
     * 第一次循环前检查var2.hasNext(),cursor = 0,size=2，可以进入循环，此时发现item==1，于是删除1，打印list大小
     * 第二次进入循环前检查，var2.hasNext(),cursor = 1,size=1，退出循环
     *
     * list中原先是1，2
     * 第一次循环前检查var2.hasNext(),cursor = 0,size=2，可以进入循环，此时发现item!=2，打印list大小
     * 第二次循环前检查var2.hasNext()，cursor = 1,size=2,可以进入循环，此时item==2，打印list大小
     * 第三次循环前检查var2.hasNext()，cursor = 2,size=1,此时依旧是true，调用var2.next()抛出异常
     *
     * public boolean hasNext() {
     *     return cursor != size;
     * }
     */




}