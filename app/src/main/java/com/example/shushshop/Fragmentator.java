package com.example.shushshop;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.HashMap;
public class Fragmentator extends AppCompatActivity {

    FragmentManager fragmentManager;
    Fragmentator(FragmentManager getFragmentManager) {
        fragmentManager = getFragmentManager;
    }
    public void replaceFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
