package com.example.q1;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout fr;
    TabLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fr=findViewById(R.id.frameLay);
        tl=findViewById(R.id.tab);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLay, new ArtistFragment())
                .addToBackStack("null")
                .commit();

tl.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Fragment fr=null;
        switch(tab.getPosition()){
            case 0:
                fr=new ArtistFragment(); break;
            case 1:
                fr=new AlbumFragment(); break;
            case 2:
                fr=new SongsFragment(); break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLay, fr)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});
    }
}