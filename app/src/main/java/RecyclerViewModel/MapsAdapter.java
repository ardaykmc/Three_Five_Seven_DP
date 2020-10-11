package RecyclerViewModel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.three_five_seven_dp.GameBoard;
import com.example.three_five_seven_dp.R;

import java.util.zip.Inflater;

import data.access.FireBaseMapWriter;
import data.access.FireBaseQueueCreator;
import data.access.FireBaseWriter;
import game.Player;
import repository.User;

public class MapsAdapter extends RecyclerView.Adapter<MapsAdapter.MapsHolder> {
    private String[] names;
    private int[] logos;
    private Context context;
    private LayoutInflater inflater;

    public MapsAdapter(Context context, String[] names, int[] logos){
        this.context = context;
        this.logos = logos;
        this.names = names;
        inflater = LayoutInflater.from(this.context);
    }
    @NonNull
    @Override
    public MapsAdapter.MapsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = this.inflater.inflate(R.layout.map_card,parent,false);
        return new MapsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MapsAdapter.MapsHolder holder, int position) {
        final String desc = names[position];
        int photo = logos[position];
        holder.imageView.setImageResource(photo);
        holder.textView.setText(desc);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectGameType();
                Intent intent = new Intent(context, GameBoard.class);

                FireBaseQueueCreator fireBaseQueueCreator = new FireBaseQueueCreator("3game");
                User user = new User("ert",false);
                fireBaseQueueCreator.removeFromQueue(user);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
    public static class MapsHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public MapsHolder(@NonNull View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.map_card_text_view);
            imageView = (ImageView) itemView.findViewById(R.id.map_cad_image);
        }
    }
    private void selectGameType(){

    }
}
