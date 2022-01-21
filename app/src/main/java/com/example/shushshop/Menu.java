package com.example.shushshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    List fragmentMain;
    Cart cartFragment;

    HashMap<String, String> mapOfFila = new HashMap<>();
    HashMap<String, String> mapOfKali = new HashMap<>();
    HashMap<String, String> mapOfMaki = new HashMap<>();
    HashMap<String, String> mapOfSets = new HashMap<>();
    HashMap<String, String> mapOfFuto = new HashMap<>();
    HashMap<String, String> mapOfNigiri = new HashMap<>();

    Fragmentator fragmentator;

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ArrayList<ArrayList> listOfFilledArrays = basicInitialization();

        SharedRes sharedRes = new SharedRes();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentator = new Fragmentator(fragmentManager);

        fragmentMain = new List(fragmentator, listOfFilledArrays, sharedRes);
        cartFragment = new Cart(sharedRes);


        fragmentator.replaceFragment(fragmentMain);

        bottomNavigationView = findViewById(R.id.bottomNavigView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.firstFragment:
                fragmentator.replaceFragment(fragmentMain);
                break;
            case R.id.secondFragment:
                fragmentator.replaceFragment(cartFragment);
                break;
//            case R.id.thirdFragment:
//                replaceFragment(onlineFragment);
//                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private boolean backpressedTwice = false;
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            if(backpressedTwice == true) {
                finish();
            }
            else {
                fragmentator.replaceFragment(fragmentMain);
                backpressedTwice = true;
                Toast.makeText(this, "Натисніть ще раз, щоб вийти", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        backpressedTwice=false;
                    }
                }, 1000);
            }
        }
        return false;
    }

    public ArrayList<ArrayList> basicInitialization() {
        ArrayList<SushiObject> listOfCali = new ArrayList<>();
        ArrayList<SushiObject> listOfFila = new ArrayList<>();
        ArrayList<SushiObject> listOfFuto = new ArrayList<>();
        ArrayList<SushiObject> listOfNigiri = new ArrayList<>();
        ArrayList<SushiObject> listOfMaki = new ArrayList<>();
        ArrayList<SushiObject> listOfSets = new ArrayList<>();

        SushiObject caliSalmon = new SushiObject("Каліфорнія з лососем", "79");
        SushiObject caliShrimp = new SushiObject("Каліфорнія з креветками", "75");
        SushiObject caliEel = new SushiObject("Каліфорнія з вугрем", "105");
        SushiObject caliSmokedSalmon = new SushiObject("Каліфорнія філа з копченим лососем", "90");

        //mapOfKali.put("Каліфорнія з лососем", "79");
        //mapOfKali.put("Каліфорнія з креветками", "75");
        //mapOfKali.put("Каліфорнія з вугрем", "105");
        //mapOfKali.put("Каліфорнія філа з копченим лососем", "90");

//        mapOfFila.put("Філадельфия з копченим лососем", "99");
//        mapOfFila.put("Філадельфія з тунцем", "99");
//        mapOfFila.put("Філадельфия класік з лососем та тамаго", "130");
//        mapOfFila.put("Філадельфія з тигровою креветкою", "99");
//
        SushiObject filaSmokedSalmon = new SushiObject("Філадельфия з копченим лососем", "99");
        SushiObject filaTuna = new SushiObject("Філадельфія з тунцем", "109");
        SushiObject filaClassic = new SushiObject("Філадельфия класік з лососем та тамаго", "130");
        SushiObject filaTigerShrimp = new SushiObject("Філадельфія з тигровою креветкою", "99");

//        mapOfMaki.put("Макі з авокадо", "25");
//        mapOfMaki.put("Макі з лососем", "35");
//        mapOfMaki.put("Макі з огірком", "30");
//        mapOfMaki.put("Макі з вугрем", "40");

        SushiObject makiAvokado = new SushiObject("Макі з авокадо", "25");
        SushiObject makiSalmon = new SushiObject("Макі з лососем", "35");
        SushiObject makiCucumber = new SushiObject("Макі з огірком", "30");
        SushiObject makiEel = new SushiObject("Макі з вугрем", "40");


//        mapOfFuto.put("Футо-макі з вугрем та тамаго", "85");
//        mapOfFuto.put("Футо-макі з тунцем та крем-сиром", "95");
//        mapOfFuto.put("Футо-макі з лососем ", "89");
//        mapOfFuto.put("Вега футо-макі", "59");

        SushiObject futoEel = new SushiObject("Футо-макі з вугрем та тамаго", "85", R.drawable.sushi_futo_ugor_foreground);
        SushiObject futoTuna = new SushiObject("Футо-макі з тунцем та крем-сиром", "95", R.drawable.sushi_futo_tunec_foreground);
        SushiObject futoSalmon = new SushiObject("Футо-макі з лососем ", "89", R.drawable.sushi_futo_salmon_foreground);
        SushiObject futoVegan = new SushiObject("Вега футо-макі", "59", R.drawable.sushi_futo_avokado_foreground);
//
//        mapOfNigiri.put("Нігірі з лососем", "29");
//        mapOfNigiri.put("Нігірі з вугрем", "39");
//        mapOfNigiri.put("Нігірі з манго", "35");
//        mapOfNigiri.put("Гункан з ікрою летючої риби", "39");

        SushiObject nigiriSalmon = new SushiObject("Нігірі з лососем", "29");
        SushiObject nigiriEel = new SushiObject("Нігірі з вугрем", "39");
        SushiObject nigiriMango = new SushiObject("Нігірі з манго", "35");
        SushiObject gunkan = new SushiObject("Гункан з ікрою летючої риби", "39");

//        mapOfSets.put("Сет Філадельфія", "659");
//        mapOfSets.put("Сет Каліфорнія", "569");
//        mapOfSets.put("Сет Токіо", "389");

        SushiObject setFila = new SushiObject("Сет Філадельфія", "659");
        SushiObject setCali = new SushiObject("Сет Каліфорнія", "569");
        SushiObject setTokyo= new SushiObject("Сет Токіо", "389");

//        listOfMap.add(mapOfKali);
//        listOfMap.add(mapOfFila);
//        listOfMap.add(mapOfFuto);
//        listOfMap.add(mapOfNigiri);
//        listOfMap.add(mapOfMaki);
//        listOfMap.add(mapOfSets);

        listOfCali.add(caliSalmon);
        listOfCali.add(caliShrimp);
        listOfCali.add(caliEel);
        listOfCali.add(caliSmokedSalmon);

        listOfFila.add(filaSmokedSalmon);
        listOfFila.add(filaTuna);
        listOfFila.add(filaClassic);
        listOfFila.add(filaTigerShrimp);

        listOfFuto.add(futoEel);
        listOfFuto.add(futoTuna);
        listOfFuto.add(futoSalmon);
        listOfFuto.add(futoVegan);

        listOfNigiri.add(nigiriSalmon);
        listOfNigiri.add(nigiriEel);
        listOfNigiri.add(nigiriMango);
        listOfNigiri.add(gunkan);

        listOfMaki.add(makiAvokado);
        listOfMaki.add(makiSalmon);
        listOfMaki.add(makiCucumber);
        listOfMaki.add(makiEel);

        listOfSets.add(setFila);
        listOfSets.add(setCali);
        listOfSets.add(setTokyo);

        ArrayList<ArrayList> listOfLists = new ArrayList<>();

        listOfLists.add(listOfCali);
        listOfLists.add(listOfFila);
        listOfLists.add(listOfFuto);
        listOfLists.add(listOfNigiri);
        listOfLists.add(listOfMaki);
        listOfLists.add(listOfSets);

        return listOfLists;
    }

}