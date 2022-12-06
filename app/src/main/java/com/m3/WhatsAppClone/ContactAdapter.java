package com.m3.WhatsAppClone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ViewHolder holder;
    private int position;

    //constractor
    public ContactAdapter(List<Contact> items) {

        this.items = items;
    }

    List<Contact>items;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item_contect,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
    return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {

       Contact contact=items.get(position);
        holder.name.setText(contact.getName());
        holder.status.setText(contact.getStatus());
        //5 inside bind

        if(onImageClickListener!=null){ //lw 7d ba3tly listener


            holder.image.setOnClickListener(new View.OnClickListener() {
                //mn holder gebly image w hotlaha on listener
                @Override
                public void onClick(View v) {
                    //

                    //call back betnady 3ala action

                    onImageClickListener.onItemClick(holder.getAdapterPosition(),contact);
                }
            });
        }

    }

    onItemClickListener onImageClickListener;//3-object from onItemClickListener

    public void setOnImageClickListener(onItemClickListener onImageClickListener) {

        this.onImageClickListener = onImageClickListener;//4-setter for onImageClickListener
    }


    interface onItemClickListener{   //1-

        void onItemClick(int postion,Contact contact);//2-bb3t postion w data
    }

    @Override
    public int getItemCount() {
        if (items==null)return 0;
      return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView status;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            status=itemView.findViewById(R.id.status);
            image=itemView.findViewById(R.id.image);


        }
    }
}
