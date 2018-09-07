package com.bessermt.trisolve.feature;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ReflectActionProvider extends ActionProvider {

    private Context context_;

    ReflectActionProvider(Context context) {
        super(context);
        context_ = context;
    }

    @Override
    public View onCreateActionView() {
        // TODO: Implement this method. This is just a stub from the docs.
        // Inflate the action provider to be shown on the action bar.
        LayoutInflater layoutInflater = LayoutInflater.from(context_);
        View providerView =
                layoutInflater.inflate(R.layout.action_provider_reflect, null);
        Button reflect_button =
                providerView.findViewById(R.id.btn_reflect);
        reflect_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something...
            }
        });
        return providerView;
    }

    @Override
    public boolean onPerformDefaultAction() {
        final boolean result = super.onPerformDefaultAction();
        return result;
    }
}
