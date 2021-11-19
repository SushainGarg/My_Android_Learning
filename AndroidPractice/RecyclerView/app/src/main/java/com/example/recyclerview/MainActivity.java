package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactRecyclerView = findViewById(R.id.conttactsRecyclerView);

        ArrayList<Contact> contacts = new ArrayList<>();


            contacts.add(new Contact("Sushain","gargsushain@gmail.com","https://imagekit.io/blog/content/images/2019/12/image-optimization.jpg"));
            contacts.add(new Contact("Hazel","hazel@gmail.com","https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg"));
            contacts.add(new Contact("Nancee","nanceegarg@gmail.com","https://images.ctfassets.net/hrltx12pl8hq/4plHDVeTkWuFMihxQnzBSb/aea2f06d675c3d710d095306e377382f/shutterstock_554314555_copy.jpg"));
            contacts.add(new Contact("Emma","emma@gmail.com","https://www.industrialempathy.com/img/remote/ZiClJf-1920w.jpg"));
            contacts.add(new Contact("Stalin","stalin@yahoo.com","https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"));

            ContactsRecyclerViewAdapter adapter = new ContactsRecyclerViewAdapter(this);
            adapter.setContacts(contacts);
            contactRecyclerView.setAdapter(adapter);
            contactRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

    }
}