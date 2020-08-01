package data.access;

import android.content.Context;

import com.google.firebase.database.DatabaseReference;

public abstract class FireBaseWriter<T> {
    /**
     * @param object   the object that will be stored
     */
    public abstract void writeObject(T object);


    public abstract void removeObject(T obj);
}
