package bonda.atlanteamtest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bonda.atlanteamtest.R;

/**
 * Фрагмент с контактами
 * Created by bonda on 13.10.2017.
 */
public class ContactsFragment extends Fragment {
    /**
     * Передаёт параметры в фрагмент из предка
     *
     * @return фрагмент
     */
    public static ContactsFragment newInstance() {

        return new ContactsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        return rootView;
    }
}

