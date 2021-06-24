package si.surya.holiday.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ArchieveDao {
    @Insert
    long insertArchieve(ArchieveModel archieveModel);

    @Delete
    int deleteArchieve(ArchieveModel archieveModel);

    @Query("SELECT * FROM dataArchieve")
    List<ArchieveModel> getArchieve();





}
