package pl.applover.javamvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by janpawlov ( ͡° ͜ʖ ͡°) on 27/11/2017.
 */

public abstract class BaseFragment<V extends BaseMvpView, P extends BaseMvpPresenter<V>> extends Fragment implements BaseMvpView {

    public P mPresenter;
    protected FragmentNavigator navigator;
    protected AppCompatActivity contextActivity;

    @SuppressWarnings("UNCHECKED_CAST")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView((V)this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    public abstract void initializePresenter(P mPresenter);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        contextActivity= getBaseActivity(this);

        if(contextActivity instanceof FragmentNavigator)
            navigator= ((FragmentNavigator) contextActivity);
        else
            throw new ClassCastException(contextActivity.toString()+ " must implement FragmentNavigator");

    }

    private AppCompatActivity getBaseActivity(Fragment fragment){
        if(!(fragment.getActivity() instanceof AppCompatActivity))
            throw new ClassCastException(fragment.getActivity().toString() + " must extend AppCompatActivity");
        if(fragment.getActivity()==null)
            return getBaseActivity(fragment.getParentFragment());
        else
            return ((AppCompatActivity) fragment.getActivity());
    }
}
