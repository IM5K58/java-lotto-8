package lotto.controller;

import lotto.model.Lottos;
import lotto.view.Input;
import lotto.view.Output;
import lotto.model.LottoCount;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.dto.LottosDTO;
import lotto.dto.LottoDTO;


public class LottoController {
    Input input = new Input();
    Output output = new Output();

    public void run(){
        int money = Integer.parseInt(input.inputMoney());
        System.out.println();
        LottoCount lottoCounts = new LottoCount(money);
        money = lottoCounts.getLottoCounts();
        output.showLottoCounts(money);
        Lottos lottos = new Lottos();
        LottoGenerator lottoGenerator = new LottoGenerator();
        for(int i = 0; i < money; i++){
            lottos.addLotto(new Lotto(lottoGenerator.generateLottoNumber()));
        }

        Lotto winningLotto = new Lotto();
        //입력받은 문자열에 대해서 노나주는거 해야됨
    }


}
