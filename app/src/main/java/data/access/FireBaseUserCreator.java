package data.access;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.wifi.hotspot2.omadm.PpsMoParser;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.three_five_seven_dp.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.DoubleToIntFunction;

import repository.Gold;
import repository.IUser;
import repository.User;

import static android.content.ContentValues.TAG;

/**
 * This class responsible for fetching user's attributes from fireBase
 */
public class FireBaseUserCreator {
    private FireBaseReader fireBaseReader;
    private InternalFileReader internalFileReader;
    private String pushKey;
    private String filePath = "users";
    private Context context;
    private User user = null;
    private DatabaseReference databaseReference ;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public FireBaseUserCreator(Context context){
        this.context = context;
        internalFileReader = new InternalFileReader(context,"userSave.txt");
        fireBaseReader = new FireBaseReader();

        databaseReference = fireBaseReader.readSpecificValue(filePath);
        try {
            pushKey = internalFileReader.readFromInternalFile();

        } catch (IOException e) {
            Toast.makeText(context,"Welcome to our game .. You look new here",Toast.LENGTH_LONG).show();
        }
    }
    public String getValidPushKey(){
        pushKey = pushKey.replace("\n","");
        final String val = pushKey ;
        return val;
    }
    public DatabaseReference getUsersReference(){
        return this.databaseReference;
    }

}
