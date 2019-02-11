package ru.lifehuman.taxforecasting;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class VAT {
    private double totalAmountWithVAT;//общая сумма с НДС
    private double deductionsWithVAT;//вычеты с НДС
    private float percentDeductionVAT;//проценты вычетов НДС
    private double incomeTax;//налог на прибыль
    private double quarterlyDeduction;//отчисления за квартал

    //Конструктор который упаковывает все данные в объект
    public VAT(String totalAmountWithVAT, String[] deductionsWithVAT, String percentDeductionVAT, String incomeTax, String quarterlyDeduction) {
        ArrayList<Double> list = new ArrayList<>();//список для приема данных
        this.totalAmountWithVAT = VAT.getDoubleToString(totalAmountWithVAT);//строку превращаем в double
        list = VAT.getFullArrayList(deductionsWithVAT);//массив строк превращаем в список
        this.deductionsWithVAT = VAT.getDoubleForArraylist(list);//метод складывающий все элементы коллекции
        this.percentDeductionVAT = VAT.getFloatToString(percentDeductionVAT);//превращаем строку в folat
        this.incomeTax = VAT.getDoubleToString(incomeTax);//налог на прибыль строку преврвщаем в double
        this.quarterlyDeduction = VAT.getDoubleToString(quarterlyDeduction);//превращаем отчисления в строку
    }

    public static double getDoubleToString(String string){
        return Double.parseDouble(VAT.getStringReplaceOnDot(string));//превращаем строку в double
    }

    public static float getFloatToString(String string){
        return Float.parseFloat(VAT.getStringReplaceOnDot(string));//превращаем строку в float
    }

    public static String getStringReplaceOnDot(String string){
        String str;
        return str = string.replaceAll(",",".");//заменя всех запятых на точки
    }

    //метод принимающий массив строк и превращающий его в коллекцию
    public static ArrayList<Double> getFullArrayList(String[] strList){
        ArrayList<Double> list = new ArrayList<>();//создаем коллекцию
        for (int i = 0; i < strList.length; i++){//проходимся циклом по массиву
            if (strList[i] != null) {//если элемент массива не пустой проверка на нул
                list.add(VAT.getDoubleToString(VAT.getStringReplaceOnDot(strList[i])));//
            }
        }// превращаем строку в строку без запятых превращаем в double и кладем в коллекцию
        return list;//возвращаем коллекцию с вычетами
    }

    //метод складывающий элементы коллекции double и возвращающий итоговый результат
    public static double getDoubleForArraylist(ArrayList<Double> list){
        double sum = 0;
        for (double i : list) {
            sum += i;
        }
        return sum;
    }

    //Метод превращающий числа в строки
    public static String getStringForDouble(double number){
        String string = null;
        return string = Double.toString(number);
    }

    //Метод превращающий числа в строки
    public static String getStringForFloat(float number){
        String string = null;
        return string = Float.toString(number);
    }

    public double getTotalAmountWithVAT() {
        return totalAmountWithVAT;
    }

    public double getDeductionsWithVAT() {
        return deductionsWithVAT;
    }

    public float getProcentDeductionVAT() {
        return percentDeductionVAT;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public double getQuarterlyDeduction() {
        return quarterlyDeduction;
    }

}
