package si.surya.holiday.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {ArchieveModel.class}, version = 2, exportSchema = false)
public abstract class ArchieveDatabase extends RoomDatabase {

    private static ArchieveDatabase archieveDatabase;

    public abstract ArchieveDao archieveDao();

    public static ArchieveDatabase iniDatabase(Context context){
        if(archieveDatabase == null){
            archieveDatabase = Room.databaseBuilder(
                    context,
                    ArchieveDatabase.class,
                    "archieve"
            ).allowMainThreadQueries().build();
        }
        return archieveDatabase;
    }

}
