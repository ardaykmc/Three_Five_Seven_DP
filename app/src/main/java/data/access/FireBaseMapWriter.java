package data.access;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import repository.IUser;

public class FireBaseMapWriter {

    private DatabaseReference databaseReference ;
    private String path = "maps" ;
    public FireBaseMapWriter(){
        this.databaseReference  = FirebaseDatabase.getInstance().getReference().child(path);
    }
    public void writeObject(String nameOfMap)  {

        databaseReference.setValue(nameOfMap);
    }
}
