package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class QuestionViewModel extends AndroidViewModel {

    private QuestionRepository mRepository;

    private LiveData<List<Questions>> mAllQuestions;

    public QuestionViewModel(@NonNull Application application) {
        super(application);
        mRepository = new QuestionRepository(application);
        mAllQuestions = mRepository.getAllQuestions();
    }

    public LiveData<List<Questions>> getmAllQuestions() {
        return mAllQuestions;
    }

    public void insert(List<Questions> questions) {
        mRepository.insert(questions);
    }
}
