package com.match.maker.featureModules.landing.views;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.match.maker.db.tables.MatchingUsersTable;
import com.match.maker.featureModules.landing.repo.HomeActivityRepository;

import javax.inject.Inject;

/**
 * Created by ravindra on 17,January,2019
 */
public class HomeActivityViewModel extends AndroidViewModel {


    @Inject
    HomeActivityRepository repository;


    // get matches result
    private MutableLiveData<MatchingUsersTable> allMatchesData = new MutableLiveData<>();
    private MutableLiveData<Throwable> allMatchesDataError = new MutableLiveData<>();


    public HomeActivityViewModel(@NonNull Application application) {
        super(application);
    }

    // get matches result
    public void getAllMatches(int count) {
        repository.getAllMatches(count, allMatchesData, allMatchesDataError);
    }

    public MutableLiveData<MatchingUsersTable> getAllMatchesData() {
        return allMatchesData;
    }

    public MutableLiveData<Throwable> getAllMatchesDataError() {
        return allMatchesDataError;
    }

    //
    public LiveData<MatchingUsersTable> getDataFromDb() {
        return repository.getMatchingDataFromDb();
    }

    //
    public LiveData<Integer> getDbDataCount() {
        return repository.getMatchingDataDbCount();
    }

}
