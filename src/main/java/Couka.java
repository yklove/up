import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Couka {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Info(in.nextInt(), in.nextInt()));
        }
        list.sort((o1, o2) -> {
            int compare = Integer.compare(o2.b, o1.b);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(o2.a, o1.a);
            }
        });
        int count = 1;
        int ans = 0;
        int infoCount = 0;
        while (count != 0 && infoCount < list.size()) {
            count--;
            ans += list.get(infoCount).a;
            count += list.get(infoCount).b;
            infoCount++;
        }
        System.out.println(ans);
    }

    static class Info {
        int a;
        int b;

        public Info(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
