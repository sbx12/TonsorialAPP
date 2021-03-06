package com.conversion.sbx.barbershop;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;

import com.bumptech.glide.Glide;

public class ProductFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        transitionAction(container);
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        super.onViewCreated(view, savedInstanceState);
        View productBanner = view.findViewById(R.id.productBanner);
        TextView textView = productBanner.findViewById(R.id.tv_backgroundText);
        ImageView imageView = productBanner.findViewById(R.id.iv_backgroundImage);

        textView.setText(R.string.product);
        Glide.with(getContext()).load(R.drawable.productspic).into(imageView);
    }

    private void transitionAction(ViewGroup viewGroup){
        viewGroup.setVisibility(View.INVISIBLE);
        TransitionSet set = new TransitionSet()
                .addTransition(new Slide(Gravity.LEFT))
                .setDuration(400);
        TransitionManager.beginDelayedTransition(viewGroup, set);
        viewGroup.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Glide.get(getContext()).clearMemory();
        getFragmentManager().beginTransaction().remove(ProductFragment.this).commitAllowingStateLoss();
    }
}
