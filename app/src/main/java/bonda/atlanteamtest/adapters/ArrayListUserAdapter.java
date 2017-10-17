package bonda.atlanteamtest.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bonda.atlanteamtest.R;
import bonda.atlanteamtest.models.UserModel;

/**
 * Адаптер массива пользователей
 * Created by bonda on 17.10.2017.
 */
public class ArrayListUserAdapter extends BaseAdapter {
    /**
     * Инициализация LayoutInflater
     */
    private LayoutInflater mLayoutInflater;

    /**
     * Массив пользователей
     */
    private ArrayList<UserModel> mArrayListUser;

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Использование созданных, но не использованных convertView
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_user, parent, false);
        }

        // Заполнение полей
        ((TextView) convertView.findViewById(R.id.tv_name)).setText(mArrayListUser.get(position).getName());
        ((TextView) convertView.findViewById(R.id.tv_login)).setText(mArrayListUser.get(position).getUserName());
        ((TextView) convertView.findViewById(R.id.tv_email)).setText(mArrayListUser.get(position).getEmail());
        ((TextView) convertView.findViewById(R.id.tv_city)).setText(mArrayListUser.get(position).getAddress().getCity());
        ((TextView) convertView.findViewById(R.id.tv_street)).setText(mArrayListUser.get(position).getAddress().getStreet());
        ((TextView) convertView.findViewById(R.id.tv_suite)).setText(mArrayListUser.get(position).getAddress().getSuite());

        return convertView;
    }

    public ArrayListUserAdapter(Context context, ArrayList<UserModel> arrayListUser) {
        mArrayListUser = arrayListUser;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mArrayListUser.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return mArrayListUser.get(position);
    }
}
