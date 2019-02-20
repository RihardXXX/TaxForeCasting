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
//    public VAT(String totalAmountWithVAT, String[] deductionsWithVAT, String percentDeductionVAT, String incomeTax, String quarterlyDeduction) {
//
//        this.totalAmountWithVAT = VAT.getDoubleToString(VAT.getStringReplaceOnDot(totalAmountWithVAT));//строку превращаем в double
//
//        ArrayList<Double> list = new ArrayList<>();//список для приема данных
//        list = VAT.getFullArrayList(deductionsWithVAT);//массив строк превращаем в список double
//        this.deductionsWithVAT = VATResult.getResultVAT(VAT.getDoubleForArraylist(list));
//        //метод складывающий все элементы коллекции а результат узнаем ндс с вычетов
//
//        this.percentDeductionVAT = VAT.getFloatToString(VAT.getStringReplaceOnDot(percentDeductionVAT));//превращаем строку в folat
//        this.incomeTax = VAT.getDoubleToString(VAT.getStringReplaceOnDot(incomeTax));//налог на прибыль строку преврвщаем в double
//        this.quarterlyDeduction = VAT.getDoubleToString(VAT.getStringReplaceOnDot(quarterlyDeduction));//превращаем отчисления в строку
//    }

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

    public double getTotalAmountWithVAT() {
        return totalAmountWithVAT;
    }

    public double getDeductionsWithVAT() {
        return deductionsWithVAT;
    }

    public float getPercentDeductionVAT() {
        return percentDeductionVAT;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public double getQuarterlyDeduction() {
        return quarterlyDeduction;
    }

    //кладем общую сумму с ндс в объект
    public void setTotalAmountWithVAT(String totalAmountWithVAT) {
//        if (totalAmountWithVAT != null) {
//            this.totalAmountWithVAT = VAT.getDoubleToString(totalAmountWithVAT);
//        }
        if (!totalAmountWithVAT.isEmpty()){
            this.totalAmountWithVAT = VAT.getDoubleToString(totalAmountWithVAT);
        }
        else {
            this.totalAmountWithVAT = VAT.getDoubleToString("0");
        }
    }

    //кладем в свойства объекта данные проверка на пустоту процент вычета
    public void setPercentDeductionVAT(String percentDeductionVAT) {
        if (!percentDeductionVAT.isEmpty()) {
            this.percentDeductionVAT = VAT.getFloatToString(percentDeductionVAT);
        }
        else {
            this.percentDeductionVAT = VAT.getFloatToString("0");
        }
    }

    //кладем налог на прибыль в свойтсво объекта
    public void setIncomeTax(String incomeTax) {
        if (!incomeTax.isEmpty()){
            this.incomeTax = VAT.getDoubleToString(incomeTax);
        }
        else {
            this.incomeTax = VAT.getDoubleToString("0");
        }
    }

    //отчисления за квартал полученные данные кладем в свойство объекта
    public void setQuarterlyDeduction(String quarterly) {
        if (!quarterly.isEmpty()){
            this.quarterlyDeduction = VAT.getDoubleToString(quarterly);
        }
        else{
            this.quarterlyDeduction = VAT.getDoubleToString("0");
        }
    }
}
