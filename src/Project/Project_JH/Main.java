package Project;

public class Main {
   public static void main(String[] args) {
      
      BitEats biteats = new BitEats();
      Customer customer = new Customer();
      
      //메뉴 생성 
      customer.setMenu("김볶밥", 10000);
      customer.setMenu("치돈", 15000);
      customer.setMenu("라면", 5000);
      
      //회원가입 및 로그인 
      biteats.BitEatsMain();
      
      
      
      
      
   }

}