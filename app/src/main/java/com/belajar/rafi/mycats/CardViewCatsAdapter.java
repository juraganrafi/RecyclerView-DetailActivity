package com.belajar.rafi.mycats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by rafi on 1/18/18.
 */

public class CardViewCatsAdapter extends RecyclerView.Adapter<CardViewCatsAdapter.CardViewViewHolder> {

    private ArrayList<Cats> listCats;
    private Context context;

    CardViewCatsAdapter(Context context){
        this.context = context;
    }

    private ArrayList<Cats> getListCats(){
        return listCats;
    }

    void setListCats(ArrayList<Cats> listCats){
        this.listCats = listCats;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_cats, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        Cats p = getListCats().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvDesc.setText(p.getDesc());

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListCats().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListCats().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListCats().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        Button btnFavorite, btnShare;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvDesc = (TextView)itemView.findViewById(R.id.tv_item_desc);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }
}