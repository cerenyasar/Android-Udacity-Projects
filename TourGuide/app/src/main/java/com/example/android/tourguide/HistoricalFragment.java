package com.example.android.tourguide;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
public class HistoricalFragment extends Fragment {


    public HistoricalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(getString(R.string.hagiasphia),getString(R.string.museum),R.drawable.hagia_sophia));
        items.add(new Item(getString(R.string.dolmabahce),getString(R.string.museum),R.drawable.dolmabahce));
        items.add(new Item(getString(R.string.blue_mosque),getString(R.string.mosque),R.drawable.blue_mosque));
        items.add(new Item(getString(R.string.basilica_cistern),getString(R.string.museum),R.drawable.basilica));
        items.add(new Item(getString(R.string.maidens_tower),getString(R.string.museum),R.drawable.maidens));
        items.add(new Item(getString(R.string.topkapi_palace),getString(R.string.bazaar),R.drawable.topkapi));

        ItemAdapter adapter = new ItemAdapter(getActivity(), items);
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);
        final ArrayList<Item> itemsTwo = new ArrayList<Item>();
        itemsTwo.add(new Item(getString(R.string.hagiasphia),getString(R.string.museum),getString(R.string.hagia_des),R.drawable.hagia_sophia,
                new Float(41.003315),new Float(28.974202),getString(R.string.hagia_phone),getString(R.string.hagia_web)));
        itemsTwo.add(new Item(getString(R.string.dolmabahce),getString(R.string.museum),getString(R.string.dolmabahce_des),R.drawable.dolmabahce,
                new Float(41.039177),new Float(29.000452),getString(R.string.dolmabahce_phone),getString(R.string.dolmabahce_web)));
        itemsTwo.add(new Item(getString(R.string.blue_mosque),getString(R.string.mosque),getString(R.string.blue_des),R.drawable.blue_mosque,
                new Float(41.005423),new Float(28.976805),getString(R.string.blue_phone),getString(R.string.blue_web)));
        itemsTwo.add(new Item(getString(R.string.basilica_cistern),getString(R.string.museum),getString(R.string.basilica_des),R.drawable.basilica,
                new Float(41.008384),new Float(28.977878),getString(R.string.basilica_phone),getString(R.string.basilica_web)));
        itemsTwo.add(new Item(getString(R.string.maidens_tower),getString(R.string.museum),getString(R.string.maidens_des),R.drawable.maidens,
                new Float(41.021128),new Float(29.004099),getString(R.string.maidens_phone),getString(R.string.maidens_web)));
        itemsTwo.add(new Item(getString(R.string.topkapi_palace),getString(R.string.bazaar),getString(R.string.topkapi_des),R.drawable.topkapi,
                new Float(41.01152),new Float(28.983379),getString(R.string.topkapi_phone),getString(R.string.topkapi_web)));



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
