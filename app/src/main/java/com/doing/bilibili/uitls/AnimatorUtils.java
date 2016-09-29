package com.doing.bilibili.uitls;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

import rx.functions.Action3;

/**
 * Created by Doing on 2016/9/29.
 *
 */
public class AnimatorUtils {

    public void setOpenAnimator(final View view, int duration, final int closeHeight, int openHeight) {
        setSwitchAnimaor(view, duration, closeHeight, openHeight, new Action3<ViewGroup.LayoutParams, Float, Float>() {
            @Override
            public void call(ViewGroup.LayoutParams params, Float acceleration, Float time) {
                params.height = closeHeight + (int) (0.5f * acceleration * time * time);
            }
        });
    }

    public void setCloseAnimator(final View view, int duration, int closeHeight, final int openHeight) {
        setSwitchAnimaor(view, duration, closeHeight, openHeight, new Action3<ViewGroup.LayoutParams, Float, Float>() {
            @Override
            public void call(ViewGroup.LayoutParams params, Float acceleration, Float time) {
                params.height = openHeight - (int) (0.5f * acceleration * time * time);
            }
        });
    }

    public void setRotateAnimator(View view,int duration, float start, float end) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", start, end);
        animator.setDuration(duration);
        animator.start();
    }


    private ValueAnimator setSwitchAnimaor(final View view, int duration, int closeHeight,
                                           final int openHeight, final Action3<ViewGroup.LayoutParams,Float,Float> action3) {
        float durationF = (float)duration / 1000.f;
        ValueAnimator animator = ValueAnimator.ofFloat(0, durationF);
        animator.setTarget(view);
        animator.setDuration((long) (duration));
        final ViewGroup.LayoutParams params = view.getLayoutParams();
        final float acceleration = (openHeight - closeHeight) * 2 / (durationF * durationF);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float time = (float) animation.getAnimatedValue();
                action3.call(params, acceleration, time);
                view.setLayoutParams(params);
            }
        });
        animator.start();
        return animator;
    }
}
