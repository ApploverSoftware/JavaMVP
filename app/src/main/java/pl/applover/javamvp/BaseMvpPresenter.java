package pl.applover.javamvp;

/**
 * Created by janpawlov ( ͡° ͜ʖ ͡°) on 27/11/2017.
 */

public interface BaseMvpPresenter<V extends BaseMvpView> {
    void attachView(V view);
    void detachView();
}
