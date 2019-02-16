package ru.lifehuman.taxforecasting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Это ключи для отправки данных через интент второй активи
    //ключи для входящих лаетов
    public final static String SUM_VAT = "SUM_VAT";//сумма с ндс
    public final static String DEDUCTIONS = "DEDUCTIONS";//общие отчисления
    public final static String PERSENT_SUM = "PERSENT_SUM";//процент вычета
    public final static String INCOME_TAX = "INCOME_TAX";// налог на прибыль
    public final static String QUATERLY_TAX = "QUATERLY_TAX";// отчисления рабочих

    // ключи для исходящих лаетов
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

        //Приемка входящих данных с макета

        // Получаем текстовые поля в текущей Activity===============================================

        //общая сумма с НДС
        EditText sumVAT = (EditText) findViewById(R.id.sum_VAT);
        String sum_VAT = sumVAT.getText().toString();

        // Получение вычетов
        EditText deduction_1 = (EditText) findViewById(R.id.deduction1);
        String deduction1 = deduction_1.getText().toString();
        EditText deduction_2 = (EditText) findViewById(R.id.deduction2);
        String deduction2 = deduction_2.getText().toString();
        EditText deduction_3 = (EditText) findViewById(R.id.deduction3);
        String deduction3 = deduction_3.getText().toString();
        EditText deduction_4 = (EditText) findViewById(R.id.deduction4);
        String deduction4 = deduction_4.getText().toString();
        EditText deduction_5 = (EditText) findViewById(R.id.deduction5);
        String deduction5 = deduction_5.getText().toString();
        EditText deduction_6 = (EditText) findViewById(R.id.deduction6);
        String deduction6 = deduction_6.getText().toString();
        EditText deduction_7 = (EditText) findViewById(R.id.deduction7);
        String deduction7 = deduction_7.getText().toString();
        EditText deduction_8 = (EditText) findViewById(R.id.deduction8);
        String deduction8 = deduction_8.getText().toString();
        EditText deduction_9 = (EditText) findViewById(R.id.deduction9);
        String deduction9 = deduction_9.getText().toString();
        EditText deduction_10 = (EditText) findViewById(R.id.deduction10);
        String deduction10 = deduction_10.getText().toString();
        EditText deduction_11 = (EditText) findViewById(R.id.deduction11);
        String deduction11 = deduction_11.getText().toString();
        EditText deduction_12 = (EditText) findViewById(R.id.deduction12);
        String deduction12 = deduction_12.getText().toString();
        //инициализация массива для приема строк вычетов
        String[] strings = {deduction1,deduction2,deduction3,deduction4,deduction5,deduction6,
        deduction7,deduction8,deduction9,deduction10,deduction11,deduction12};
//
//        //Установка размера вычета НДС получаем
        EditText percent_sum = (EditText) findViewById(R.id.percent_sum);
        String percentSum = percent_sum.getText().toString();
//
//        //Налог на прибыль получаем с активити
        EditText incomex_edit = (EditText) findViewById(R.id.incomex);
        String incomex = incomex_edit.getText().toString();
//
//        //Отчисления за квартал получаем с активити
        EditText quaterly_edit = (EditText) findViewById(R.id.quarterly);
        String quaterly = quaterly_edit.getText().toString();
//
//        //==========================================================================================
//
//        //Упаковка входящих данные в объект
//        //Создаем объект
     //   VAT firstObject = new VAT(sum_VAT, strings, percentSum,incomex, quaterly);
//        //в конструкторе проходят все манипуляции с объектом
//
//        //==========================================================================================
//        //Вычисление данных и упаковка во второй объект
//        VATResult lastObject = new VATResult(firstObject);
        //в конструкторе проходят все манипуляци с объектом

        //Отправка данных во второй активи через интент
        //Не забываем превращать double строки

        // показываем что идет обработка окошко
        Toast toast = Toast.makeText(this, "Идет обработка запроса",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0,0);
        toast.show();

        Intent intent = new Intent(this, ResultActivity.class);//создание интента для отправки
        intent.putExtra(SUM_VAT,sum_VAT);
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
