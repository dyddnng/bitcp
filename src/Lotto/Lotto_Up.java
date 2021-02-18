package Lotto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto_Up {
    private List<String> LottoNums;
    private FileWriter fw;
    private BufferedWriter bw;
    
    public Lotto_Up() {
        LottoNums = new ArrayList<String>();
    }
    
    public void addLotto() {
        Set<Integer> LottoNum = new TreeSet<Integer>();
        String Lotto = "로또 " + (LottoNums.size()+1) + "회차: ";
        for(int i=0;LottoNum.size()<6;i++) {
            LottoNum.add((int)(Math.random() * 45 + 1));
        }
        Lotto += LottoNum.toString();
        LottoNums.add(Lotto+"\n");
        System.out.printf("%s\n",Lotto);
    }
    
    public void writeLotto() {
        try {
            fw = new FileWriter("Lotto.txt",false);
            bw = new BufferedWriter(fw);
            for(int i=0;i<LottoNums.size();i++) {
                bw.write(LottoNums.get(i));
            }
            
        } catch (Exception e) {
            
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    
    public static void main(String[] args) {
        Lotto_Up lotto = new Lotto_Up();
        
        lotto.addLotto();
        lotto.addLotto();
        lotto.addLotto();
        lotto.addLotto();
        lotto.addLotto();
        
        lotto.writeLotto();
    }
}
