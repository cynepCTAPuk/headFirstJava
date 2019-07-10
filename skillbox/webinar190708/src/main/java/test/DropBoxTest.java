package test;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DropBoxTest {
    private static final String ACCESS_TOKEN =
            "_uAHwPs06v8AAAAAAABJr6SRc4XzHAG6ufeTVjUaLNwJ5yJa3Sq9VZc8cYL8a76n";

    public static void main(String args[]) throws DbxException, IOException {
        DbxRequestConfig config = new DbxRequestConfig(
                "screen_shot", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) System.out.println(metadata.getPathLower());
            if (!result.getHasMore()) break;
            result = client.files().listFolderContinue(result.getCursor());
        }

        // Upload "test.txt" to Dropbox
        try (InputStream in = new FileInputStream("test.txt")) {
            FileMetadata metadata = client.files().uploadBuilder("/test.txt")
                    .uploadAndFinish(in);
        }
    }
}