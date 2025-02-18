package com.example.l3q1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // Set up ViewPager Adapter
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: return new ArtistsFragment();
                    case 1: return new AlbumsFragment();
                    case 2: return new SongsFragment();
                    default: return new ArtistsFragment();
                }
            }

            @Override
            public int getItemCount() {
                return 3; // Three tabs: Artists, Albums, Songs
            }
        });

        // Attach TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("Artists"); break;
                case 1: tab.setText("Albums"); break;
                case 2: tab.setText("Songs"); break;
            }
        }).attach();
    }

    // 📌 Artists Fragment (ListView)
    public static class ArtistsFragment extends Fragment {
        @Nullable
        @Override
        public android.view.View onCreateView(@NonNull android.view.LayoutInflater inflater,
                                              @Nullable android.view.ViewGroup container,
                                              @Nullable Bundle savedInstanceState) {
            android.view.View view = inflater.inflate(R.layout.list, container, false);
            ListView listView = view.findViewById(R.id.listView);

            List<String> artists = Arrays.asList("Taylor Swift", "Ed Sheeran", "Beyoncé", "Drake", "Adele");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, artists);
            listView.setAdapter(adapter);
            return view;
        }
    }

    // 📌 Albums Fragment (GridView)
    public static class AlbumsFragment extends Fragment {
        @Nullable
        @Override
        public android.view.View onCreateView(@NonNull android.view.LayoutInflater inflater,
                                              @Nullable android.view.ViewGroup container,
                                              @Nullable Bundle savedInstanceState) {
            android.view.View view = inflater.inflate(R.layout.grid, container, false);
            GridView gridView = view.findViewById(R.id.gridView);

            // Example album names
            List<String> albums = Arrays.asList("1989", "Divide", "Lemonade", "Scorpion", "25");

            // Set adapter for grid
            ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, albums);
            gridView.setAdapter(adapter);
            return view;
        }
    }

    // 📌 Songs Fragment (TableLayout)
    public static class SongsFragment extends Fragment {
        @Nullable
        @Override
        public android.view.View onCreateView(@NonNull android.view.LayoutInflater inflater,
                                              @Nullable android.view.ViewGroup container,
                                              @Nullable Bundle savedInstanceState) {
            android.view.View view = inflater.inflate(R.layout.table, container, false);
            TableLayout tableLayout = view.findViewById(R.id.tableLayout);

            String[][] songs = {
                    {"Title", "Artist"},
                    {"Shape of You", "Ed Sheeran"},
                    {"Hello", "Adele"},
                    {"Blinding Lights", "The Weeknd"}
            };

            for (int i = 0; i < songs.length; i++) {
                TableRow tableRow = new TableRow(requireContext());

                for (int j = 0; j < songs[i].length; j++) {
                    TextView textView = new TextView(requireContext());
                    textView.setText(songs[i][j]);
                    textView.setPadding(32, 16, 32, 16);
                    textView.setTextSize(i == 0 ? 18 : 16);
                    textView.setTypeface(null, i == 0 ? android.graphics.Typeface.BOLD : android.graphics.Typeface.NORMAL);
                    tableRow.addView(textView);
                }

                tableLayout.addView(tableRow);
            }
            return view;
        }
    }
}
