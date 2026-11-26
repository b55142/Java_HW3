// 依 Chapter3.pdf P40 重寫：StringBuffer 串接字串。
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Sample3_20 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("請輸入字串：");
        String str1 = br.readLine();
        System.out.println("請輸入要新增的字串：");
        String str2 = br.readLine();
        StringBuffer sb = new StringBuffer(str1);
        sb.append(str2);
        System.out.println("在「" + str1 + "」後新增「" + str2 + "」的話，就會變成「" + sb + "」。");
    }
}
