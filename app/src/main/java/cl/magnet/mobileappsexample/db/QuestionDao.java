package cl.magnet.mobileappsexample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface QuestionDao {

    @Query("SELECT * FROM questions")
    LiveData<List<Questions>> getAllQuestions();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Questions... questions);

    @Query("DELETE FROM questions")
    void deleteAll();
}
