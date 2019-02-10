package ru.lifehuman.taxforecasting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Это ключи для отправки данных через интент второй активи
    //ключи для входящих активити
    public final static String SUM_VAT = "SUM_VAT";//сумма с ндс
    public final static String DEDUCTIONS = "DEDUCTIONS";//общие отчисления
    public final static String PERSENT_SUM = "PERSENT_SUM";//процент вычета
    public final static String INCOME_TAX = "INCOME_TAX";// налог на прибыль
    public final static String QUATERLY_TAX = "QUATERLY_TAX";// отчисления рабочих

    // ключи для исходящих активи
    public final static String VAT = "VAT";//НДС
    public final static String TOTAL_AMOUNT_VAT = "TOTAL_AMOUNT_VAT";//сумма без НДС
    public final static String DEDUCTION_TOTAL_VAT = "DEDUCTION_TOTAL_VAT";//сумма вычетов по НДС
    public final static String VAT_TOTAL_TO_PAY = "VAT_TOTAL_TO_PAY";//Ндс необходимый оплатить
    public final static String TOTAL_AMOUNTH_VAT_INCOME_TAX = "TOTAL_AMOUNTH_VAT_INCOME_TAX";//общая сума НДС и налога на прибыль
    public final static String TAX_BURDEN_PERCENT = "TAX_BURDEN_PERCENT";//налоговая нагрузка в процентах
    public final static String TAX_BURDEN_WITH_QUATERLY = "TAX_BURDEN_WITH_QUATERLY";//налоговая нагрузка с отчислениями
    public final static String TO_PAY_VAT = "TO_PAY_VAT";//к оплате НДС
    public final static String MUST_COLLECT_DEDUCTIONS = "MUST_COLLECT_DEDUCTIONS";//необходимо набрать вычетов
    public final static String MUST_LIST = "MUST_LIST";// необходимо еще перечислить





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toCalculate(View view){
        Intent intent = new Intent(this, ResultActivity.class);//создание интента для отправки

        //Упаковка входящих данные в объект
        String[] strings = new String[12];//массив для приема строк вычетов



        //Вычисление данных и упаковка во второй объект



        //Отправка данных во второй активи через интент




        startActivity(intent);
    }

    //Упаковка первых данных объекта VAT
    public ArrayList<Double> packagingFirstVAT(){
        ArrayList<Double> newList = new ArrayList<>();
        return  newList;
    }

    //Упаковка вторых данных объекта VATResult
    public ArrayList<Double> packagingLastVAT(){
        ArrayList<Double> newList = new ArrayList<>();
        return  newList;
    }
}
