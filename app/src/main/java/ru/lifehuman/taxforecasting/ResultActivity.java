package ru.lifehuman.taxforecasting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static ru.lifehuman.taxforecasting.MainActivity.SUM_VAT;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);//загрузка шаблона

        //зацепка в шаблоне поля вывода результата
        TextView result_total_amount_with_VAT = (TextView) findViewById(R.id.result_total_amount_with_VAT);

        Intent intent = getIntent();//создание интента для приемки

        String fName = intent.getStringExtra(SUM_VAT);//приемка данных с интента

        result_total_amount_with_VAT.setText(fName);//установка в макете результата



        //приемка входящих данных с интента и установка его в макете
    }
}
