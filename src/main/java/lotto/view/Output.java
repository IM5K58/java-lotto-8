package lotto.view;

import lotto.dto.LottosDTO;
import lotto.dto.LottoDTO;
public class Output {
    public void showLottoCounts(int lottocount){
        System.out.println(lottocount+"개를 구매했습니다.");
    }

    public void showLottos(LottosDTO lottos){
        for(LottoDTO lotto : lottos.getLottos()){
            System.out.println(lotto);
        }
    }

    public void showWinningCounts(){
        System.out.println("당첨 통계");
        System.out.println("---");


    }
    public void showROI(double roi){
        System.out.print("총 수익률은 "+roi+"%입니다.");
    }
}
