package lotto.controller;

import lotto.model.*;
import lotto.utils.Parser;
import lotto.utils.ROIcalculator;
import lotto.utils.Separator;
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
    private final Input input = new Input();
    private final Output output = new Output();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final Parser parser = new Parser();
    private final Separator separator = new Separator();

    public void run(){
        int money = inputValidMoney();
        LottoCount lottoCounts = new LottoCount(money);
        int counts = lottoCounts.getLottoCounts();
        output.showLottoCounts(counts);

        Lottos lottos = generateLottos(counts);
        output.showLottos(lottosToLottosDTO(lottos));

        Lotto winningLotto = inputValidWinningLotto();
        int bonusNumber = inputValidBonusNumber(winningLotto);

        WinningCheck winningCheck = new WinningCheck(winningLotto, bonusNumber);
        Map<WinningRank, Integer> rankMap = winningCheck.getWinningTimes(lottos);
        WinningResultDTO winningResultDTO = convertToWinningResultDTO(rankMap);

        output.showWinningCounts(winningResultDTO);
        ROIcalculator roiCalculator = new ROIcalculator();
        double ROI = roiCalculator.ROI(money, winningCheck.calculateTotalPrize(rankMap));
        output.showROI(ROI);

    }

    private int inputValidMoney() {
        while (true) {
            try {
                Money money = new Money(input.inputMoney());
                return money.getMoney();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto inputValidWinningLotto() {
        while (true) {
            try {
                String inputLotto = input.inputWinningNumber();
                List<String> sep_res = separator.separate(inputLotto);
                List<Integer> numbers = parser.integerParser(sep_res);
                Lotto winningLotto = new Lotto(numbers);
                return winningLotto;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputValidBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                BonusNumber bonusNumber = new BonusNumber(input.inputBonusNumber(),  winningLotto);
                return bonusNumber.getBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos generateLottos(int counts) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < counts; i++) {
            Lotto lotto = new Lotto(lottoGenerator.generateLottoNumber());
            lottos.addLotto(lotto);
        }
        return lottos;
    }

    private LottosDTO lottosToLottosDTO(Lottos lottos) {
        List<LottoDTO> lottoDTOS = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            lottoDTOS.add(new LottoDTO(lotto.getLottoNumbers()));
        }
        return new LottosDTO(lottoDTOS);
    }

    private WinningResultDTO convertToWinningResultDTO(Map<WinningRank, Integer> rankMap) {

        List<RankResultDTO> RankDTO = new ArrayList<>();
        for (WinningRank rank : rankMap.keySet()) {
            if (rank == WinningRank.MISS) {
                continue;
            }
            int count = rankMap.get(rank);
            RankDTO.add(new RankResultDTO(
                    rank.getMatchCount(),
                    (long) rank.getPrizeMoney(),
                    rank == WinningRank.SECOND,
                    count
            ));
        }
        return new WinningResultDTO(RankDTO);
    }
}

