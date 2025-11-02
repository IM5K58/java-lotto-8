package lotto.view;

import lotto.dto.LottosDTO;
import lotto.dto.LottoDTO;
import lotto.dto.RankResultDTO;
import lotto.dto.WinningResultDTO;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Output {

    public void showLottoCounts(int lottocount){
        System.out.println("\n" + lottocount+"개를 구매했습니다.");
    }

    public void showLottos(LottosDTO lottos){
        for(LottoDTO lotto : lottos.getLottos()){
            System.out.println(lotto.getLottoDTO());
        }
    }

    public void showWinningCounts(WinningResultDTO winningResultDTO){
        System.out.println("\n당첨 통계");
        System.out.println("---");
        NumberFormat formatter = NumberFormat.getInstance();
        for(RankResultDTO rankResultDTO: winningResultDTO.getWinningResultDTO()){
            printWinningResults(rankResultDTO, formatter);
        }


    }

    private void printWinningResults(RankResultDTO rankResultDTO, NumberFormat formatter) {
        String prize = formatter.format(rankResultDTO.getPrizeMoney());

        String description;
        if (rankResultDTO.isBonus()) {
            description = String.format("%d개 일치, 보너스 볼 일치", rankResultDTO.getMatchCount());
        } else {
            description = String.format("%d개 일치", rankResultDTO.getMatchCount());
        }

        System.out.printf("%s (%s원) - %d개\n",
                description,
                prize,
                rankResultDTO.getCount()
        );
    }

    public void showROI(double roi){
        DecimalFormat df = new DecimalFormat("#,##0.0");
        String formattedRoi = df.format(roi);
        System.out.print("총 수익률은 "+roi+"%입니다.");
    }
}
