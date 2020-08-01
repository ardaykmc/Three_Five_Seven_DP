package data.access;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.example.three_five_seven_dp.MainActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalFileWriter {
    private Context context;
    private String filePath;


    public InternalFileWriter(Context context, String fileName) {
        this.context = context;
        this.filePath = fileName;
        File file = new File(context.getFilesDir(),fileName);
    }
    public void writeToFile(String message){

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(filePath,Context.MODE_PRIVATE);
            fileOutputStream.write(message.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}