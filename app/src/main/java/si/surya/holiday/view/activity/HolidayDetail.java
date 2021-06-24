package si.surya.holiday.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import si.surya.holiday.R;
import si.surya.holiday.database.ArchieveDatabase;
import si.surya.holiday.database.ArchieveModel;

public class HolidayDetail extends AppCompatActivity {

    TextView detailTgl, detailHariBesar;
    String  tanggal, holiday;
    String id;
    ImageView archieve;
    ArchieveDatabase archieveDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_detail);
        archieveDatabase = ArchieveDatabase.iniDatabase(getApplicationContext());
        ActionBar actionBar = getSupportActionBar();


        actionBar.setHomeAsUpIndicator(R.drawable.arrow_back);

        actionBar.setDisplayHomeAsUpEnabled(true);

        detailTgl = findViewById(R.id.tanggal);
        detailHariBesar = findViewById(R.id.hari_besar);
        archieve = findViewById(R.id.arsip);
        save();
        getIncomingIntent();
    }



    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String getId = bundle.getString("id");
            String getDate = bundle.getString("hdDay");
            String getName = bundle.getString("hdName");

            id = getId;
            tanggal = getDate;
            holiday = getName;

            detailTgl.setText(getDate);
            detailHariBesar.setText(getName);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void save(){
        archieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    ArchieveModel archieveModel = new ArchieveModel();
                    archieveModel.setId(id);
                    archieveModel.setTanggal(tanggal);
                    archieveModel.setHoliday(holiday);

                    archieveDatabase.archieveDao().insertArchieve(archieveModel);

                    Log.d("HolidayDetail", "Sukses menambahkan hari penting");
                    Toast.makeText(getApplicationContext(),"Sukses menambah hari penting ", Toast.LENGTH_SHORT).show();


                }catch (Exception ex){
                    Log.e("HolidayDetail", "Failed, err : "+ex.getMessage());
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}