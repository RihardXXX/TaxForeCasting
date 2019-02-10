package ru.lifehuman.taxforecasting;

public class VATResult {
    private double vat;//НДС
    private double totalAmountNotVat;//сумма без НДС
    private double deductionSumVAT;//сумма вычетов по НДС
    private double totalVATToPay;//Ндс необходимый оплатить
    private double totalAmountVATAndIncomeTax;//общая сума НДС и налога на прибыль
    private float taxBurdenPercent;//налоговая нагрузка в процентах
    private float taxBurdenWithQuarterly;//налоговая нагрузка с отчислениями
    private double toPayVAT;//к оплате НДС
    private double mustCollectDeductions;//необходимо набрать вычетов
    private double mustList;// необходимо еще перечислить

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

    public void setVat(double vat) {
        this.vat = vat;
    }

    public void setTotalAmountNotVat(double totalAmountNotVat) {
        this.totalAmountNotVat = totalAmountNotVat;
    }

    public void setDeductionSumVAT(double deductionSumVAT) {
        this.deductionSumVAT = deductionSumVAT;
    }

    public void setTotalVATToPay(double totalVATToPay) {
        this.totalVATToPay = totalVATToPay;
    }

    public void setTotalAmountVATAndIncomeTax(double totalAmountVATAndIncomeTax) {
        this.totalAmountVATAndIncomeTax = totalAmountVATAndIncomeTax;
    }

    public void setTaxBurdenPercent(float taxBurdenPercent) {
        this.taxBurdenPercent = taxBurdenPercent;
    }

    public void setTaxBurdenWithQuarterly(float taxBurdenWithQuarterly) {
        this.taxBurdenWithQuarterly = taxBurdenWithQuarterly;
    }

    public void setToPayVAT(double toPayVAT) {
        this.toPayVAT = toPayVAT;
    }

    public void setMustCollectDeductions(double mustCollectDeductions) {
        this.mustCollectDeductions = mustCollectDeductions;
    }

    public void setMustList(double mustList) {
        this.mustList = mustList;
    }
}
