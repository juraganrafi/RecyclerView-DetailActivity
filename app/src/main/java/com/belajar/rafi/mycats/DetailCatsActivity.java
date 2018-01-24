package com.belajar.rafi.mycats;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.GlideModule;

import java.util.ArrayList;

public class DetailCatsActivity extends AppCompatActivity{

    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESC = "extra_desc";
    public static String EXTRA_PHOTO = "extra_photo";
    private ImageView tvPhoto;
    private TextView tvName, tvDesc;
    private Context context;
    private ArrayList<Cats> listCats;
    private int position;

    private ArrayList<Cats> getListCats(){
        return listCats;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cats);

        tvPhoto = (ImageView)findViewById(R.id.img_detail);


        if (getIntent().getExtras() != null){
            String imageUrl = getIntent().getExtras().getString(EXTRA_PHOTO);
            Glide.with(this)
                    .load(imageUrl)
                    .into(tvPhoto);
        }

        tvName = (TextView)findViewById(R.id.tv_name_detail);
        String name= getIntent().getStringExtra(EXTRA_NAME);
        tvName.setText(name);

        tvDesc = (TextView)findViewById(R.id.tv_desc_detail);
        String desc = getIntent().getStringExtra(EXTRA_DESC);
        tvDesc.setText(desc);

        getSupportActionBar().setTitle("Tentang Kucing ");

    }

}
