/*VendingMachine
 * 2019.12
 * Emmet Baek
 * Remake in 2021.10.25
 * Update
 * 1.2021.10.30
 */

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Vendingmachine extends JFrame 
{
	/*자판기 이용자 제공 데이터 출력 컴포넌트*/
	JTextField Order_Output;
	JTextField Input_Output;
	JTextField Change_Output;
	
	/*음료 주문 버튼*/
	JButton Water;
	JButton Coffee;
	JButton Ion;
	JButton Premium_Coffee;
	JButton Soda;
	
	/*거스름돈 반환 출력*/
	JTextField change_ten_won;
	JTextField change_fifty_won;
	JTextField change_one_hundred_won;
	JTextField change_five_hundred_won;
	JTextField change_one_thousand_won;
	
	/*관리자메뉴 -> 상품 재고*/
	JTextField 물_재고;
	JTextField 커피_재고;
	JTextField 이온음료_재고;
	JTextField 프리미엄커피_재고;
	JTextField 탄산음료_재고;
	
	/*관리자메뉴->거스름돈 재고*/
	JTextField 십원_재고;
	JTextField 오십원_재고;
	JTextField 백원_재고;
	JTextField 오백원_재고;
	JTextField 천원_재고;
	
	JTextField 매출액;
	JButton 수입_출금;
	
	/*거스름동용 동전이 없을때 보여줌*/
	JTextField 십원없음;
	JTextField 오십원없음;
	JTextField 백원없음;
	JTextField 오백원없음;
	JTextField 천원없음;
	
	/*관리자권한 접근 비밀번호 텍스트필드*/
	JTextField access_code_input;
	
	/*거스름돈, 음료 재고 1 증가시키는 버튼*/
	JButton 물_재고_추가;
	JButton 커피_재고_추가;
	JButton 이온음료_재고_추가;
	JButton 프리미엄커피_재고_추가;
	JButton 탄산음료_재고_추가;
	
	JButton 십원_재고_추가;
	JButton 오십원_재고_추가;
	JButton 백원_재고_추가;
	JButton 오백원_재고_추가;
	JButton 천원_재고_추가;
	
	String client_order;
	String Manager_login_code;
	
	int money_input=0;
	int selled=0;
	
	int ten_won_count=0;
	int fifty_won_count=0;
	int one_hundred_won_count=0;
	int five_hundred_won_count=0;
	int one_thousand_won_count=0;
	
	Beverage Beverage_list[]=new Beverage[5];
	Money inputed_money=new Money(0,0,0,0,0);
	Money change=new Money(5,5,5,5,5);
	
	public Vendingmachine()
	{
		setTitle("Vending Machine");//프로그램명 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//창을 닫으면 프로그램 종료
		
		//음료데이터 클래스 배열에 음료 데이터 저장
		Beverage_list[0]=new Beverage("물",3,450);
		Beverage_list[1]=new Beverage("커피",3,500);
		Beverage_list[2]=new Beverage("이온음료",3,550);
		Beverage_list[3]=new Beverage("프리미엄커피",3,700);
		Beverage_list[4]=new Beverage("탄산음료",3,750);
		
		Container c=getContentPane();
		c.setBackground(Color.orange);
		c.setLayout(null);
		
		/*타이틀 설정*/
		JLabel Machine_Title=new JLabel("VendingMachine");
		Machine_Title.setFont(new Font("맑은 고딕",Font.BOLD,20));
		Machine_Title.setLocation(200,10);
		Machine_Title.setSize(1000, 30);
		c.add(Machine_Title);
		
		//물 : 주문버튼, 가격표 순
		Water=new JButton("물");
		Water.setFont(new Font("돋움",Font.BOLD,15));
		Water.setLocation(50, 50);
		Water.setSize(100,35);
		Water.addActionListener(new Order_Button_Listener());
		
		c.add(Water);
		JLabel Water_Price=new JLabel("450원");
		Water_Price.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Water_Price.setLocation(160,50);
		Water_Price.setSize(300, 30);
		c.add(Water_Price);
		
		//커피 : 주문버튼, 가격표 순
		Coffee=new JButton("커피");
		Coffee.setFont(new Font("돋움",Font.BOLD,15));
		Coffee.setLocation(50,100);
		Coffee.setSize(100,35);
		Coffee.addActionListener(new Order_Button_Listener());
		c.add(Coffee);
		
		JLabel Coffee_Price=new JLabel("500원");
		Coffee_Price.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Coffee_Price.setLocation(160,100);
		Coffee_Price.setSize(300, 30);
		c.add(Coffee_Price);
		
		//이온음료 : 주문버튼, 가격표 순
		Ion=new JButton("이온음료");
		Ion.setFont(new Font("돋움",Font.BOLD,15));
		Ion.setLocation(50, 150);
		Ion.setSize(100,35);
		Ion.addActionListener(new Order_Button_Listener());
		c.add(Ion);
		
		JLabel Ion_Price=new JLabel("550원");
		Ion_Price.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Ion_Price.setLocation(160,150);
		Ion_Price.setSize(100, 35);
		c.add(Ion_Price);
		
		//프리미엄 커피 : 주문버튼, 가격표 순
		Premium_Coffee=new JButton("프리미엄커피");
		Premium_Coffee.setFont(new Font("돋움",Font.BOLD,10));
		Premium_Coffee.setLocation(50, 200);
		Premium_Coffee.setSize(100,35);
		Premium_Coffee.addActionListener(new Order_Button_Listener());
		c.add(Premium_Coffee);
		
		JLabel Premium_Coffee_Price=new JLabel("700원");
		Premium_Coffee_Price.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Premium_Coffee_Price.setLocation(160,200);
		Premium_Coffee_Price.setSize(300, 30);
		c.add(Premium_Coffee_Price);
		
		//탄산음료 : 주문버튼, 가격표 순
		Soda=new JButton("탄산음료");
		Soda.setFont(new Font("돋움",Font.BOLD,15));
		Soda.setLocation(50, 250);
		Soda.setSize(100,35);
		Soda.addActionListener(new Order_Button_Listener());
		c.add(Soda);
		
		JLabel Soda_Price=new JLabel("750원");
		Soda_Price.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Soda_Price.setLocation(160,250);
		Soda_Price.setSize(300, 30);
		c.add(Soda_Price);
		
		/*반환할 거스름돈 재고가 없을때 이를 표시해줌*/
		
		//10원
		십원없음=new JTextField("");
		십원없음.setFont(new Font("돋음",Font.BOLD,13));
		십원없음.setLocation(300, 50);
		십원없음.setSize(100, 30);
		c.add(십원없음);
		
		//50원
		오십원없음=new JTextField("");
		오십원없음.setFont(new Font("돋음",Font.BOLD,13));
		오십원없음.setLocation(300, 100);
		오십원없음.setSize(100, 30);
		c.add(오십원없음);
		
		//100원
		백원없음=new JTextField("");
		백원없음.setFont(new Font("돋음",Font.BOLD,13));
		백원없음.setLocation(300, 150);
		백원없음.setSize(100, 30);
		c.add(백원없음);
		
		오백원없음=new JTextField("");
		오백원없음.setFont(new Font("돋음",Font.BOLD,13));
		오백원없음.setLocation(300, 200);
		오백원없음.setSize(100, 30);
		c.add(오백원없음);
		
		천원없음=new JTextField("");
		천원없음.setFont(new Font("돋음",Font.BOLD,13));
		천원없음.setLocation(300, 250);
		천원없음.setSize(100, 30);
		c.add(천원없음);
		
		/*돈을 입력하는 버튼 : 직접 동전을 넣을 수는 없으니까 임의로 구현*/
		JLabel Money_Input_Title=new JLabel("<아래 네 버튼으로 돈 넣기>");
		Money_Input_Title.setFont(new Font("돋음",Font.BOLD,15));
		Money_Input_Title.setLocation(50, 320);
		Money_Input_Title.setSize(300, 30);
		c.add(Money_Input_Title);
		
		JButton ten_won=new JButton("10");
		ten_won.setFont(new Font("돋음",Font.BOLD,15));
		ten_won.setLocation(40, 350);
		ten_won.setSize(80, 30);
		ten_won.addActionListener(new Money_Input_Listener());
		c.add(ten_won);

		JButton fifty_won=new JButton("50");
		fifty_won.setFont(new Font("돋음",Font.BOLD,15));
		fifty_won.setLocation(120, 350);
		fifty_won.setSize(80, 30);
		fifty_won.addActionListener(new Money_Input_Listener());
		c.add(fifty_won);
		
		JButton one_hundred_won=new JButton("100");
		one_hundred_won.setFont(new Font("돋음",Font.BOLD,15));
		one_hundred_won.setLocation(200, 350);
		one_hundred_won.setSize(80, 30);
		one_hundred_won.addActionListener(new Money_Input_Listener());
		c.add(one_hundred_won);
		
		JButton five_hundred_won=new JButton("500");
		five_hundred_won.setFont(new Font("돋음",Font.BOLD,15));
		five_hundred_won.setLocation(280, 350);
		five_hundred_won.setSize(80, 30);
		five_hundred_won.addActionListener(new Money_Input_Listener());
		c.add(five_hundred_won);
		
		JButton one_thousand_won=new JButton("1000");
		one_thousand_won.setFont(new Font("돋음",Font.BOLD,15));
		one_thousand_won.setLocation(360, 350);
		one_thousand_won.setSize(80, 30);
		one_thousand_won.addActionListener(new Money_Input_Listener());
		c.add(one_thousand_won);
		
		/*고객이 넣은 돈이 화면에 출력*/
		JLabel Money = new JLabel("넣은 돈");
		Money.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Money.setLocation(50, 400);
		Money.setSize(100,30);
		c.add(Money);
		
		Input_Output=new JTextField("0");
		Input_Output.setEnabled(false);
		Input_Output.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Input_Output.setLocation(150, 400);
		Input_Output.setSize(100,30);
		c.add(Input_Output);
		
		/*고객이 선택한 음료명을 출력*/
		JLabel Order = new JLabel("선택한 음료");
		Order.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Order.setLocation(50, 450);
		Order.setSize(500,30);
		c.add(Order);
		
		Order_Output=new JTextField("");
		Order_Output.setEnabled(false);
		Order_Output.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Order_Output.setLocation(150, 450);
		Order_Output.setSize(100,30);
		c.add(Order_Output);
		
		//음료뽑기 버튼
		JButton Calculate=new JButton("음료 뽑기");
		Calculate.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Calculate.setLocation(250, 450);
		Calculate.setSize(100,30);
		Calculate.addActionListener(new Calculate_Listener());
		c.add(Calculate);
		
		/*거스름돈 출력*/
		JLabel Change = new JLabel("거스름돈");
		Change.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Change.setLocation(50, 500);
		Change.setSize(500,30);
		c.add(Change);
		
		Change_Output=new JTextField("0");
		Change_Output.setEnabled(false);
		Change_Output.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Change_Output.setLocation(150, 500);
		Change_Output.setSize(100,30);
		c.add(Change_Output);
		
		/*거스름돈을 고객에게 반환*/
		
		//반환버튼
		JButton Change_Output=new JButton("거스름돈 반환");
		Change_Output.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Change_Output.setLocation(250, 500);
		Change_Output.setSize(130,50);
		Change_Output.addActionListener(new Change_Output_Listener());
		c.add(Change_Output);
		
		//10원 동전
		JLabel Moneyback_ten = new JLabel("10원");
		Moneyback_ten.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Moneyback_ten.setLocation(50, 580);
		Moneyback_ten.setSize(500,30);
		c.add(Moneyback_ten);
		
		change_ten_won=new JTextField();
		change_ten_won.setText("0");
		change_ten_won.setEnabled(false);
		change_ten_won.setFont(new Font("맑은 고딕",Font.BOLD,15));
		change_ten_won.setLocation(50, 610);
		change_ten_won.setSize(80,30);
		c.add(change_ten_won);
		
		//50원 동전
		JLabel Moneyback_fifty = new JLabel("50원");
		Moneyback_fifty.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Moneyback_fifty.setLocation(150, 580);
		Moneyback_fifty.setSize(500,30);
		c.add(Moneyback_fifty);
		
		change_fifty_won=new JTextField();
		change_fifty_won.setText("0");
		change_fifty_won.setEnabled(false);
		change_fifty_won.setFont(new Font("맑은 고딕",Font.BOLD,15));
		change_fifty_won.setLocation(150, 610);
		change_fifty_won.setSize(80,30);
		c.add(change_fifty_won);
		
		//100원 동전
		JLabel Moneyback_one_hundred = new JLabel("100원");
		Moneyback_one_hundred.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Moneyback_one_hundred.setLocation(250, 580);
		Moneyback_one_hundred.setSize(500,30);
		c.add(Moneyback_one_hundred);
		
		change_one_hundred_won=new JTextField();
		change_one_hundred_won.setText("0");
		change_one_hundred_won.setEnabled(false);
		change_one_hundred_won.setFont(new Font("맑은 고딕",Font.BOLD,15));
		change_one_hundred_won.setLocation(250, 610);
		change_one_hundred_won.setSize(80,30);
		c.add(change_one_hundred_won);
		
		//500원
		JLabel Moneyback_five_hundred = new JLabel("500원");
		Moneyback_five_hundred.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Moneyback_five_hundred.setLocation(350, 580);
		Moneyback_five_hundred.setSize(500,30);
		c.add(Moneyback_five_hundred);
		
		change_five_hundred_won=new JTextField();
		change_five_hundred_won.setText("0");
		change_five_hundred_won.setEnabled(false);
		change_five_hundred_won.setFont(new Font("맑은 고딕",Font.BOLD,15));
		change_five_hundred_won.setLocation(350, 610);
		change_five_hundred_won.setSize(80,30);
		c.add(change_five_hundred_won);
		
		//1000원
		JLabel Moneyback_one_thousand = new JLabel("1000원");
		Moneyback_one_thousand.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Moneyback_one_thousand.setLocation(450, 580);
		Moneyback_one_thousand.setSize(500,30);
		c.add(Moneyback_one_thousand);
		
		change_one_thousand_won=new JTextField();
		change_one_thousand_won.setText("0");
		change_one_thousand_won.setEnabled(false);
		change_one_thousand_won.setFont(new Font("맑은 고딕",Font.BOLD,15));
		change_one_thousand_won.setLocation(450, 610);
		change_one_thousand_won.setSize(80,30);
		c.add(change_one_thousand_won);
		
		
		/*관리자 메뉴*/
		JLabel Manager_Menu = new JLabel("<관리자 메뉴>");
		Manager_Menu.setFont(new Font("맑은 고딕",Font.BOLD,18));
		Manager_Menu.setLocation(680, 100);
		Manager_Menu.setSize(300,30);
		c.add(Manager_Menu);
		
		/*관리자 메뉴 로그인*/
		JLabel access_code= new JLabel("비밀번호 입력");//비밀번호는 qwer1234
		access_code.setFont(new Font("맑은 고딕",Font.BOLD,13));
		access_code.setLocation(580, 130);
		access_code.setSize(100,30);
		c.add(access_code);
		
		access_code_input=new JTextField();
		access_code_input.setEnabled(true);
		access_code_input.setFont(new Font("맑은 고딕",Font.BOLD,15));
		access_code_input.setLocation(680, 130);
		access_code_input.setSize(100,30);
		c.add(access_code_input);
		
		JButton Login= new JButton("Login");
		Login.setFont(new Font("돋움",Font.BOLD,15));
		Login.setLocation(780, 130);
		Login.setSize(90,30);
		Login.addActionListener(new Manager_Login_Listener());
		c.add(Login);
		
		/*자판기 안에 있는 음료 재고*/
		
		//물 재고
		JLabel Water_stock = new JLabel("물 재고");
		Water_stock.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Water_stock.setLocation(580, 180);
		Water_stock.setSize(300,30);
		c.add(Water_stock);
		
		물_재고=new JTextField();
		물_재고.setText(Integer.toString(Beverage_list[0].count));
		물_재고.setEnabled(false);
		물_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		물_재고.setLocation(750, 180);
		물_재고.setSize(50,30);
		c.add(물_재고);
		
		물_재고_추가=new JButton("물추가");
		물_재고_추가.setEnabled(false);
		물_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,13));
		물_재고_추가.setLocation(810, 180);
		물_재고_추가.setSize(120,30);
		물_재고_추가.addActionListener(new Stock_Plus());
		c.add(물_재고_추가);
		
		//커피
		JLabel Coffee_stock = new JLabel("커피 재고");
		Coffee_stock.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Coffee_stock.setLocation(580, 230);
		Coffee_stock.setSize(300,30);
		c.add(Coffee_stock);
		
		커피_재고=new JTextField();
		커피_재고.setText(Integer.toString(Beverage_list[1].count));
		커피_재고.setEnabled(false);
		커피_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		커피_재고.setLocation(750, 230);
		커피_재고.setSize(50,30);
		c.add(커피_재고);
		
		커피_재고_추가=new JButton("커피추가");
		커피_재고_추가.setEnabled(false);
		커피_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,13));
		커피_재고_추가.setLocation(810, 230);
		커피_재고_추가.setSize(120,30);
		커피_재고_추가.addActionListener(new Stock_Plus());
		c.add(커피_재고_추가);
		
		//이온음료
		JLabel Ion_stock = new JLabel("이온음료 재고");
		Ion_stock.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Ion_stock.setLocation(580, 280);
		Ion_stock.setSize(300,30);
		c.add(Ion_stock);
		
		이온음료_재고=new JTextField();
		이온음료_재고.setText(Integer.toString(Beverage_list[2].count));
		이온음료_재고.setEnabled(false);
		이온음료_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		이온음료_재고.setLocation(750, 280);
		이온음료_재고.setSize(50,30);
		c.add(이온음료_재고);
		
		이온음료_재고_추가=new JButton("이온음료추가");
		이온음료_재고_추가.setEnabled(false);
		이온음료_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,13));
		이온음료_재고_추가.setLocation(810, 280);
		이온음료_재고_추가.setSize(120,30);
		이온음료_재고_추가.addActionListener(new Stock_Plus());
		c.add(이온음료_재고_추가);
		
		//프리미엄커피
		JLabel Premium_Coffee_stock = new JLabel("프리미엄커피 재고");
		Premium_Coffee_stock.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Premium_Coffee_stock.setLocation(580, 330);
		Premium_Coffee_stock.setSize(300,30);
		c.add(Premium_Coffee_stock);
		
		프리미엄커피_재고=new JTextField();
		프리미엄커피_재고.setText(Integer.toString(Beverage_list[3].count));
		프리미엄커피_재고.setEnabled(false);
		프리미엄커피_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		프리미엄커피_재고.setLocation(750, 330);
		프리미엄커피_재고.setSize(50,30);
		c.add(프리미엄커피_재고);
		
		프리미엄커피_재고_추가=new JButton("프리미엄커피추가");
		프리미엄커피_재고_추가.setEnabled(false);
		프리미엄커피_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,10));
		프리미엄커피_재고_추가.setLocation(810, 330);
		프리미엄커피_재고_추가.setSize(120,30);
		프리미엄커피_재고_추가.addActionListener(new Stock_Plus());
		c.add(프리미엄커피_재고_추가);
		
		//탄산음료
		JLabel Soda_stock = new JLabel("탄산음료 재고");
		Soda_stock.setFont(new Font("맑은 고딕",Font.BOLD,15));
		Soda_stock.setLocation(580, 380);
		Soda_stock.setSize(300,30);
		c.add(Soda_stock);
		
		탄산음료_재고=new JTextField();
		탄산음료_재고.setText(Integer.toString(Beverage_list[4].count));
		탄산음료_재고.setEnabled(false);
		탄산음료_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		탄산음료_재고.setLocation(750, 380);
		탄산음료_재고.setSize(50,30);
		c.add(탄산음료_재고);
		
		탄산음료_재고_추가=new JButton("탄산음료추가");
		탄산음료_재고_추가.setEnabled(false);
		탄산음료_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,13));
		탄산음료_재고_추가.setLocation(810, 380);
		탄산음료_재고_추가.setSize(120,30);
		탄산음료_재고_추가.addActionListener(new Stock_Plus());
		c.add(탄산음료_재고_추가);
		
		//거스름돈 재고
		
		//10원
		JLabel 십원재고 = new JLabel("10원 재고");
		십원재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		십원재고.setLocation(580, 450);
		십원재고.setSize(300,30);
		c.add(십원재고);
		
		십원_재고=new JTextField();
		십원_재고.setText(Integer.toString(change.ten));
		십원_재고.setEnabled(false);
		십원_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		십원_재고.setLocation(750, 450);
		십원_재고.setSize(50,30);
		c.add(십원_재고);
		
		십원_재고_추가=new JButton("10원 보충");
		십원_재고_추가.setEnabled(false);
		십원_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,15));
		십원_재고_추가.setLocation(810, 450);
		십원_재고_추가.setSize(120,30);
		십원_재고_추가.addActionListener(new Change_Plus());
		c.add(십원_재고_추가);
		
		//50원
		JLabel 오십원재고 = new JLabel("50원 재고");
		오십원재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		오십원재고.setLocation(580, 500);
		오십원재고.setSize(300,30);
		c.add(오십원재고);
		
		오십원_재고=new JTextField();
		오십원_재고.setText(Integer.toString(change.fifty));
		오십원_재고.setEnabled(false);
		오십원_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		오십원_재고.setLocation(750, 500);
		오십원_재고.setSize(50,30);
		c.add(오십원_재고);
		
		오십원_재고_추가=new JButton("50원 보충");
		오십원_재고_추가.setEnabled(false);
		오십원_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,15));
		오십원_재고_추가.setLocation(810, 500);
		오십원_재고_추가.setSize(120,30);
		오십원_재고_추가.addActionListener(new Change_Plus());
		c.add(오십원_재고_추가);
		
		//100원
		JLabel 백원재고 = new JLabel("100원 재고");
		백원재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		백원재고.setLocation(580, 550);
		백원재고.setSize(300,30);
		c.add(백원재고);
		
		백원_재고=new JTextField();
		백원_재고.setText(Integer.toString(change.one_hund));
		백원_재고.setEnabled(false);
		백원_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		백원_재고.setLocation(750, 550);
		백원_재고.setSize(50,30);
		c.add(백원_재고);
		
		백원_재고_추가=new JButton("100원 보충");
		백원_재고_추가.setEnabled(false);
		백원_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,15));
		백원_재고_추가.setLocation(810, 550);
		백원_재고_추가.setSize(120,30);
		백원_재고_추가.addActionListener(new Change_Plus());
		c.add(백원_재고_추가);
		
		//500원
		JLabel 오백원재고 = new JLabel("500원 재고");
		오백원재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		오백원재고.setLocation(580, 600);
		오백원재고.setSize(300,30);
		c.add(오백원재고);
		
		오백원_재고=new JTextField();
		오백원_재고.setText(Integer.toString(change.five_hund));
		오백원_재고.setEnabled(false);
		오백원_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		오백원_재고.setLocation(750, 600);
		오백원_재고.setSize(50,30);
		c.add(오백원_재고);
		
		오백원_재고_추가=new JButton("500원 보충");
		오백원_재고_추가.setEnabled(false);
		오백원_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,15));
		오백원_재고_추가.setLocation(810, 600);
		오백원_재고_추가.setSize(120,30);
		오백원_재고_추가.addActionListener(new Change_Plus());
		c.add(오백원_재고_추가);
		
		//1000원
		JLabel 천원재고 = new JLabel("1000원 재고");
		천원재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		천원재고.setLocation(580, 650);
		천원재고.setSize(300,30);
		c.add(천원재고);
		
		천원_재고=new JTextField();
		천원_재고.setText(Integer.toString(change.one_thousand));
		천원_재고.setEnabled(false);
		천원_재고.setFont(new Font("맑은 고딕",Font.BOLD,15));
		천원_재고.setLocation(750, 650);
		천원_재고.setSize(50,30);
		c.add(천원_재고);
		
		천원_재고_추가=new JButton("1000원 보충");
		천원_재고_추가.setEnabled(false);
		천원_재고_추가.setFont(new Font("맑은 고딕",Font.BOLD,15));
		천원_재고_추가.setLocation(810, 650);
		천원_재고_추가.setSize(120,30);
		천원_재고_추가.addActionListener(new Change_Plus());
		c.add(천원_재고_추가);
		
		/*매출액*/
		JLabel 매출 = new JLabel("매출");
		매출.setFont(new Font("맑은 고딕",Font.BOLD,15));
		매출.setLocation(580, 700);
		매출.setSize(300,30);
		c.add(매출);
		
		매출액=new JTextField("0");
		매출액.setEnabled(false);
		매출액.setFont(new Font("맑은 고딕",Font.BOLD,15));
		매출액.setLocation(680, 700);
		매출액.setSize(100,30);
		c.add(매출액);
		
		수입_출금=new JButton("돈 수금");
		수입_출금.setEnabled(false);
		수입_출금.setFont(new Font("맑은 고딕",Font.BOLD,15));
		수입_출금.setLocation(780, 700);
		수입_출금.setSize(100,30);
		수입_출금.addActionListener(new Withdraw_Income_Listener());
		c.add(수입_출금);
		
		/*관리자메뉴 로그아웃*/
		JButton 설정완료=new JButton("설정 완료");
		설정완료.setEnabled(true);
		설정완료.setFont(new Font("맑은 고딕",Font.BOLD,15));
		설정완료.setLocation(800, 800);
		설정완료.setSize(120,30);
		설정완료.addActionListener(new Manager_Logout_Listener());
		c.add(설정완료);
	}
		
	//음료주문 버튼 액션리스너
	private class Order_Button_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton a = (JButton)e.getSource();//이벤트소스 버튼 알아내기
			Vendingmachine.this.Order_Output.setText(a.getText());//주문한 음료 이름텍스트를 불러와 Order_Output에 설정
			client_order=a.getText();//client_order에 주문 저장
		}
	}
		
	//10원,50원,100원,500원,1000원 추가 버튼(단, 돈을 넣은 총합이 5000원을 넘지 않음)
	private class Money_Input_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
				
			//10원
			if(b.getText().equals("10")&&money_input<=5000)
			{
				money_input=money_input+Integer.parseInt(b.getText());
				Input_Output.setText(Integer.toString(money_input));
				inputed_money.ten=inputed_money.ten+1;
				//change.ten++;
				if(money_input>5000)
				{
					money_input=money_input-10;
					inputed_money.ten=inputed_money.ten-1;
					//change.ten--;
				}
				//십원_재고.setText(Integer.toString(change.ten));
			}
				
			//50원
			else if(b.getText().equals("50")&&money_input<=5000)
			{
				money_input=money_input+Integer.parseInt(b.getText());
				Input_Output.setText(Integer.toString(money_input));
				inputed_money.fifty=inputed_money.fifty+1;
				//change.fifty++;
				if(money_input>5000)
				{
					money_input=money_input-50;
					inputed_money.fifty=inputed_money.fifty-1;
					//change.fifty--;
				}
				//오십원_재고.setText(Integer.toString(change.fifty));
			}
				
			//100원
			else if(b.getText().equals("100")&&money_input<=5000)
			{
				money_input=money_input+Integer.parseInt(b.getText());
				Input_Output.setText(Integer.toString(money_input));
				inputed_money.one_hund=inputed_money.one_hund+1;
				//change.one_hund++;
				if(money_input>5000)
				{
					money_input=money_input-100;
					inputed_money.one_hund=inputed_money.one_hund-1;
					//change.one_hund--;
				}
				//백원_재고.setText(Integer.toString(change.one_hund));
			}
			
			//500원
			else if(b.getText().equals("500")&&money_input<=5000)
			{
				money_input=money_input+Integer.parseInt(b.getText());
				Input_Output.setText(Integer.toString(money_input));
				inputed_money.five_hund=inputed_money.five_hund+1;
				//change.five_hund++;
				if(money_input>5000)
				{
					money_input=money_input-500;
					inputed_money.five_hund=inputed_money.five_hund-1;
					//change.five_hund--;
				}
				//오백원_재고.setText(Integer.toString(change.five_hund));
			}
			
			//1000원
			else if(b.getText().equals("1000")&&money_input<=5000)
			{
				money_input=money_input+Integer.parseInt(b.getText());
				Input_Output.setText(Integer.toString(money_input));
				inputed_money.one_thousand=inputed_money.one_thousand+1;
				//change.one_thousand++;
				if(money_input>5000)
				{
					money_input=money_input-1000;
					inputed_money.one_thousand=inputed_money.one_thousand-1;
					//change.one_thousand--;
				}
				//천원_재고.setText(Integer.toString(change.one_thousand));
			}
		}
	}
	
	//음료뽑기 버튼
	private class Calculate_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			inputed_money.ten=0;
			inputed_money.fifty=0;
			inputed_money.one_hund=0;
			inputed_money.five_hund=0;
			inputed_money.one_thousand=0;
			
			for(int i=0;i<5;i++)
			{
				if(Beverage_list[i].name.equals(client_order))
				{
					money_input=money_input-Beverage_list[i].cost;
					
					
					if(money_input>=0)
					{
						Beverage_list[i].count--;//해당
						selled=selled+Beverage_list[i].cost;
						매출액.setText(Integer.toString(selled));
						
						if(i==0)//물
						{
							물_재고.setText(Integer.toString(Beverage_list[0].count));
							if(Beverage_list[0].count==0)
							{
								Water.setEnabled(false);
							}
						}
						else if(i==1)//커피
						{
							커피_재고.setText(Integer.toString(Beverage_list[1].count));
							if(Beverage_list[1].count==0)
							{
								Coffee.setEnabled(false);
							}
						}
						else if(i==2)//이온음료
						{
							이온음료_재고.setText(Integer.toString(Beverage_list[2].count));
							if(Beverage_list[2].count==0)
							{
								Ion.setEnabled(false);
							}
						}
						else if(i==3)//프리미엄커피
						{
							프리미엄커피_재고.setText(Integer.toString(Beverage_list[3].count));
							if(Beverage_list[3].count==0)
							{
								Premium_Coffee.setEnabled(false);
							}
						}
						else if(i==4)//탄산음료
						{
							탄산음료_재고.setText(Integer.toString(Beverage_list[4].count));
							if(Beverage_list[4].count==0)
							{
								Soda.setEnabled(false);
							}
						}
					}
				}
				
			}
			client_order="";//고객 주문내용 삭제
			//데이터 표시
			Vendingmachine.this.Order_Output.setText("");
			Vendingmachine.this.Input_Output.setText(Integer.toString(money_input));
			Vendingmachine.this.Change_Output.setText(Integer.toString(money_input));
		}
	}
	
	//거스름돈 반환 버튼
	private class Change_Output_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			//1000원짜리 반환
			one_thousand_won_count=money_input/1000;
			money_input=money_input%1000;
			
			if(one_thousand_won_count>change.one_thousand)
			{
				while(one_thousand_won_count!=change.one_thousand)
				{
					one_thousand_won_count--;
					money_input=money_input+1000;
				}
			}
			change.one_thousand=change.one_thousand-one_thousand_won_count;
			천원_재고.setText(Integer.toString(change.one_thousand));
			
			//500원 반환
			five_hundred_won_count=money_input/500;
			money_input=money_input%500;
			
			if(five_hundred_won_count>change.five_hund)
			{
				while(five_hundred_won_count!=change.five_hund)
				{
					five_hundred_won_count--;
					money_input=money_input+500;
				}
			}
			change.five_hund=change.five_hund-five_hundred_won_count;
			오백원_재고.setText(Integer.toString(change.five_hund));
			
			//100원
			one_hundred_won_count=money_input/100;
			money_input=money_input%100;
			
			if(one_hundred_won_count>change.one_hund)
			{
				while(one_hundred_won_count!=change.one_hund)
				{
					one_hundred_won_count--;
					money_input=money_input+100;
				}
			}
			change.one_hund=change.one_hund-one_hundred_won_count;
			백원_재고.setText(Integer.toString(change.one_hund));
			
			//50원
			fifty_won_count=money_input/50;
			money_input=money_input%50;
			
			if(fifty_won_count>change.fifty)
			{
				while(fifty_won_count!=change.fifty)
				{
					fifty_won_count--;
					money_input=money_input+50;
				}
			}
			change.fifty=change.fifty-fifty_won_count;
			오십원_재고.setText(Integer.toString(change.fifty));
			
			//10원
			ten_won_count=money_input/10;
			money_input=money_input%10;
			
			if(ten_won_count>change.ten)
			{
				while(ten_won_count!=change.ten)
				{
					ten_won_count--;
					money_input=money_input+10;
				}
			}
			change.ten=change.ten-ten_won_count;
			십원_재고.setText(Integer.toString(change.ten));
			
			//잔돈이 남지 않았을 경우 해당하는 금액의 잔고없음을 자판기에 표시
			if(change.ten<=0)
			{
				십원없음.setText("10원없음");
			}
			if(change.fifty<=0)
			{
				오십원없음.setText("50원없음");
			}
			if(change.one_hund<=0)
			{
				백원없음.setText("100원없음");
			}
			if(change.five_hund<=0)
			{
				오백원없음.setText("500원없음");
			}
			if(change.one_thousand<=0)
			{
				천원없음.setText("1000원없음");
			}
			
			Vendingmachine.this.change_ten_won.setText(Integer.toString(ten_won_count));
			Vendingmachine.this.change_fifty_won.setText(Integer.toString(fifty_won_count));
			Vendingmachine.this.change_one_hundred_won.setText(Integer.toString(one_hundred_won_count));
			Vendingmachine.this.change_five_hundred_won.setText(Integer.toString(five_hundred_won_count));
			Vendingmachine.this.change_one_thousand_won.setText(Integer.toString(one_thousand_won_count));
			
			Vendingmachine.this.Change_Output.setText("0");
			Vendingmachine.this.Input_Output.setText("0");
		}
	}
	
	
	/*관리자창 제어부분 시작*/
	
	//관리자파트 로그인
	private class Manager_Login_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(access_code_input.getText().equals("qwer1234"))
			{
				물_재고_추가.setEnabled(true);
				커피_재고_추가.setEnabled(true);
				이온음료_재고_추가.setEnabled(true);
				프리미엄커피_재고_추가.setEnabled(true);
				탄산음료_재고_추가.setEnabled(true);
				십원_재고_추가.setEnabled(true);
				오십원_재고_추가.setEnabled(true);
				백원_재고_추가.setEnabled(true);
				오백원_재고_추가.setEnabled(true);
				천원_재고_추가.setEnabled(true);
				수입_출금.setEnabled(true);
				access_code_input.setText("");
			}
		}
	}
	
	//수금버튼
	private class Withdraw_Income_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			매출액.setText("0");
			selled=0;
		}
	}
	
	/*상품 재고 증가 버튼*/
	
	private class Stock_Plus implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
		
			//물 재고 추가
			if(b.getText().equals("물추가")) 
			{
				Beverage_list[0].count++;
				물_재고.setText(Integer.toString(Beverage_list[0].count));
				Water.setEnabled(true);
			}
			
			//커피 재고 추가
			if(b.getText().equals("커피추가"))
			{
				Beverage_list[1].count++;
				커피_재고.setText(Integer.toString(Beverage_list[1].count));
				Water.setEnabled(true);
			}
			
			//이온음료 재고 추가
			if(b.getText().equals("이온음료추가"))
			{
				Beverage_list[2].count++;
				이온음료_재고.setText(Integer.toString(Beverage_list[2].count));
				Water.setEnabled(true);
			}
			
			//프리미엄 커피 재고 추가
			if(b.getText().equals("프리미엄커피추가"))
			{
				Beverage_list[3].count++;
				프리미엄커피_재고.setText(Integer.toString(Beverage_list[3].count));
				Water.setEnabled(true);
			}
			
			//탄산음료 재고 추가
			if(b.getText().equals("탄산음료추가"))
			{
				Beverage_list[4].count++;
				탄산음료_재고.setText(Integer.toString(Beverage_list[4].count));
				Water.setEnabled(true);
			}
		}
	}
	
	/*거스름돈 재고 증가버튼*/
	private class Change_Plus implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
		
			//10원 추가
			if(b.getText().equals("10원 보충")) 
			{
				change.ten++;
				십원_재고.setText(Integer.toString(change.ten));
				십원없음.setText("");
			}
			
			//50원 추가
			if(b.getText().equals("50원 보충"))
			{
				change.fifty++;
				오십원_재고.setText(Integer.toString(change.fifty));
				오십원없음.setText("");
			}
			
			//100원 추가
			if(b.getText().equals("100원 보충"))
			{
				change.one_hund++;
				백원_재고.setText(Integer.toString(change.one_hund));
				백원없음.setText("");
			}
			
			//500원 추가
			if(b.getText().equals("500원 보충"))
			{
				change.five_hund++;
				오백원_재고.setText(Integer.toString(change.five_hund));
				오백원없음.setText("");
			}
			
			//1000원 추가
			if(b.getText().equals("1000원 보충"))
			{
				change.one_thousand++;
				천원_재고.setText(Integer.toString(change.one_thousand));
				천원없음.setText("");
			}
		}
	}
	
	//관리자파트 로그아웃
		private class Manager_Logout_Listener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(access_code_input.getText().equals("qwer1234"))
				{
					물_재고_추가.setEnabled(false);
					커피_재고_추가.setEnabled(false);
					이온음료_재고_추가.setEnabled(false);
					프리미엄커피_재고_추가.setEnabled(false);
					탄산음료_재고_추가.setEnabled(false);
					십원_재고_추가.setEnabled(false);
					오십원_재고_추가.setEnabled(false);
					백원_재고_추가.setEnabled(false);
					오백원_재고_추가.setEnabled(false);
					천원_재고_추가.setEnabled(false);
					수입_출금.setEnabled(false);
				}
			}
		}
	/*관리자창 제어부분 종료*/
	
	//Money 클래스 생성
	public class Money
	{
		int one_thousand;
		int five_hund;
		int one_hund;
		int fifty;
		int ten;
		
		public Money(int one_thousand,int five_hund, int one_hund,int fifty,int ten)
		{
			this.one_thousand=one_thousand;
			this.five_hund=five_hund;
			this.one_hund=one_hund;
			this.fifty=fifty;
			this.ten=ten;
		}
	}
	
	//Beverage 클래스 생성
	public class Beverage
	{
		String name;
		int count;
		int cost;
		
		public Beverage(String name,int count, int cost)
		{
			this.name=name;
			this.count=count;
			this.cost=cost;
		}
	}
	
	public static void main(String[] args)
	{
		Vendingmachine Mainframe = new Vendingmachine();
		Mainframe.setSize(1000, 900);
		Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Mainframe.setVisible(true);
	}
}
