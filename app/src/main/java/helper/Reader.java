package helper;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {
    private BufferedReader bufferedReader;
    private int status;
    public Reader(String filePath, Context context) throws IOException {


        bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(filePath)));
        status = bufferedReader.read();
        checkInit();
    }

    private void checkInit() throws FileNotFoundException {
        if (this.status <= 0){
            throw new FileNotFoundException();
        }

    }
    public BufferedReader read(){
        return this.bufferedReader;
    }
}
