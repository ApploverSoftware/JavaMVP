package pl.applover.javamvp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by janpawlov ( ͡° ͜ʖ ͡°) on 27/11/2017.
 */

public interface FragmentNavigator {

    void display(Fragment fragment, @Nullable Integer into, @Nullable Integer animIn, @Nullable Integer animOut, @Nullable String tag);

    void goBack();
}
