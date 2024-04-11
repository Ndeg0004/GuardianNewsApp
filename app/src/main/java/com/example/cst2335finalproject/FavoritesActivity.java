package com.example.cst2335finalproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.cst2335finalproject.MyOpener.COL_ARTICLE;
import static com.example.cst2335finalproject.MyOpener.COL_ID;
import static com.example.cst2335finalproject.MyOpener.COL_URL;
import static com.example.cst2335finalproject.MyOpener.TABLE_NAME;

public class FavoritesActivity extends AppCompatActivity {
    private MyOpener myOpener;
    private List<Article> favoritesList;
    private FavoritesAdapter favoritesAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites_activity);

        myOpener = new MyOpener(this);
        favoritesList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerViewFavorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        favoritesAdapter = new FavoritesAdapter(this, favoritesList, myOpener);
        recyclerView.setAdapter(favoritesAdapter);

        loadFavorites();
    }

    private void loadFavorites() {
        SQLiteDatabase db = myOpener.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                long id = cursor.getLong(cursor.getColumnIndex(COL_ID));
                String title = cursor.getString(cursor.getColumnIndex(COL_ARTICLE));
                String url = cursor.getString(cursor.getColumnIndex(COL_URL));
                Article article = new Article(id, title, url);
                favoritesList.add(article);
            } while (cursor.moveToNext());
            cursor.close();
            favoritesAdapter.notifyDataSetChanged();
        }
    }
}
