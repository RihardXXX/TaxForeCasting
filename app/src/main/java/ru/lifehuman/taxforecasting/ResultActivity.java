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

        //общая сумма с НДС выводим результат
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView result_total_amount_with_VAT = (TextView) findViewById(R.id.result_total_amount_with_VAT);
        Intent intent = getIntent();//создание интента для приемки
        String sumVat = intent.getStringExtra(MainActivity.SUM_VAT);//приемка данных с интента
        result_total_amount_with_VAT.setText(sumVat);//установка в макете результата
        //==========================================================================================

        //общая НДС выводим результат
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView VAT = (TextView) findViewById(R.id.VAT);
        String Vat = intent.getStringExtra(MainActivity.VAT);//приемка данных с интента
        VAT.setText(Vat);//установка в макете результата
        //==========================================================================================

        //общая сумма без НДС
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView not_VAT = (TextView) findViewById(R.id.not_VAT);
        String notVAT = intent.getStringExtra(MainActivity.TOTAL_AMOUNT_VAT);//приемка данных с интента
        not_VAT.setText(notVAT);//установка в макете результата
        //==========================================================================================



        //приемка входящих данных с интента и установка его в макете
    }
}
