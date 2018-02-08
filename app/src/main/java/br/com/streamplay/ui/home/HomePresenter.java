package br.com.streamplay.ui.home;

import android.view.View;

import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydata.breafing.client.BriefingClient;
import br.com.streamplaydata.breafing.client.BriefingClientCallback;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.base.ThreadExecutor;
import br.com.streamplaydomain.briefing.interactors.BriefingInteractorCallback;
import br.com.streamplaydomain.briefing.interactors.GetBriefingInteractor;
import br.com.streamplaydomain.briefing.model.Briefing;
import br.com.streamplaydomain.briefing.repositories.BriefingRepository;

/**
 * Created by Antony on 09/12/2017.
 */

public class HomePresenter extends ApplicationPresenter implements HomePresenterContract, BriefingClientCallback{

    private BriefingRepository mBriefingRepository;
    private BriefingInteractorCallback interactorCallback;

    public HomePresenter(Executor executor, MainThread mainThread, View view, BriefingRepository repository){
        super(executor, mainThread);
        mBriefingRepository = repository;
    }

    @Override
    public void getAllBriefingData() {
//        cd stre
    }

    @Override
    public void onResponse(Briefing briefing) {
        this.interactorCallback.onGetBriefingaDataCallback(briefing);
    }

    @Override
    public void onFailure(Throwable throwable) {
        this.interactorCallback.onGetBriefingaDataFailure(throwable);
    }

}
