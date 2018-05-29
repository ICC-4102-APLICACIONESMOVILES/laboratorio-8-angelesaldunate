package cl.magnet.mobileappsexample.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class QuestionRepository {

    private QuestionDao mQuestionDao;
    private LiveData<List<Questions>> mAllQuestions;

    QuestionRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mQuestionDao = db.questionDao();
        mAllQuestions = mQuestionDao.getAllQuestions();
    }

    LiveData<List<Questions>> getAllQuestions() {
        return mAllQuestions;
    }

    public void insert (List<Questions> questions) {
        Questions[] questionsArray = new Questions[questions.size()];
        questionsArray = questions.toArray(questionsArray);
        new insertAsyncTask(mQuestionDao).execute(questionsArray);
    }

    private static class insertAsyncTask extends AsyncTask<Questions, Void, Void> {

        private QuestionDao mAsyncTaskDao;

        insertAsyncTask(QuestionDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Questions... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }
    }
}
