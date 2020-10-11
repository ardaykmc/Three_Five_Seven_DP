package data.access;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import repository.IUser;
import repository.User;

public class FireBaseQueueCreator {
    private DatabaseReference databaseReference ;
    private String pathOfMap ;
    public FireBaseQueueCreator(String pathOfMap){
        this.pathOfMap = pathOfMap;
        this.databaseReference  = FirebaseDatabase.getInstance().getReference().child("maps").child(pathOfMap);
    }

    /**
     * This method add users to the queue that user selected from MapSelectionScreen.activity
     * @param user who registered the game
     */
    public void writeObject(IUser user)  {
        String key = user.getUserName();
        databaseReference.child(key).setValue(user);
    }

    /**
     * remove user from queue ( finding suitable game, internet connection problem , or stopping app)
     * @param user who registered the game
     */
    public void removeFromQueue(User user){
       databaseReference.child(user.getUserName()).removeValue();
    }
}
