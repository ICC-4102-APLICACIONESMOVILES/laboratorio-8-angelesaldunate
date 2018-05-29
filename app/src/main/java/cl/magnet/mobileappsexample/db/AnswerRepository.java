package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AnswerRepository {

    private AnswerDao mAwnserDao;
    private LiveData<List<Answer>> mAllAwnser;

    AnswerRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mAwnserDao = db.answerDao();
        mAllAwnser = mAwnserDao.getAllAnwser();
    }

    LiveData<List<Answer>> getmAllAwnser() {
        return mAllAwnser;
    }

    public void insert (List<Answer> answers) {
        Answer[] answersArray = new Answer[answers.size()];
        answersArray = answers.toArray(answersArray);
        new insertAsyncTask(mAwnserDao).execute(answersArray);
    }

    private static class insertAsyncTask extends AsyncTask<Answer, Void, Void> {

        private AnswerDao mAsyncTaskDao;

        insertAsyncTask(AnswerDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Answer... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}
