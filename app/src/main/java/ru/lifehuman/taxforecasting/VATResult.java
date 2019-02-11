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

}
