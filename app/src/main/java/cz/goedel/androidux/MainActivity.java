package cz.goedel.androidux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.goedel.androidux.actions.IncrementAction;
import cz.goedel.androidux.actions.LoadProcessAction;
import cz.goedel.androidux.effects.ComposedEffect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Inject
    Store store;

    @Inject
    ComposedEffect composedEffect;

    @BindView(R.id.IncrementButton)
    Button incrementButton = null;

    @BindView(R.id.LoadButton)
    Button loadButton = null;

    @BindView(R.id.TotalValue)
    TextView totalValue = null;

    @BindView(R.id.IncrementValue)
    TextView incrementValue = null;

    @BindView(R.id.Message)
    TextView message = null;

    private CompositeDisposable subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        App.getComponent(this).inject(this);

        RxView.clicks(incrementButton)
                .subscribe(c -> {
                    int val = new Integer(incrementValue.getText().toString());

                    store.dispatch(new IncrementAction(val));
                });

        RxView.clicks(loadButton)
                .subscribe(c -> {
                    store.dispatch(new LoadProcessAction());
                });
    }

    @Override
    protected void onStart() {
        super.onStart();

        subscription = new CompositeDisposable();

        Disposable dsp = store.getState()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    totalValue.setText(s.getNumber() + "");
                });

        subscription.add(dsp);

        dsp = store.isLoading()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loading -> {
                    message.setText(loading ? "loading": "ready");
                });

        subscription.add(dsp);

        composedEffect.register();
    }


    @Override
    protected void onStop() {
        super.onStop();

        if (!subscription.isDisposed()) {
            subscription.dispose();
        }

        composedEffect.unregister();
    }
}
