// 依 Chapter3.pdf P43 重寫：Math.max 比較整數。
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Sample3_21 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("請輸入兩個整數");
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int ans = Math.max(num1, num2);
        System.out.println(num1 + "與" + num2 + "中較大的是" + ans);
    }
}
