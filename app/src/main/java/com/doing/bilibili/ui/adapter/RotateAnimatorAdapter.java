package com.doing.bilibili.ui.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import jp.wasabeef.recyclerview.adapters.AnimationAdapter;

/**
 * Created by Doing on 2016/10/7 0007.
 *
 */

public class RotateAnimatorAdapter extends AnimationAdapter {

    public RotateAnimatorAdapter(RecyclerView.Adapter adapter) {
        super(adapter);
    }

    @Override
    protected Animator[] getAnimators(final View view) {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 0.5f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 0.5f, 1f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(view, "rotation", 15f, 0);
        view.setPivotX(0);
        view.setPivotY(0);

        scaleX.setDuration(300);
        scaleY.setDuration(300);
        rotate.setDuration(300);


        return new ObjectAnimator[]{scaleX, scaleY, rotate};

    }
}
