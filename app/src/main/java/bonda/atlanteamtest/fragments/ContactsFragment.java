package bonda.atlanteamtest.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import bonda.atlanteamtest.R;

/**
 * Фрагмент с контактами
 * Created by bonda on 13.10.2017.
 */
public class ContactsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Создаваемый UI
        View rootView = inflater.inflate(R.layout.fragment_contacts, container, false);

        // Текстовые поля с номером телефона и адресом электронной почты
        TextView textViewCall = rootView.findViewById(R.id.tv_contacts_call);
        TextView textViewMail = rootView.findViewById(R.id.tv_contacts_mail);

        // Обработчик нажатия на поле номера телефона
        textViewCall.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.contact_uri_string) + getString(R.string.contact_number_phone).trim()));

                // Открытие активности для звонка
                startActivity(intent);
            }
        });

        // Обработчик нажатия на поле адреса электройнной почты
        textViewMail.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(getString(R.string.contact_scheme), getString(R.string.contact_mail), null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.contact_theme_message));
                emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.contact_text_message));

                // Открытие активности с отправкой сообщения
                startActivity(Intent.createChooser(emailIntent, getString(R.string.contact_text_input_message)));
            }
        });
        return rootView;
    }
}

