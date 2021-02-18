package Bank_LSJ;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String transactionDate; //거래일
    private String getTransactionTime; //거래시간
    private String kind; //입출금
    private long amount; //거래금액
    private long balance; //잔고

    //거래내역 생성자
    //거래내역 생성자는 거래가 이루어질때 거래종류, 거래금액, 잔고를 생성합니다
    public Transaction(String kind, long amount, long balance) {
        this.kind = kind;
        this.amount = amount;
        this.balance = balance;
    }

    //toString() 재정의로 출력을 조정함
    @Override
    public String toString() {

        Date histroy = new Date();
        SimpleDateFormat transactionHistory = new SimpleDateFormat("yyyy년 MMMdd일 HH시 MM분");
        this.transactionDate = transactionHistory.format(histroy);

        return "[거래 금액:"+amount+", 잔액:"+this.balance+"원/"+transactionDate + ']';
    }
}