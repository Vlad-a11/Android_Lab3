package kz.talipovsn.questionnaire;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class SecActivity extends AppCompatActivity{
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private RadioButton selectRadioButton;
    private Spinner spinner;
    private Editable Y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        // Инициализация переменных доступа к компонентам окна
        checkBox =   findViewById(R.id.checkBox1);
        radioGroup = findViewById(R.id.radioGroup);
        spinner =    findViewById(R.id.spinner);
        Y.append(String.format("%s %s \n", getString(R.string.Вы), getIntent().getStringExtra("fio")));
    }
    // МЕТОД ДЛЯ КНОПКИ "ИТОГО"
    public void onNext(View v) {
        // Создание второго окна
        Intent intent = new Intent(SecActivity.this, ResultActivity.class);
        //Intent intent = new Intent("kz.talipovsn.questionnaire.ResultActivity");

        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        // Подготовка параметров для второго окна
        intent.putExtra("edu", checkBox.isChecked() ? getString(R.string.ДА) :getString(R.string.НЕТ));
        intent.putExtra("gender", selectRadioButton.getText());
        intent.putExtra("level", spinner.getSelectedItem().toString());
        intent.putExtra("fio", Y.);

        // Запуск второго окна
        startActivity(intent);
    }
}
