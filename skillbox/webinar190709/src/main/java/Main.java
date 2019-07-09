import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;

public class Main {
    private static final String ACCESS_TOKEN =
        "_uAHwPs06v8AAAAAAABJrLKBpFQwNJgNbYQVdcHDDHKfMgH5KD7o4rnHRx_f_4IE";

    public static void main(String args[]) throws DbxException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder(
                "dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    }
}