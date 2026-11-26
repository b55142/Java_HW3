import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/** 範例二：java.io 類別，逐行讀取 UTF-8 檔案並統計內容。 */
public class TextFileStats {
    public static void main(String[] args) {
        if (args.length > 1) {
            System.err.println("用法：java TextFileStats [UTF-8文字檔路徑]");
            System.exit(2);
        }
        File file = new File(args.length == 0 ? "data/sample.txt" : args[0]);
        if (!file.isFile()) {
            System.err.println("找不到可讀取的檔案：" + file.getPath());
            System.exit(2);
            return;
        }
        long lines = 0;
        long blankLines = 0;
        long codePoints = 0;
        // try-with-resources 會在成功或失敗時，都關閉整條輸入串流。
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8.newDecoder()
                    .onMalformedInput(CodingErrorAction.REPORT)
                    .onUnmappableCharacter(CodingErrorAction.REPORT)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 允許部分 Windows 編輯器產生的 UTF-8 BOM，且不把它算入文字。
                if (lines == 0 && line.startsWith("\uFEFF")) line = line.substring(1);
                lines++;
                if (line.trim().isEmpty()) blankLines++;
                // codePointCount 可正確把常見的單一 emoji 算為一個 Unicode 碼點。
                codePoints += line.codePointCount(0, line.length());
            }
            System.out.println("檔案：" + file.getPath());
            System.out.println("行數：" + lines);
            System.out.println("空白行數：" + blankLines);
            System.out.println("Unicode 碼點數（不含換行）：" + codePoints);
            System.out.println("檔案位元組數：" + file.length());
        } catch (IOException error) {
            System.err.println("讀取失敗，請確認檔案權限與 UTF-8 編碼：" + error.getMessage());
            System.exit(2);
        }
    }
}
