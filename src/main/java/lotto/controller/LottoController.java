package lotto.controller;

import lotto.model.*;
import lotto.view.Input;
import lotto.view.Output;
import lotto.dto.LottosDTO;
import lotto.dto.LottoDTO;
import lotto.dto.RankResultDTO;
import lotto.dto.WinningResultDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class LottoController {
    Input input = new Input();
    Output output = new Output();

    public void run(){
        int money = Integer.parseInt(input.inputMoney());
        System.out.println();
        LottoCount lottoCounts = new LottoCount(money);
        int counts = lottoCounts.getLottoCounts();
        output.showLottoCounts(counts);
        Lottos lottos = new Lottos();
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<LottoDTO> lottoDTOS = new ArrayList<>();
        for(int i = 0; i < counts; i++){
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumber());
            lottoDTOS.add(new LottoDTO(lotto.getLottoNumbers()));
            lottos.addLotto(lotto);

        }
        LottosDTO lottosDTO = new LottosDTO(lottoDTOS);
        output.showLottos(lottosDTO);

        Separator separator = new Separator();
        String inputLotto = input.inputWinningNumber();
        List<String> sep_res = separator.separate(inputLotto);
        Parser parser = new Parser();
        Lotto winningLotto = new Lotto(parser.integerParser(sep_res));

        System.out.println();
        int bonusNumber = parser.integerParser(input.inputBonusNumber());

        //bonusNumber와 LottoNumber의 중복 번호있는지 검증

        WinningCheck winningCheck = new WinningCheck(winningLotto, bonusNumber);
        Map<WinningRank, Integer> rankMap = winningCheck.getWinningTimes(lottos);

        List<WinningRank> displayRanks = List.of(
                WinningRank.FIFTH,
                WinningRank.FOURTH,
                WinningRank.THIRD,
                WinningRank.SECOND,
                WinningRank.FIRST
        );

        List<RankResultDTO> dtoList = new ArrayList<>();
        for (WinningRank rank : displayRanks) {
            int count = rankMap.get(rank);
            dtoList.add(new RankResultDTO(
                    rank.getMatchCount(),
                    (long) rank.getPrizeMoney(),
                    rank == WinningRank.SECOND,
                    count
            ));
        }

        WinningResultDTO winningResultDTO = new WinningResultDTO(dtoList);
        output.showWinningCounts(winningResultDTO);
        ROIcalculator roiCalculator = new ROIcalculator();
        double ROI = roiCalculator.ROI(money,winningCheck.calculateTotalPrize(rankMap));
        output.showROI(ROI);


    }


}
