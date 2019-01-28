package com.example.becia.beatapiotrowska;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.animation.Positioning;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mTitles = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> titles, ArrayList<String> images, Context context) {
        this.mTitles = titles;
        this.mImages = images;
        this.mContext = context;

        /*for (int i = 0; i < 10; i++)
        {
            this.mTitles.add("Title");
            this.mImages.add();
        }*/

    }

//    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_elements, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d("RecView", "onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.title.setText(mTitles.get(position));

        /*holder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d("RecView", "onClick: " + mTitles.get(position));

                Toast.makeText(mContext, mTitles.get(position), Toast.LENGTH_SHORT).show(); //chyba wyswietlanie dymkow po kliknięciu
            }
        });*/

    }


    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image; //CircleImageView
        TextView title;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
