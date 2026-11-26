import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

/** 範例三：java.net.URI 類別，離線解析 HTTP/HTTPS 網址。 */
public class UrlInspector {
    public static void main(String[] args) {
        String[] inputs = args.length == 0
            ? new String[]{"https://example.com:8443/course/./java?chapter=5#demo"} : args;
        boolean invalid = false;
        for (String input : inputs) {
            try {
                URI uri = new URI(input).parseServerAuthority();
                String scheme = uri.getScheme();
                if (scheme == null || !(scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https"))
                        || uri.getHost() == null || uri.getRawUserInfo() != null) {
                    throw new IllegalArgumentException("請使用含主機名稱、未夾帶帳密的 HTTP/HTTPS 網址。");
                }
                int port = uri.getPort();
                if (port == -1) port = scheme.equalsIgnoreCase("https") ? 443 : 80;
                if (port < 1 || port > 65535) throw new IllegalArgumentException("連接埠必須介於 1 到 65535。");
                String path = uri.getPath();
                System.out.println("協定：" + scheme.toLowerCase(Locale.ROOT));
                System.out.println("主機：" + uri.getHost());
                System.out.println("連接埠：" + port);
                System.out.println("路徑：" + (path == null || path.isEmpty() ? "/" : path));
                // 保留原始 query，避免把編碼後的分隔字元誤當成網址結構。
                System.out.println("查詢字串：" + orNone(uri.getRawQuery()));
                System.out.println("片段：" + orNone(uri.getRawFragment()));
                System.out.println("正規化結果：" + uri.normalize().toASCIIString());
            } catch (URISyntaxException | IllegalArgumentException error) {
                // 不回印整個輸入，避免意外顯示使用者放入網址的帳密。
                System.err.println("網址格式錯誤：" + error.getClass().getSimpleName());
                invalid = true;
            }
        }
        if (invalid) System.exit(2);
    }

    private static String orNone(String value) {
        return value == null || value.isEmpty() ? "（無）" : value;
    }
}
