package com.belajar.rafi.mycats;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvList;
    private ArrayList<Cats>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(CatsData.getListData());

        getSupportActionBar().setTitle("Jenis-jenis Kucing");
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvList.setLayoutManager(new LinearLayoutManager(this));
        CardViewCatsAdapter cardViewCatsAdapter = new CardViewCatsAdapter(this);
        cardViewCatsAdapter.setListCats(list);
        rvList.setAdapter(cardViewCatsAdapter);

        ItemClickSupport.addTo(rvList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCats(list.get(position));
            }
        });
    }


    private void showSelectedCats(Cats cats){
        //Toast.makeText(this, "Kamu memilih "+cats.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DetailCatsActivity.class);
        intent.putExtra(DetailCatsActivity.EXTRA_NAME, cats.getName());
        intent.putExtra(DetailCatsActivity.EXTRA_DESC, cats.getDesc());
        intent.putExtra(DetailCatsActivity.EXTRA_PHOTO, cats.getPhoto());

        startActivity(intent);
    }
}
