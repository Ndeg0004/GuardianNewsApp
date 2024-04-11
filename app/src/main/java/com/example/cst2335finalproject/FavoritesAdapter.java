package com.example.cst2335finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private Context context;
    private List<Article> favoritesList;
    private MyOpener myOpener;

    public FavoritesAdapter(Context context, List<Article> favoritesList, MyOpener myOpener) {
        this.context = context;
        this.favoritesList = favoritesList;
        this.myOpener = myOpener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite_article, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = favoritesList.get(position);
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return favoritesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView urlTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            urlTextView = itemView.findViewById(R.id.urlTextView);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Article article = favoritesList.get(position);
                    // Implement your logic for article click event (e.g., delete or update)
                }
            });
        }

        public void bind(Article article) {
            titleTextView.setText(article.getTitle());
            urlTextView.setText(article.getUrl());
        }
    }

    // Method to remove an article from favorites
    public void removeItem(int position) {
        Article article = favoritesList.get(position);
        SQLiteDatabase db = myOpener.getWritableDatabase();
        db.delete(MyOpener.TABLE_NAME, MyOpener.COL_ID + " = ?", new String[]{String.valueOf(article.getId())});
        favoritesList.remove(position);
        notifyItemRemoved(position);
    }
}
