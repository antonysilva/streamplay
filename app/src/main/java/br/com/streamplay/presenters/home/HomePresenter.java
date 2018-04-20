package br.com.streamplay.presenters.home;

import br.com.streamplay.presenters.ApplicationPresenter;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.briefing.interactors.GetBriefingInteractor;
import br.com.streamplaydomain.briefing.interactors.impl.GetBriefingInteractorImpl;
import br.com.streamplaydomain.entities.Briefing;
import br.com.streamplaydomain.briefing.repositories.BriefingRepository;

/**
 * Created by Antony on 09/12/2017.
 */

public class HomePresenter extends ApplicationPresenter implements HomePresenterContract, GetBriefingInteractor.Callback{

    HomePresenterContract.View mView;
    BriefingRepository mRepository;

    public HomePresenter(Executor executor, MainThread mainThread,
                         View view, BriefingRepository repository) {
        super(executor, mainThread);

        mRepository = repository;
        mView = view;
    }

    @Override
    public void getAllBriefingData() {
        GetBriefingInteractor getBriefingInteractor = new GetBriefingInteractorImpl(
                mExecutor,
                mMainThread,
                mRepository,
                this
        );

        getBriefingInteractor.execute();
    }

    @Override
    public void onGetBriefingSuccess(Briefing briefing) {
        mView.getBriefingData(briefing);
    }
}
