package si.surya.holiday.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;

import si.surya.holiday.R;
import si.surya.holiday.model.holiday.HolidaysItem;
import si.surya.holiday.view.activity.HolidayDetail;

public class HolidayDiscoverAdapter extends RecyclerView.Adapter<HolidayDiscoverAdapter.ViewHolder> {

    private ArrayList<HolidaysItem> holidaysItems = new ArrayList<>();
    private Context context;

    public HolidayDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<HolidaysItem> items){
        holidaysItems.clear();
        holidaysItems.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HolidayDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolidayDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvDate.setText(holidaysItems.get(position).getDate());
        holder.tvDay.setText(holidaysItems.get(position).getWeekday().getDate().getName());
        holder.tvName.setText(holidaysItems.get(position).getName());
        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HolidayDetail.class);
                intent.putExtra("hdDay", holidaysItems.get(position).getDate());
                intent.putExtra("hdName", holidaysItems.get(position).getName());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return holidaysItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvDate, tvName;
        CardView cvItem;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            tvDate = itemView.findViewById(R.id.date);
            tvDay = itemView.findViewById(R.id.weekday);
            tvName = itemView.findViewById(R.id.name);

        }
    }
}
