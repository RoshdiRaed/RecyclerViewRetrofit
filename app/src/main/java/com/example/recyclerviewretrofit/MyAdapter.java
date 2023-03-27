package com.example.recyclerviewretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    Context c;
    ArrayList<Post> posts;

    public MyAdapter(Context c, ArrayList<Post> posts) {
        this.c = c;
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.post_item,null,false);
        MyHolder mh = new MyHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Post p = posts.get(position);

        holder.tv_id.setText(""+p.getId());
        holder.tv_title.setText(p.getTitle());
        holder.tv_body.setText(p.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_body,tv_id,tv_title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_id = itemView.findViewById(R.id.tv_id);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_body = itemView.findViewById(R.id.tv_body);
        }
    }

}
