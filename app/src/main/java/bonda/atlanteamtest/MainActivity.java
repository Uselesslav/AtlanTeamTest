package bonda.atlanteamtest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import bonda.atlanteamtest.adapters.TabsViewPagerAdapter;
import bonda.atlanteamtest.fragments.ContactsFragment;
import bonda.atlanteamtest.fragments.ListCardFragment;

/**
 * Главная активность приложения
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Меню вкладок
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Контейнер вкладок
        ViewPager viewPager = findViewById(R.id.view_pager);

        // Инициализацая работы с контейнером
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * Создание вкладок
     */
    private void setupViewPager(ViewPager viewPager) {
        //Инициализация адаптера
        TabsViewPagerAdapter adapter = new TabsViewPagerAdapter(this.getSupportFragmentManager());

        // Добавление вкладок
        adapter.addFragment(new ListCardFragment(), getString(R.string.name_tab_list_card));
        adapter.addFragment(new ContactsFragment(), getString(R.string.name_tab_contacts));

        // Инициализация работы с вкладками
        viewPager.setAdapter(adapter);
    }
}
