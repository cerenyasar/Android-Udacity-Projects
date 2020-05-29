package com.example.android.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(getString(R.string.old_ist),getString(R.string.restaurants),R.drawable.old_cuis));
        items.add(new Item(getString(R.string.sultanahmet_kofte),getString(R.string.restaurants),R.drawable.sultanahmet_kofte));

        final ArrayList<Item> itemsTwo = new ArrayList<>();
        itemsTwo.add(new Item(getString(R.string.old_ist),getString(R.string.restaurants),getString(R.string.old_ist_des),R.drawable.old_cuis,
                new Float(41.010458),new Float(28.975588),getString(R.string.old_ist_phone),getString(R.string.old_ist_web)));
        itemsTwo.add(new Item(getString(R.string.sultanahmet_kofte),getString(R.string.restaurants),getString(R.string.kofte_des),R.drawable.sultanahmet_kofte,
                new Float(41.008304),new Float(28.976965),getString(R.string.kofte_phone),getString(R.string.kofte_web)));
        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item  item = itemsTwo.get(i);
                Intent intent = new Intent(getActivity(), ShowActivity.class);
                intent.putExtra("title",item.getTitle());
                intent.putExtra("type",item.getType());
                intent.putExtra("des",item.getDescription());
                intent.putExtra("image",item.getImgResId());
                intent.putExtra ( "lat",item.getLatitude());
                intent.putExtra("lng",item.getLongtitude());
                intent.putExtra("phone",item.getPhone());
                intent.putExtra("web",item.getWeb());
                startActivity(intent);
            }
        });
        return rootView;
    }

}
