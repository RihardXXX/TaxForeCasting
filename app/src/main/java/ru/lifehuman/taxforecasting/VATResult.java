package ru.lifehuman.taxforecasting;

public class VATResult {

    private double vat;//НДС
    private double totalAmountNotVat;//сумма без НДС
    private double deductionSumVAT;//сумма вычетов по НДС необходимо
    private float percentBalans;// тот остаток процента ндс с которого мы будем платить ндс
    private double totalVATToPay;//Ндс необходимый оплатить
    private double totalAmountVATAndIncomeTax;//общая сума НДС и налога на прибыль к оплате
    private double taxBurdenPercent;//налоговая нагрузка в процентах
    private double taxBurdenWithQuarterly;//налоговая нагрузка с отчислениями
    private double toPayVAT;//к оплате НДС вышло
    private double mustCollectDeductions;//необходимо набрать вычетов
    private double mustList;// необходимо еще перечислить
    private double totalLoad;// общая нагрузка ,выплаты от общей суммы


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

    //Сумма вычетов по ндс необходимо
    public void setDeductionSumVAT(VATResult vatResult,VAT vat) {
        double result = (vatResult.getVat() * vat.getPercentDeductionVAT()) / 100;
        this.deductionSumVAT = result;
    }

    //Ндс необходимый оплатить то есть которая считается с оставщегося у нас ндс
    public void setTotalVATToPay(VATResult vatResult) {
        this.totalVATToPay = (vatResult.getVat() * vatResult.getPercentBalans()) / 100;
    }

    //общая сума НДС и налога на прибыль к оплате
    public void setTotalAmountVATAndIncomeTax(VAT vat, VATResult vatResult) {
        this.totalAmountVATAndIncomeTax = vat.getIncomeTax() + vatResult.getTotalVATToPay();//сумма налога на прибыль и ндс к оплате
    }

    //Формула вычисления налоговой нагрузки в процентах (Пишу код под песенки Савичевой)
    public void setTaxBurdenPercent(VATResult vatResult) {
        this.taxBurdenPercent = (vatResult.getTotalAmountVATAndIncomeTax() / vatResult.getTotalAmountNotVat()) * 100;
    }//общая сумма ндс нп / сумму без ндс *100

    //налоговая нагрузка с отчислениями
    //формула отчисления + ндс и нп / сумма без ндс * 100
    public void setTaxBurdenWithQuarterly(VATResult vatResult,VAT vat) {
        double number = (vat.getQuarterlyDeduction() + vatResult.getTotalAmountVATAndIncomeTax())
                / vatResult.getTotalAmountNotVat() * 100;
        this.taxBurdenWithQuarterly = number;
    }

    //к оплате НДС вышло формула ндс - вычеты которые мы вбили
    public void setToPayVAT(VATResult vatResult,VAT vat){
        double number = vatResult.getVat() - vat.getDeductionsWithVAT();//общий ндс минусуем вычеты чтобы узнать сколько нужно платить сейчас
        this.toPayVAT = number;//кладем результат в свойство объекта
    }

    //необходимо набрать вычетов/ формула необходимый ндс оплатить минус то что вышло к оплате
    public void setMustCollectDeductions(VATResult vatResult){
        double number = vatResult.getTotalVATToPay() - vatResult.getToPayVAT();
        this.mustCollectDeductions = number;
    }

    // необходимо еще перечислить формула чтобы узнать сколько перечислить поступаем наоборот
    public void setMustList(VATResult vatResult){
        double number = vatResult.getMustCollectDeductions() * 120 / 20;
        this.mustList = number;
    }


    //Формула подсчета НДС c общей суммы
    public void setVAT(double number){
        if (number != 0) {
            this.vat = (number * 20) / 120;
        }
        else {
            this.vat = 0;
        }
    }


    // тот остаток процента ндс с которого мы будем платить ндс
    public void setPercentBalans(float var) {
        this.percentBalans = 100 - var;
    }

    //Формула суммы без ндс
    public static double getResultNotVAT(double totalAmounth, double vat){
        return totalAmounth - vat;
    }

    //Формула необходимо оплатить ндс с указанным процентом вычета
    public static double getPercentVAT(float percent, double vat){
        return (vat * percent) / 100;
    }



    //вычисляем сумму без ндс
    public void setTotalAmountNotVat(double totalAmountNotVat) {
            this.totalAmountNotVat = totalAmountNotVat;
    }

    // общая нагрузка ,выплаты от общей суммы
    //формула нп и ндс + отчисления / общая сумма с ндс * 100
    public void setTotalLoad(VATResult vatResult, VAT vat) {
        double number = (vat.getQuarterlyDeduction() + vatResult.getTotalAmountVATAndIncomeTax()) /
                            vat.getTotalAmountWithVAT() * 100;
        this.totalLoad = number;
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

    public double getTaxBurdenPercent() {
        return taxBurdenPercent;
    }

    public double getTaxBurdenWithQuarterly() {
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

    public double getTotalLoad() {
        return totalLoad;
    }
}
