package bonda.atlanteamtest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bonda.atlanteamtest.R;
import bonda.atlanteamtest.fragments.cards.CommentsFragment;
import bonda.atlanteamtest.fragments.cards.PhotosFragment;
import bonda.atlanteamtest.fragments.cards.PostsFragment;
import bonda.atlanteamtest.fragments.cards.ToDosFragment;
import bonda.atlanteamtest.fragments.cards.UsersFragment;

/**
 * Фрагмент списка карточек
 * Created by bonda on 13.10.2017.
 */
public class ListCardFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static ListCardFragment newInstance() {

        return new ListCardFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_list_card, container, false);

        // Заполнение контейнеров карточек соответствующими фрагментами
        getChildFragmentManager().beginTransaction().add(R.id.fl_comments, CommentsFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_photos, PhotosFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_users, UsersFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_posts, PostsFragment.newInstance()).commit();
        getChildFragmentManager().beginTransaction().add(R.id.fl_todos, ToDosFragment.newInstance()).commit();

        return rootView;
    }
}
