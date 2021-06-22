package si.surya.holiday.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import si.surya.holiday.R;
import si.surya.holiday.database.ArchieveModel;

public class ArchieveAdapter extends RecyclerView.Adapter<ArchieveAdapter.ViewHolder> {
    private ArrayList<ArchieveModel> archieveitems = new ArrayList<>();
    private Context context;

    public ArchieveAdapter(Context context){
        this.context = context;
    }
    public void setData(ArrayList<ArchieveModel> items){
        archieveitems.clear();
        archieveitems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_load, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArchieveAdapter.ViewHolder holder, int position) {
        holder.tanggal.setText(archieveitems.get(position).getTanggal());
        holder.holiday.setText(archieveitems.get(position).getHoliday());
    }

    @Override
    public int getItemCount() {
        return archieveitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal, holiday;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.tanggal_db);
            holiday = itemView.findViewById(R.id.hari_besar_db);
        }
    }
}
