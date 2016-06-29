package lenka.example.com.vkapp.activities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import lenka.example.com.vkapp.R;
import lenka.example.com.vkapp.fragments.LoginFragment;
import lenka.example.com.vkapp.fragments.MainMenuFragment;

public class MainActivity extends FragmentActivity {


    private boolean isResumed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VKSdk.wakeUpSession(this, new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                if (isResumed) {
                    switch (res) {
                        case LoggedOut:
                            showLoginView();
                            break;
                        case LoggedIn:
                            showMainMenuView();
                            break;
                    }
                }
            }

            @Override
            public void onError(VKError error) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isResumed = true;
        if (VKSdk.isLoggedIn()) {
            showMainMenuView();
        } else {
            showLoginView();
        }
    }

    @Override
    protected void onPause() {
        isResumed = false;
        super.onPause();
    }

    public void showLoginView(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_view, new LoginFragment())
                .commitAllowingStateLoss();
    }

    public void showMainMenuView(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_view, new MainMenuFragment())
                .commitAllowingStateLoss();
    }
}
