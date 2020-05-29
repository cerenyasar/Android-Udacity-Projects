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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(getString(R.string.tashkonak),getString(R.string.hotels),R.drawable.tashkonak_hotel));
        items.add(new Item(getString(R.string.celal_sultan),getString(R.string.hotels),R.drawable.celal_sultan));
        items.add(new Item(getString(R.string.sura_hagia),getString(R.string.hotels),R.drawable.sura_hotel));

        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);
        final ArrayList<Item> itemsTwo = new ArrayList<>();
        itemsTwo.add(new Item(getString(R.string.tashkonak),getString(R.string.hotels),getString(R.string.tash_des),R.drawable.tashkonak_hotel,
                new Float(41.003656),new Float(28.976878),getString(R.string.tash_phone),getString(R.string.tash_web)));
        itemsTwo.add(new Item(getString(R.string.celal_sultan),getString(R.string.hotels),getString(R.string.celal_des),R.drawable.celal_sultan,
                new Float(41.009977),new Float(28.977264),getString(R.string.celal_phone),getString(R.string.celal_web)));
        itemsTwo.add(new Item(getString(R.string.sura_hagia),getString(R.string.hotels),getString(R.string.sura_des),R.drawable.sura_hotel,
                new Float( 41.009018),new Float(28.976157),getString(R.string.sura_phone),getString(R.string.sura_web)));


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
