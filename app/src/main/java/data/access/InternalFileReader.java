package data.access;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InternalFileReader {
    private Context context;
    private String filePath;

    public InternalFileReader(Context context, String filePath) {
        this.context = context;
        this.filePath = filePath;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String readFromInternalFile() throws IOException {
        FileInputStream fis = context.openFileInput(filePath);
        InputStreamReader inputStreamReader =
                new InputStreamReader(fis, StandardCharsets.UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                stringBuilder.append(line).append('\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            // Error occurred when opening raw file for reading.
        } finally {
            String contents = stringBuilder.toString();
            return contents;
        }
    }
}
