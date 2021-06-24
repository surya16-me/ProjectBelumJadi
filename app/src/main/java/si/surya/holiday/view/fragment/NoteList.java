package si.surya.holiday.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Delete;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import si.surya.holiday.R;
import si.surya.holiday.adapter.ArchieveAdapter;
import si.surya.holiday.database.ArchieveDatabase;
import si.surya.holiday.database.ArchieveModel;


public class NoteList extends Fragment {
    private RecyclerView rvArchieve;
    private ArchieveAdapter archieveAdapter;
    private ArrayList<ArchieveModel> listArchieve = new ArrayList<>();
    private ArchieveDatabase archieveDatabase;
    private Button Hapus ;

    public NoteList() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_list, container, false);


    }



    @Override
    public void onViewCreated(@NonNull  View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvArchieve = view.findViewById(R.id.rv_holiday_load);
        archieveAdapter = new ArchieveAdapter(getContext());
        archieveAdapter.notifyDataSetChanged();

        if (archieveDatabase == null){
            archieveDatabase = ArchieveDatabase.iniDatabase(getContext());

        }
        listArchieve.addAll(archieveDatabase.archieveDao().getArchieve());
        archieveAdapter.setData(listArchieve);

        rvArchieve.setLayoutManager(new LinearLayoutManager(getContext()));
        rvArchieve.setAdapter(archieveAdapter);



    }
}