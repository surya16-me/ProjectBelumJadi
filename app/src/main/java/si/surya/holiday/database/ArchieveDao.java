package si.surya.holiday.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArchieveDao {
    @Insert
    long insertArchieve(ArchieveModel archieveModel);

    @Query("SELECT * FROM dataArchieve")
    List<ArchieveModel> getArchieve();
}
