package br.com.streamplaydomain.briefing.interactors.impl;

import br.com.streamplaydomain.base.AbstractInteractor;
import br.com.streamplaydomain.base.Executor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.base.ThreadExecutor;
import br.com.streamplaydomain.briefing.callbacks.GetBriefingDataCallback;
import br.com.streamplaydomain.briefing.interactors.GetBriefingInteractor;
import br.com.streamplaydomain.briefing.model.Briefing;
import br.com.streamplaydomain.briefing.repositories.BriefingRepository;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class GetBriefingInteractorImpl extends AbstractInteractor implements GetBriefingInteractor, BriefingRepository {

    BriefingRepository mRepository;
    GetBriefingInteractor.Callback mCallback;

    public GetBriefingInteractorImpl(Executor threadExecutor, MainThread mainThread,
                                     BriefingRepository repository, Callback callback){
        super(threadExecutor, mainThread);
        this.mRepository = repository;
        this.mCallback = callback;
    }


    @Override
    public void run() {
        getBriefingData(new GetBriefingDataCallback() {
            @Override
            public void onGetBriefingDataSuccess(Briefing briefing) {
                mCallback.onGetBriefingSuccess(briefing);
            }

            @Override
            public void onError(Throwable throwable) {
                String s = "s";
            }
        });
    }

    @Override
    public void getBriefingData(GetBriefingDataCallback callback) {
        mRepository.getBriefingData(callback);
    }
}
