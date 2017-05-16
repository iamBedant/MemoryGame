package io.iamBedant.starter.ui.game;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.ArrayList;

import io.iamBedant.starter.data.remote.model.game.Logo;


/**
 * Created by @iamBedant on 11/05/17.
 */

public class GameDiffUtilCallback extends DiffUtil.Callback {
    ArrayList<Logo> newList;
    ArrayList<Logo> oldList;

    public GameDiffUtilCallback(ArrayList<Logo> newList, ArrayList<Logo> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList != null ? oldList.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return newList != null ? newList.size() : 0;
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return true;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
//        Log.d("diffutilcheck", "Same : "+newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition)));
        int result = newList.get(newItemPosition).compareTo(oldList.get(oldItemPosition));
        if (result == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        Logo newLogo = newList.get(newItemPosition);
        Logo oldLogo = oldList.get(oldItemPosition);
        Bundle diff = new Bundle();
        if (!newLogo.getHidden() == oldLogo.getHidden()) {
            diff.putBoolean("isHidden", newLogo.getHidden());
        }
        if (diff.size() == 0) {
            return null;
        }
        return diff;
    }
}