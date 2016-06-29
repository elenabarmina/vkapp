package lenka.example.com.vkapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.vk.sdk.VKSdk;

import lenka.example.com.vkapp.R;
import lenka.example.com.vkapp.activities.MainActivity;

/**
 * Created by Lenka on 28.06.2016.
 */
public class MainMenuFragment extends android.support.v4.app.Fragment {
    public MainMenuFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        v.findViewById(R.id.logout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VKSdk.logout();
                if (!VKSdk.isLoggedIn()) {
                    ((MainActivity) getActivity()).showLoginView();
                }
            }
        });

        return v;
    }
}
