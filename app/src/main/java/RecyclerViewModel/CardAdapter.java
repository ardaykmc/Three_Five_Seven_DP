package RecyclerViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.three_five_seven_dp.R;

import java.util.zip.Inflater;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {
    private String[] names;
    private int[] logos;
    private int[] logosSecond;
    private String[] namesSecond;
    private Context context;
    private LayoutInflater inflater;

    public CardAdapter(Context context, int[] logos, int[] logosSecond,String[] names,String[] namesSecond){
        this.context = context;
        this.logos = logos;
        this.logosSecond = logosSecond;
        this.names = names;
        this.namesSecond = namesSecond;
        inflater = LayoutInflater.from(this.context);
    }
    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = this.inflater.inflate(R.layout.specialcard,parent,false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        final String desc = names[position];
        int photo = logos[position];
        int photo2 = logosSecond[position];
        final String desc2 = namesSecond[position];
        holder.textView1.setText(desc);
        holder.imageView.setImageResource(photo);
        holder.imageView2.setImageResource(photo2);
        holder.textView2.setText(desc2);
    }

    @Override
    public int getItemCount() {
        return this.names.length;
    }

    public static class CardHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        ImageView imageView;
        ImageView imageView2;
        public CardHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.cardphoto);
            textView1 = (TextView) itemView.findViewById(R.id.textfirstopponent);
            imageView2 = (ImageView) itemView.findViewById(R.id.cardphoto2);
            textView2 = (TextView) itemView.findViewById(R.id.testSeconcdOpponent);
        }
    }
}
