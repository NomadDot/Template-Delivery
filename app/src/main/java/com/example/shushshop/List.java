package com.example.shushshop;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class List extends Fragment implements View.OnClickListener {

    View viewMain;
    Fragmentator fragmentator;
    SharedRes sharedRes;
    ArrayList<ArrayList> listOfFilledMaps;

    List(Fragmentator getFragmentor, ArrayList<ArrayList> getListOfFilledMaps, SharedRes getSharedRes) {
        this.fragmentator = getFragmentor;
        this.listOfFilledMaps = getListOfFilledMaps;
        this.sharedRes = getSharedRes;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewMain = inflater.inflate(R.layout.fragment_list, container, false);


        ImageButton btnKali = viewMain.findViewById(R.id.Cali);
        btnKali.setOnClickListener(this);

        ImageButton btnFila = viewMain.findViewById(R.id.Fila);
        btnFila.setOnClickListener(this);

        ImageButton btnFuto = viewMain.findViewById(R.id.FutoMaki);
        btnFuto.setOnClickListener(this);

        ImageButton btnNigiri = viewMain.findViewById(R.id.Nigiri);
        btnNigiri.setOnClickListener(this);

        ImageButton btnMaki = viewMain.findViewById(R.id.Maki);
        btnMaki.setOnClickListener(this);

        ImageButton btnSets = viewMain.findViewById(R.id.Sets);
        btnSets.setOnClickListener(this);

        return viewMain;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        CurrentList currentList;

        switch(id) {
            case R.id.Cali:
                currentList = new CurrentList(listOfFilledMaps.get(0), sharedRes);
                fragmentator.replaceFragment(currentList);
                break;
            case R.id.Fila:
                currentList = new CurrentList(listOfFilledMaps.get(1), sharedRes);
                fragmentator.replaceFragment(currentList);
                break;
            case R.id.FutoMaki:
                currentList = new CurrentList(listOfFilledMaps.get(2), sharedRes);
                fragmentator.replaceFragment(currentList);
                break;
                case R.id.Nigiri:
                    currentList = new CurrentList(listOfFilledMaps.get(3), sharedRes);
                    fragmentator.replaceFragment(currentList);
                    break;
            case R.id.Maki:
                currentList = new CurrentList(listOfFilledMaps.get(4), sharedRes);
                fragmentator.replaceFragment(currentList);
                break;

            case R.id.Sets:
                currentList = new CurrentList(listOfFilledMaps.get(5), sharedRes);
                fragmentator.replaceFragment(currentList);
                break;
        }
    }

}