package si.surya.holiday.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import si.surya.holiday.R;
import si.surya.holiday.view.fragment.HolidayList;
import si.surya.holiday.view.fragment.NoteList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment selectedfragment = new HolidayList();
    private BottomNavigationView bottomNavigationView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.menu_bawah);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedfragment);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull  MenuItem item) {
        switch (item.getItemId()){
            case R.id.date:
                selectedfragment = new HolidayList();
                loadFragment(selectedfragment);
                break;

            case R.id.note:
                selectedfragment = new NoteList();
                loadFragment(selectedfragment);
                break;
        }
        return loadFragment(selectedfragment);
    }

    private boolean loadFragment(Fragment selectedfragment) {
        if(selectedfragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainui,selectedfragment)
                    .commit();
            return true;
        }
        return false;
    }
}