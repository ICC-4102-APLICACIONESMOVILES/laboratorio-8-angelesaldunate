package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class AnswerViewModel extends AndroidViewModel {

    private AnswerRepository mRepository;

    private LiveData<List<Answer>> mAllAnswer;

    public AnswerViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AnswerRepository(application);
        mAllAnswer = mRepository.getmAllAwnser();
    }

    public LiveData<List<Answer>> getmAllAnswer() {
        return mAllAnswer;
    }

    public void insert(List<Answer> answers) {
        mRepository.insert(answers);
    }
}
