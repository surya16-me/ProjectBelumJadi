package si.surya.holiday.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import si.surya.holiday.R;
import si.surya.holiday.adapter.HolidayDiscoverAdapter;
import si.surya.holiday.model.holiday.HolidaysItem;
import si.surya.holiday.view.viewmodel.HolidayViewModel;


public class HolidayList extends Fragment {

    private HolidayDiscoverAdapter holidayDiscoverAdapter;
    private RecyclerView rvHolidayDiscover;
    private HolidayViewModel holidayViewModel;
    public HolidayList() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_holiday_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        holidayDiscoverAdapter = new HolidayDiscoverAdapter(getContext());
        holidayDiscoverAdapter.notifyDataSetChanged();

        rvHolidayDiscover = view.findViewById(R.id.rv_holiday);
        rvHolidayDiscover.setLayoutManager(new LinearLayoutManager(getContext()));

        holidayViewModel = new ViewModelProvider(this).get(HolidayViewModel.class);
        holidayViewModel.setHolidayDiscover();
        holidayViewModel.getHolidayDiscover().observe(getViewLifecycleOwner(), getHolidayDiscover);

        rvHolidayDiscover.setAdapter(holidayDiscoverAdapter);

    }

    private Observer<ArrayList<HolidaysItem>> getHolidayDiscover = new Observer<ArrayList<HolidaysItem>>() {
        @Override
        public void onChanged(ArrayList<HolidaysItem> holidaysItems) {
            if(holidaysItems!=null){
                holidayDiscoverAdapter.setData(holidaysItems);
            }
        }
    };
}