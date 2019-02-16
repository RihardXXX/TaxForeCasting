package ru.lifehuman.taxforecasting;

public class VATResult {
    
    private double vat;//НДС
    private double totalAmountNotVat;//сумма без НДС
    private double deductionSumVAT;//сумма вычетов по НДС необходимо
    private float percentBalans;// тот остаток процента ндс с которого мы будем платить ндс
    private double totalVATToPay;//Ндс необходимый оплатить
    private double totalAmountVATAndIncomeTax;//общая сума НДС и налога на прибыль
    private float taxBurdenPercent;//налоговая нагрузка в процентах
    private float taxBurdenWithQuarterly;//налоговая нагрузка с отчислениями
    private double toPayVAT;//к оплате НДС
    private double mustCollectDeductions;//необходимо набрать вычетов
    private double mustList;// необходимо еще перечислить

    private VAT firstObject;//объект класса VAT в который будут классататься входящие данные

    //Конструктор в который будет класться объект типа VAT от которого будут изменяться данные
//    public VATResult(VAT firstObject) {
//        this.firstObject = firstObject;//кладем в свойство объект первый
//        this.vat = VATResult.getResultVAT(firstObject.getTotalAmountWithVAT());//вычисляем ндс с общей суммы пришедшей
//        this.totalAmountNotVat = VATResult.getResultNotVAT(firstObject.getTotalAmountWithVAT(),vat);//вычисляем сумму без ндс
//        this.deductionSumVAT = VATResult.getPercentVAT(firstObject.getProcentDeductionVAT(),vat);//
//        this.percentBalans = 100 - firstObject.getProcentDeductionVAT();//узнаем остаток процента с которого будем платить ндс
//        this.totalVATToPay = VATResult.getPercentVAT(this.percentBalans,vat);// считаем ндс который необходимо оплатить
//        this.totalAmountVATAndIncomeTax = this.vat + firstObject.getIncomeTax();//НДС + налог на прибыль
//        //
//    }

    //Формула подсчета НДС с вычетов
    public double getResultVAT(String number){
        return this.vat = (VAT.getDoubleToString(number) * 20) / 120;
    }

    //Формула суммы без ндс
    public static double getResultNotVAT(double totalAmounth, double vat){
        return totalAmounth - vat;
    }

    //Формула необходимо оплатить ндс с указанным процентом вычета
    public static double getPercentVAT(float percent, double vat){
        return (vat * percent) / 100;
    }



    public VAT getFirstObject() {
        return firstObject;
    }

    public double getVat() {
        return vat;
    }

    public double getTotalAmountNotVat() {
        return totalAmountNotVat;
    }

    public double getDeductionSumVAT() {
        return deductionSumVAT;
    }

    public double getTotalVATToPay() {
        return totalVATToPay;
    }

    public double getTotalAmountVATAndIncomeTax() {
        return totalAmountVATAndIncomeTax;
    }

    public float getTaxBurdenPercent() {
        return taxBurdenPercent;
    }

    public float getTaxBurdenWithQuarterly() {
        return taxBurdenWithQuarterly;
    }

    public double getToPayVAT() {
        return toPayVAT;
    }

    public double getMustCollectDeductions() {
        return mustCollectDeductions;
    }

    public double getMustList() {
        return mustList;
    }

    public float getPercentBalans() {
        return percentBalans;
    }


}
