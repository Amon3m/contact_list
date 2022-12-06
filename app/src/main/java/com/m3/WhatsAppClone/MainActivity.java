package com.m3.WhatsAppClone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        List<Contact>data=createContact();
        contactAdapter =new ContactAdapter(data);
        recyclerView.setAdapter(contactAdapter);
        //b3d ma a3rf el adabter
        //6- bb3t el listener
        contactAdapter.setOnImageClickListener(new ContactAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position, Contact contact) {
                //implementation action
                Log.e("pos",""+position);
                Toast.makeText(MainActivity.this, contact.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }
    List<Contact> createContact (){

        List<Contact>contacts=new ArrayList<>();
        contacts.add(new Contact("Ahmed","online"));
        contacts.add(new Contact("Mohamed","online"));
        contacts.add(new Contact("Mon3m","online"));
        for (int i=0;i<1000;i++){
            contacts.add(new Contact("Contact"+" "+i,"busy"));}
        return contacts;

    }
}