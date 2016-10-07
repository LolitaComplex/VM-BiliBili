package com.doing.bilibili.uitls;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.v4.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Doing on 2016/10/7 0007.
 *
 * Helper class for creating content transitions used with {@link android.app.ActivityOptions}.

 *
 */

public class TransitionHelper {

    /**
     * Create the transition participants required during a activity transition while
     * avoiding glitches with the system UI.
     *
     * @param activity The activity used as start for the transition.
     * @param includeStatusBar If false, the status bar will not be added as the transition
     *        participant.
     * @return All transition participants.
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static Pair[] createSafeTrianstionParticipants(
            Activity activity, boolean includeStatusBar, Pair... otherParticipants) {

        View decor = activity.getWindow().getDecorView();

        View statusBar = null;
        if (includeStatusBar) {
            statusBar = decor.findViewById(android.R.id.statusBarBackground);
        }

        View navBar = decor.findViewById(android.R.id.navigationBarBackground);

        List<Pair> participants = new ArrayList<>(3);
        addNonNullViewToTranstionParticipants(statusBar, participants);
        addNonNullViewToTranstionParticipants(navBar, participants);

        if (otherParticipants != null && !(otherParticipants.length == 1 && otherParticipants[0] == null)) {
            participants.addAll(Arrays.asList(otherParticipants));
        }


        return participants.toArray(new Pair[participants.size()]);
    }


    private static void addNonNullViewToTranstionParticipants(View view, List<Pair> participants) {
        if (view == null) {
            return;
        }

        participants.add(new Pair<>(view,view.getTransitionName()));
    }
}
