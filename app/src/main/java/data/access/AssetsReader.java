package data.access;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.logging.FileHandler;

public class AssetsReader {
    private String path;
    private Context context;
    public AssetsReader(String path, Context context){
        this.path = path ;
        this.context = context ;
    }

    /**
     *
     * @return String that stored in file
     */
    public String readFile(){
        String text = null;
        try {
            InputStream inputStream = context.getAssets().open(this.path);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
    public String writeFile(String text,String Path) throws IOException {
        File file = new File(path);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(text.getBytes());
        outputStream.flush();
        outputStream.close();
        return "asd";

    }
}
