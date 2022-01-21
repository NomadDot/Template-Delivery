package com.example.shushshop;

import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart extends Fragment  {

    View view;
    ListView listView;
    TextView sum;

    Context ctxt;
    LayoutInflater inflater;
    ArrayList<SushiObject> sushiObjects;

    Cart.MyCustomAdapter myCustomAdapter;

    SharedRes sharedRes;

    public Cart(SharedRes getSharedRes) {
        this.sharedRes = getSharedRes;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cart, container, false);
        listView = view.findViewById(R.id.listViewCart);
        sum = view.findViewById(R.id.suma);
        ctxt = view.getContext();

        sushiObjects = sharedRes.getSushiObjects();
        sum.setText(updateSum());
        myCustomAdapter = new Cart.MyCustomAdapter();
        listView.setAdapter(myCustomAdapter);

        return view;
    }

    public class MyCustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return sushiObjects.size();
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
            View myView = inflater.inflate(R.layout.list_item_added, null);

            SushiObject sushiObject = sushiObjects.get(i);

            TextView sushiName = myView.findViewById(R.id.itemNameAdded);
            TextView sushiPrice = myView.findViewById(R.id.priceAdded);
            TextView sushiCount = myView.findViewById(R.id.countOfSushi);

            sushiName.setText(sushiObject.getName());
            sushiPrice.setText(sushiObject.getPrice());
            sushiCount.setText(Integer.toString(sushiObject.getCount()));

            ImageView sushiImage = myView.findViewById(R.id.imgSushi);
            int image = sushiObject.getImage();
            if(image != 0) {sushiImage.setImageDrawable(ContextCompat.getDrawable(ctxt,  image)); }
            else {sushiImage.setImageDrawable(ContextCompat.getDrawable(ctxt,  R.drawable.sushi_futo_ugor_foreground));}

            Button btnMinus = myView.findViewById(R.id.minusButton);
            Button btnPlus = myView.findViewById(R.id.plusButton);

            View.OnClickListener plusBtnClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(sushiObject.getCount() < 10) {
                        int countObject = sushiObject.getCount() + 1;
                        sushiObject.setCount(countObject);
                        sushiCount.setText(Integer.toString(countObject));
                        sum.setText(updateSum());
                    }
                }
            };
            btnPlus.setOnClickListener(plusBtnClick);

            View.OnClickListener minusBtnClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(sushiObject.getCount() > 0) {
                        int countObject = sushiObject.getCount() - 1;
                        sushiObject.setCount(countObject);
                        sushiCount.setText(Integer.toString(countObject));
                        sum.setText(updateSum());
                    }

                    if(  sushiObject.getCount() == 0) {
                        sushiObjects.remove(i);
                        myCustomAdapter.notifyDataSetChanged();
                        sum.setText(updateSum());
                    }
                }
            };
            btnMinus.setOnClickListener(minusBtnClick);

            return myView;
        }

    }

    public String updateSum() {
        int calcSum = 0;
        for(int i = 0; i < sushiObjects.size(); i += 1) {
            SushiObject sushiObject = sushiObjects.get(i);
            int price = Integer.parseInt(sushiObject.getPrice());
            int multiplier = sushiObject.getCount();

            calcSum += price * multiplier;
        }
        String strSum = Integer.toString(calcSum);
        return strSum;
    }
}