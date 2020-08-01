package data.access;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;

import com.example.three_five_seven_dp.MainActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

import repository.Gold;
import repository.GoldPackage;
import repository.IUser;
import repository.User;
public class FireBaseUserWriter extends FireBaseWriter<IUser> {
    private DatabaseReference databaseReference ;
    private String path = "users" ;
    private Context context ;
    public FireBaseUserWriter(Context context){
        this.databaseReference  = FirebaseDatabase.getInstance().getReference().child(path);
        this.context = context;
    }


    /**
     * We store our users on firebase as json
     * Also that method can be used for update
     * @param object the object that will be stored
     */
    @Override
    public void writeObject(IUser object)  {
        User usrReal = (User) object ; // this userReal's reference same with parameter
        User usrCopy = new User(usrReal); // copy of it
        String key = databaseReference.push().getKey();

        InternalFileWriter internalFileWriter  = new InternalFileWriter(context,"userSave.txt");
        internalFileWriter.writeToFile(key);
        databaseReference.child(key).setValue(usrCopy);
    }

    /**
     *
     * @param user it will be declared and passing to method as a parameter
     */
    @Override
    public void removeObject(IUser user) {
        String tmp = user.getUSER_ID();
        databaseReference.child("users").child(tmp).removeValue();
    }
    public void writeUpdateGolden(IUser user,Double newValue){
        Double amountOfGold = user.getGoldPackage().getGold().getNumberOfGold();
        Double updatedGold = amountOfGold + newValue ;
        Gold golden = new Gold();
        golden.setNumberOfGold(updatedGold);
        user.getGoldPackage().setGold(golden);
        writeObject(user);
    }


}
