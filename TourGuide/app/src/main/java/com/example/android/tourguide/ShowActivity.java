package com.example.android.tourguide;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class ShowActivity extends AppCompatActivity {
    private Float lat;
    private Float lng;
    private String phone_num;
    private String web_p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.places);
        Bundle bundle = getIntent().getExtras();
        TextView title =  findViewById(R.id.title);
        TextView type =  findViewById(R.id.type);
        ImageView image = findViewById(R.id.image);
        TextView des = findViewById(R.id.description);
        if ( bundle!=null) {
            title.setText(bundle.getString("title"));
            type.setText(bundle.getString("type"));
            des.setText(bundle.getString("des"));
            image.setImageResource(bundle.getInt("image"));
            lat = bundle.getFloat("lat");
            lng = bundle.getFloat("lng");
            phone_num = bundle.getString("phone");
            web_p = bundle.getString("web");
        }

        final ImageView address = findViewById(R.id.address);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUri = "http://maps.google.com/maps?q=loc:" + lat + "," + lng + " (" + "Place" + ")";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

                startActivity(intent);
                /*String uri = String.format(Locale.ENGLISH, "geo:0,0?q="+address);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);*/
            }
        });
        final ImageView web = findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse(web_p);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
        ImageView phone = findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone_num));
                startActivity(intent);
            }
        });
    }
}
