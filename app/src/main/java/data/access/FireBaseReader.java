package data.access;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBaseReader {

 public DatabaseReference readFileFromFireBase(String filePath){
   DatabaseReference mDatabase  = FirebaseDatabase.getInstance().getReference(filePath);
   return mDatabase;
 }
 public DatabaseReference readSpecificValue(String fileName){
     DatabaseReference mDatabase = this.readFileFromFireBase(fileName);
     return mDatabase;
 }

}
