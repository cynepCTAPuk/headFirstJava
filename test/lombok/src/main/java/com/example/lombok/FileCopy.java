package com.example.lombok;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            @Cleanup InputStream in = new FileInputStream(args[0]);
            @Cleanup OutputStream out = new FileOutputStream(args[1]);
            byte[] b = new byte[65_536];
            while (true) {
                int r = in.read(b);
                if (r == -1) break;
                out.write(b, 0, r);
            }
            in.close();
            out.close();
        } else {
            System.out.println("FileCopy SourceFile DestinationFile");
        }
    }
}
