package cn.yklove;

/**
 * @author qinggeng
 */
public class Test2 {

    public int test(){
        int value = 0;
        try {
            return ++value;
        }finally {
            return value;
        }
    }
}
