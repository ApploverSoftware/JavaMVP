package pl.applover.javamvp;

/**
 * Created by janpawlov ( ͡° ͜ʖ ͡°) on 27/11/2017.
 */

public abstract class BasePresenter<V extends BaseMvpView> implements BaseMvpPresenter<V> {

    protected BaseMvpView mView;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}