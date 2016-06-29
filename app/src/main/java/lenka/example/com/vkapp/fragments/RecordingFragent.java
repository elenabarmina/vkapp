package lenka.example.com.vkapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import lenka.example.com.vkapp.R;

/**
 * Created by Lenka on 28.06.2016.
 */
public class RecordingFragent extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_record, container, false);

        v.findViewById(R.id.recording_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "recorging started", Toast.LENGTH_SHORT);
            }
        });

        return v;
    }
}
