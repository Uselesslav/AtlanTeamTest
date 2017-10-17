package bonda.atlanteamtest.fragments.cards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bonda.atlanteamtest.R;

/**
 * Фрагмент карточки постов
 * Created by bonda on 17.10.2017.
 */
public class PostsFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static PostsFragment newInstance() {

        return new PostsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_posts, container, false);

        return rootView;
    }
}
