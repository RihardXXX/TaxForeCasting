package ru.lifehuman.taxforecasting;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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
        result_total_amount_with_VAT.setText(ResultActivity.mySplit(sumVat));//установка в макете результата
        //==========================================================================================

        //общая НДС выводим результат
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView VAT = (TextView) findViewById(R.id.VAT);
        String Vat = intent.getStringExtra(MainActivity.VAT);//приемка данных с интента
        VAT.setText(ResultActivity.mySplit(Vat));//установка в макете результата
        //==========================================================================================

        //общая сумма без НДС
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView not_VAT = (TextView) findViewById(R.id.not_VAT);
        String notVAT = intent.getStringExtra(MainActivity.TOTAL_AMOUNT_VAT);//приемка данных с интента
        not_VAT.setText(ResultActivity.mySplit(notVAT));//установка в макете результата
        //==========================================================================================

        //Процент вычета установленный юзером
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView percent_my = (TextView) findViewById(R.id.percent);
        String percent = intent.getStringExtra(MainActivity.PERSENT_SUM);
        percent_my.setText(ResultActivity.mySplit(percent) + " %");//установка в макете результата


        //==========================================================================================



        //приемка входящих данных с интента и установка его в макете
    }

    //вытод вырезания строки после точки 3 числа
    public static String mySplit(String string) {
        String str = null;
        //вырезаем после 3 числа после точки остальное
        str = String.format("%.3f", Double.parseDouble(string));
        return str;
        //сначала ставим первый пробел перед точкой.
        //находим индекс точки в строке
//        int pointPosition = string.indexOf(".");
//        //вставим первый пробел, разделив строку на две части (до и после точки) и склеив обратно.
//        string = string.substring(0, pointPosition - 3) + " " + string.substring(pointPosition - 3);
//        //теперь от пробела к началу строки ставим остальные пробелы
//        for (int i = 0; i < pointPosition / 3; i++)
//        {
//            //находим последний вставленный пробел
//            int lastSpacePosition = string.indexOf(" ");
//            //проверяем, не выйдем ли мы за пределы строки, вставляя новый. Если да - завершаем цикл.
//            if((lastSpacePosition - 3)>0)
//            {
//                string = string.substring(0, lastSpacePosition - 3) + " " + string.substring(lastSpacePosition - 3);
//            }
//            else
//            {
//                break;
//            }
//        }
//        return string;
//    }
    }

}
