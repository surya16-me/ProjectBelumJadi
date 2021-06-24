package si.surya.holiday.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import si.surya.holiday.R;
import si.surya.holiday.database.ArchieveDatabase;
import si.surya.holiday.database.ArchieveModel;
import si.surya.holiday.view.fragment.NoteList;

public class ArchieveAdapter extends RecyclerView.Adapter<ArchieveAdapter.ViewHolder> {
    private ArrayList<ArchieveModel> archieveitems = new ArrayList<>();
    private Context context;
    private ArchieveDatabase archieveDatabase;

    public ArchieveAdapter(Context context){

        this.context = context;
        archieveDatabase = ArchieveDatabase.iniDatabase(this.context);
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
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    ArchieveModel archieveModel = new ArchieveModel();

                    archieveModel.setTanggal(archieveitems.get(position).getTanggal());
                    archieveModel.setHoliday(archieveitems.get(position).getHoliday());
                    archieveModel.setId(archieveitems.get(position).getId());

                    archieveDatabase.archieveDao().deleteArchieve(archieveModel);
                    Log.d("ArchieveAdapter","Sukses Menghapus");
                    Toast.makeText(context, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Log.e("ArchieveAdapterr","Gagal Menghapus Data, msg :" +ex.getMessage());
                    Toast.makeText(context, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return archieveitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggal, holiday;
        ImageView delete;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            tanggal = itemView.findViewById(R.id.tanggal_db);
            holiday = itemView.findViewById(R.id.hari_besar_db);
            delete = itemView.findViewById(R.id.delete_btn);

        }
    }
}
