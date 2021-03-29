package com.intersekt.sharex.viewmodels;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.intersekt.sharex.views.mediaSelectionFragments.*;

public class mediaFragmentAdapter extends FragmentStateAdapter {
    public mediaFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 0 :
                return new FolderSelectionFragment();
            case 1 :
                return new VideoSelectionFragment();
            case 2:
                return new ImageSelectionFragment();
            case 3:
                return new AudioSelectionFragment();
            case 4:
                return new AppSelectionFragment();
        }

        return new AppSelectionFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
