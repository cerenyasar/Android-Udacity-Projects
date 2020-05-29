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
public class ShopFragment extends Fragment {


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_list, container, false);
        final ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item(getString(R.string.grand_bazaar),getString(R.string.bazaar),R.drawable.grand));
        items.add(new Item(getString(R.string.egyptian_bazaar),getString(R.string.bazaar),R.drawable.egyptian));
        final ArrayList<Item> itemsTwo = new ArrayList<Item>();
        itemsTwo.add(new Item(getString(R.string.grand_bazaar),getString(R.string.bazaar),getString(R.string.grand_des),R.drawable.grand,
                new Float(41.010686),new Float(28.96805),getString(R.string.grand_phone),getString(R.string.grand_web)));
        itemsTwo.add(new Item(getString(R.string.egyptian_bazaar),getString(R.string.bazaar),getString(R.string.egyptian_des),R.drawable.egyptian,
                new Float(41.0165),new Float(28.970519),getString(R.string.egyptian_phone),getString(R.string.egyptian_web)));
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
