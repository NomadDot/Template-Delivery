package com.example.shushshop;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.shushshop.R.mipmap.sushi_futo;


public class CurrentList extends Fragment {

    View view;
    ListView listView;
    Context ctxt;
    LayoutInflater inflater;
    ArrayList<SushiObject> listOfSushi = new ArrayList<>();

    SharedRes sharedRes;

    CurrentList(ArrayList<SushiObject> sushiObjects, SharedRes getSharedRes) {
       this.listOfSushi = sushiObjects;
       this.sharedRes = getSharedRes;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_current_list, container, false);
        listView = view.findViewById(R.id.listViewC);
        ctxt = view.getContext();

        CurrentList.MyCustomAdapter myCustomAdapter = new CurrentList.MyCustomAdapter();
        listView.setAdapter(myCustomAdapter);

        return view;
    }

    public class MyCustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return listOfSushi.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            inflater = (LayoutInflater) ctxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = inflater.inflate(R.layout.list_item, null);

            TextView sushiName = myView.findViewById(R.id.itemName);
            TextView sushiPrice = myView.findViewById(R.id.price);
            ImageView sushiImage = myView.findViewById(R.id.imgSushiOne);

            sushiName.setText(listOfSushi.get(i).getName());
            sushiPrice.setText(listOfSushi.get(i).getPrice());
            int image = listOfSushi.get(i).getImage();
            if(image != 0) {sushiImage.setImageDrawable(ContextCompat.getDrawable(ctxt,  image)); }
            else {sushiImage.setImageDrawable(ContextCompat.getDrawable(ctxt,  R.drawable.sushi_futo_ugor_foreground));}

            Button addBtn = myView.findViewById(R.id.addButton);

            View.OnClickListener addBtnClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("ADD BUTTON", "WORK");
                    SushiObject sushiObject = listOfSushi.get(i);

                    Toast toast = Toast.makeText(ctxt, "Додано в корзину", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM, 0,-50);
                    toast.show();

                    if(getChecked(sushiObject.getName())) {
                        sushiObject.setCount(sushiObject.getCount() + 1);
                    }
                    else {
                        String name = sushiObject.getName();
                        String price = sushiObject.getPrice();
                        sharedRes.setSushiObjects(sushiObject);
                    }
                }
            };

            addBtn.setOnClickListener(addBtnClick);
            return myView;
        }
    }

    boolean getChecked(String name) {
        ArrayList<SushiObject> sushiCheck = sharedRes.getSushiObjects();
        for(int i = 0; i < sushiCheck.size(); i += 1){
            if(name == sushiCheck.get(i).getName()) {
                return true;
            }
        }
        return false;
    }


}