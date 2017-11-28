# JavaMVP
This lib allows you to arrange your application Fragments in MVP convention.

Bind your Fragments and their Presenters with Contract, so the methods they are using to communicate with themselves are transparent and in one place.

To do so, first write a binding contract:

```java
public interface ExampleContract {
    interface View extends BaseMvpView {
        //here, declare methods that will be used to cummunicate with the view
    }

    interface Presenter extends BaseMvpPresenter<View> {
        //methods declared here will be used to communicate with the presenter
    }
}
```

Then, create a Presenter. It should look like this:

```java
public class ExamplePresenter extends BasePresenter<ExampleContract.View> implements ExampleContract.Presenter {

  //Here, you need to implement every method declared in ExampleContract.Presenter
}
```

To communicate presenter with binded view, simply call from within presenter: 

```java
((TestFragmentContract.View) mView)//call whatever method you declared in ExampleContract.View
```

Finally, extend BaseFragment to create your fragment:

```java
public class ExampleFragment extends BaseFragment<ExampleContract.View, ExampleContract.Presenter> implements ExampleContract.View {

    @Override
    public void initializePresenter(TestFragmentContract.Presenter mPresenter) {
        this.mPresenter = mPresenter; //remember to store presenter reference
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initializePresenter(new TestPresenter()); // this MUST be called before super();
        super.onCreate(savedInstanceState);
    }
}
