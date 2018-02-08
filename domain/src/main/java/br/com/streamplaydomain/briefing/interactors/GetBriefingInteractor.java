package br.com.streamplaydomain.briefing.interactors;

import br.com.streamplaydomain.base.AbstractInteractor;
import br.com.streamplaydomain.base.MainThread;
import br.com.streamplaydomain.base.ThreadExecutor;
import br.com.streamplaydomain.briefing.model.Briefing;
import br.com.streamplaydomain.briefing.repositories.BriefingRepository;

/**
 * Created by Antony Silva on 08/02/2018.
 */

public class GetBriefingInteractor extends AbstractInteractor implements BriefingInteractorCallback {

    BriefingRepository repository;

    public GetBriefingInteractor(ThreadExecutor threadExecutor, MainThread mainThread,
                                 BriefingRepository repository){
        super(threadExecutor, mainThread);
        this.repository = repository;
    }

    @Override
    public void onGetBriefingaDataCallback(final Briefing briefing) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    @Override
    public void onGetBriefingaDataFailure(Throwable throwable) {

    }

    @Override
    public void run() {
        this.repository.getBriefingData(this);
    }
}
