package com.m3.WhatsAppClone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder>{
    public Adapter(List<Contact> items) {
        this.items = items;
    }

    List<Contact>items;
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_contect,parent,false);
        Viewholder viewholder=new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
       Contact contact=items.get(position);
       holder.status.setText(contact.getStatus());
       holder.name.setText(contact.getName());
    }

    @Override
    public int getItemCount() {
       if (items==null)return 0;
       return items.size();
    }

    class Viewholder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView status;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            status=itemView.findViewById(R.id.status);}
    }
}