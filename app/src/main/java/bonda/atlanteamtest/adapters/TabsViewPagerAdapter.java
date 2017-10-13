package bonda.atlanteamtest.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, работающий с вкладками
 */
public class TabsViewPagerAdapter extends FragmentPagerAdapter {
    /**
     * Массив фрагментов
     */
    private final List<Fragment> mFragmentList = new ArrayList<>();

    /**
     * Массив заголовков
     */
    private final List<String> mFragmentTitleList = new ArrayList<>();

    /**
     * Конструктор
     *
     * @param fragmentManager менеджер управления фрагментами
     */
    public TabsViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    /**
     * Добавление фрагмента в вкладку
     *
     * @param fragment фрагмент
     * @param title    заголовок вкладки
     */
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
}