package lotto.utils;

public class ROIcalculator {

    public double ROI(int originMoney, long totalPrize){
        return (double)totalPrize / (double)originMoney * 100;
    }

}
