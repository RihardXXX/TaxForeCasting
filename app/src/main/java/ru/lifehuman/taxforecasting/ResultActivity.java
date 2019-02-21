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
        result_total_amount_with_VAT.setText(" = " + ResultActivity.mySplit(sumVat));//установка в макете результата
        //==========================================================================================

        //общая НДС выводим результат
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView VAT = (TextView) findViewById(R.id.VAT);
        String Vat = intent.getStringExtra(MainActivity.VAT);//приемка данных с интента
        VAT.setText(" = " + ResultActivity.mySplit(Vat));//установка в макете результата
        //==========================================================================================

        //общая сумма без НДС
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView not_VAT = (TextView) findViewById(R.id.not_VAT);
        String notVAT = intent.getStringExtra(MainActivity.TOTAL_AMOUNT_VAT);//приемка данных с интента
        not_VAT.setText(" = " + ResultActivity.mySplit(notVAT));//установка в макете результата
        //==========================================================================================

        //Процент вычета установленный юзером
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView percent_my = (TextView) findViewById(R.id.percent);
        String percent = intent.getStringExtra(MainActivity.PERSENT_SUM);
        percent_my.setText(ResultActivity.mySplit(percent) + " %  = ");//установка в макете результата
        //==========================================================================================

        //общая сумма вычетов НДС согласно введенных данных юзером
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView result_deduction_with_VAT = (TextView) findViewById(R.id.result_deduction_with_VAT);
        String resultDeductionWithVAT = intent.getStringExtra(MainActivity.DEDUCTION_TOTAL_VAT);//приемка данных с интента
        result_deduction_with_VAT.setText(ResultActivity.mySplit(resultDeductionWithVAT));//установка в макете результата
        //==========================================================================================

        //зацепка в шаблоне поля вывода результата
        TextView percent_VAT = (TextView) findViewById(R.id.percent_VAT);//цепляем шаблог
        String percentVAT = intent.getStringExtra(MainActivity.DEDUCTION_TOTAL_PERCENT);//принимаем данные с первой активи по ключу
        percent_VAT.setText(ResultActivity.mySplit(percentVAT) + " % = ");//установка в макете результата
        //==========================================================================================

        //зацепка в шаблоне поля вывода результата
        TextView result_money_with_VAT = (TextView) findViewById(R.id.result_money_with_VAT);
        String resultMoneyWithVAT = intent.getStringExtra(MainActivity.VAT_TOTAL_TO_PAY);//приемка данных с интента
        result_money_with_VAT.setText(ResultActivity.mySplit(resultMoneyWithVAT));//установка в макете результата
        //==========================================================================================


        //общая сумма ндс и налога на прибыль
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView VAT_and_income = (TextView) findViewById(R.id.VAT_and_income);
        String VATAndIncome = intent.getStringExtra(MainActivity.TOTAL_AMOUNTH_VAT_INCOME_TAX);//приемка данных с интента
        VAT_and_income.setText(" = " + ResultActivity.mySplit(VATAndIncome));//установка в макете результата
        //==========================================================================================

        //Налоговая нагрузка в процентах
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView tax_burden_percent = (TextView) findViewById(R.id.tax_burden_percent);
        String taxBurdenPercent = intent.getStringExtra(MainActivity.TAX_BURDEN_PERCENT);
        tax_burden_percent.setText(" = " + ResultActivity.mySplit(taxBurdenPercent));//установка в макете результата
        //==========================================================================================

        //Налоговая нагрузка в процентах в составе имеются отчисления
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView tax_burden_percent_worker = (TextView) findViewById(R.id.tax_burden_percent_worker);
        String taxBurdenPercentWorker = intent.getStringExtra(MainActivity.TAX_BURDEN_WITH_QUATERLY);
        tax_burden_percent_worker.setText("= " + ResultActivity.mySplit(taxBurdenPercentWorker));//установка в макете результата
        //==========================================================================================

        //Отчисления за рабочих выводим результат
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView quarterly_deductions_money = (TextView) findViewById(R.id.quarterly_deductions_money);
        String quarterlyDeductionsMoney = intent.getStringExtra(MainActivity.QUATERLY_TAX);//приемка данных с интента
        quarterly_deductions_money.setText("= " + ResultActivity.mySplit(quarterlyDeductionsMoney));//установка в макете результата
        //==========================================================================================

        //Сумма всех вычетов по НДС
        //==========================================================================================
        //зацепка в шаблоне поля вывода результата
        TextView total_sum_money_VAT = (TextView) findViewById(R.id.total_sum_money_VAT);
        String totalSumMoneyVAT = intent.getStringExtra(MainActivity.DEDUCTIONS);//приемка данных с интента
        total_sum_money_VAT.setText("= " + ResultActivity.mySplit(totalSumMoneyVAT));//установка в макете результата
        //==========================================================================================
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
