import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qinggeng
 */
public class Test {

    public static void main(String[] args) throws IOException {
        System.out.println("xxxxx");
        Scanner in = new Scanner(new File("/Users/qinggeng/Library/Containers/com.tencent.xinWeChat/Data/Library/Application Support/com.tencent.xinWeChat/2.0b4.0.9/644ad9b44b3ad760a963ddf7db19c58b/Message/MessageTemp/aafdd8c6a085db2e4d34095209316235/File/高德拥堵数据.dat"));
        File file = new File("out.json");
        FileWriter fileWriter = new FileWriter(file);
        List<String> list = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] split = line.split("\\|");
            String x = "{\"lon\":" + split[10] + ",\"lat\":" + split[11] + "}";
            list.add(x);
            if(list.size() > 1000){
                break;
            }
        }
        String join = String.join(",", list);
        fileWriter.write("[" + join + "]");
        fileWriter.flush();
        fileWriter.close();
    }

}
