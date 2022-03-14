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
	/*���Ǳ� �̿��� ���� ������ ��� ������Ʈ*/
	JTextField Order_Output;
	JTextField Input_Output;
	JTextField Change_Output;
	
	/*���� �ֹ� ��ư*/
	JButton Water;
	JButton Coffee;
	JButton Ion;
	JButton Premium_Coffee;
	JButton Soda;
	
	/*�Ž����� ��ȯ ���*/
	JTextField change_ten_won;
	JTextField change_fifty_won;
	JTextField change_one_hundred_won;
	JTextField change_five_hundred_won;
	JTextField change_one_thousand_won;
	
	/*�����ڸ޴� -> ��ǰ ���*/
	JTextField ��_���;
	JTextField Ŀ��_���;
	JTextField �̿�����_���;
	JTextField �����̾�Ŀ��_���;
	JTextField ź������_���;
	
	/*�����ڸ޴�->�Ž����� ���*/
	JTextField �ʿ�_���;
	JTextField ���ʿ�_���;
	JTextField ���_���;
	JTextField �����_���;
	JTextField õ��_���;
	
	JTextField �����;
	JButton ����_���;
	
	/*�Ž������� ������ ������ ������*/
	JTextField �ʿ�����;
	JTextField ���ʿ�����;
	JTextField �������;
	JTextField ���������;
	JTextField õ������;
	
	/*�����ڱ��� ���� ��й�ȣ �ؽ�Ʈ�ʵ�*/
	JTextField access_code_input;
	
	/*�Ž�����, ���� ��� 1 ������Ű�� ��ư*/
	JButton ��_���_�߰�;
	JButton Ŀ��_���_�߰�;
	JButton �̿�����_���_�߰�;
	JButton �����̾�Ŀ��_���_�߰�;
	JButton ź������_���_�߰�;
	
	JButton �ʿ�_���_�߰�;
	JButton ���ʿ�_���_�߰�;
	JButton ���_���_�߰�;
	JButton �����_���_�߰�;
	JButton õ��_���_�߰�;
	
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
		setTitle("Vending Machine");//���α׷��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//â�� ������ ���α׷� ����
		
		//���ᵥ���� Ŭ���� �迭�� ���� ������ ����
		Beverage_list[0]=new Beverage("��",3,450);
		Beverage_list[1]=new Beverage("Ŀ��",3,500);
		Beverage_list[2]=new Beverage("�̿�����",3,550);
		Beverage_list[3]=new Beverage("�����̾�Ŀ��",3,700);
		Beverage_list[4]=new Beverage("ź������",3,750);
		
		Container c=getContentPane();
		c.setBackground(Color.orange);
		c.setLayout(null);
		
		/*Ÿ��Ʋ ����*/
		JLabel Machine_Title=new JLabel("VendingMachine");
		Machine_Title.setFont(new Font("���� ���",Font.BOLD,20));
		Machine_Title.setLocation(200,10);
		Machine_Title.setSize(1000, 30);
		c.add(Machine_Title);
		
		//�� : �ֹ���ư, ����ǥ ��
		Water=new JButton("��");
		Water.setFont(new Font("����",Font.BOLD,15));
		Water.setLocation(50, 50);
		Water.setSize(100,35);
		Water.addActionListener(new Order_Button_Listener());
		
		c.add(Water);
		JLabel Water_Price=new JLabel("450��");
		Water_Price.setFont(new Font("���� ���",Font.BOLD,15));
		Water_Price.setLocation(160,50);
		Water_Price.setSize(300, 30);
		c.add(Water_Price);
		
		//Ŀ�� : �ֹ���ư, ����ǥ ��
		Coffee=new JButton("Ŀ��");
		Coffee.setFont(new Font("����",Font.BOLD,15));
		Coffee.setLocation(50,100);
		Coffee.setSize(100,35);
		Coffee.addActionListener(new Order_Button_Listener());
		c.add(Coffee);
		
		JLabel Coffee_Price=new JLabel("500��");
		Coffee_Price.setFont(new Font("���� ���",Font.BOLD,15));
		Coffee_Price.setLocation(160,100);
		Coffee_Price.setSize(300, 30);
		c.add(Coffee_Price);
		
		//�̿����� : �ֹ���ư, ����ǥ ��
		Ion=new JButton("�̿�����");
		Ion.setFont(new Font("����",Font.BOLD,15));
		Ion.setLocation(50, 150);
		Ion.setSize(100,35);
		Ion.addActionListener(new Order_Button_Listener());
		c.add(Ion);
		
		JLabel Ion_Price=new JLabel("550��");
		Ion_Price.setFont(new Font("���� ���",Font.BOLD,15));
		Ion_Price.setLocation(160,150);
		Ion_Price.setSize(100, 35);
		c.add(Ion_Price);
		
		//�����̾� Ŀ�� : �ֹ���ư, ����ǥ ��
		Premium_Coffee=new JButton("�����̾�Ŀ��");
		Premium_Coffee.setFont(new Font("����",Font.BOLD,10));
		Premium_Coffee.setLocation(50, 200);
		Premium_Coffee.setSize(100,35);
		Premium_Coffee.addActionListener(new Order_Button_Listener());
		c.add(Premium_Coffee);
		
		JLabel Premium_Coffee_Price=new JLabel("700��");
		Premium_Coffee_Price.setFont(new Font("���� ���",Font.BOLD,15));
		Premium_Coffee_Price.setLocation(160,200);
		Premium_Coffee_Price.setSize(300, 30);
		c.add(Premium_Coffee_Price);
		
		//ź������ : �ֹ���ư, ����ǥ ��
		Soda=new JButton("ź������");
		Soda.setFont(new Font("����",Font.BOLD,15));
		Soda.setLocation(50, 250);
		Soda.setSize(100,35);
		Soda.addActionListener(new Order_Button_Listener());
		c.add(Soda);
		
		JLabel Soda_Price=new JLabel("750��");
		Soda_Price.setFont(new Font("���� ���",Font.BOLD,15));
		Soda_Price.setLocation(160,250);
		Soda_Price.setSize(300, 30);
		c.add(Soda_Price);
		
		/*��ȯ�� �Ž����� ��� ������ �̸� ǥ������*/
		
		//10��
		�ʿ�����=new JTextField("");
		�ʿ�����.setFont(new Font("����",Font.BOLD,13));
		�ʿ�����.setLocation(300, 50);
		�ʿ�����.setSize(100, 30);
		c.add(�ʿ�����);
		
		//50��
		���ʿ�����=new JTextField("");
		���ʿ�����.setFont(new Font("����",Font.BOLD,13));
		���ʿ�����.setLocation(300, 100);
		���ʿ�����.setSize(100, 30);
		c.add(���ʿ�����);
		
		//100��
		�������=new JTextField("");
		�������.setFont(new Font("����",Font.BOLD,13));
		�������.setLocation(300, 150);
		�������.setSize(100, 30);
		c.add(�������);
		
		���������=new JTextField("");
		���������.setFont(new Font("����",Font.BOLD,13));
		���������.setLocation(300, 200);
		���������.setSize(100, 30);
		c.add(���������);
		
		õ������=new JTextField("");
		õ������.setFont(new Font("����",Font.BOLD,13));
		õ������.setLocation(300, 250);
		õ������.setSize(100, 30);
		c.add(õ������);
		
		/*���� �Է��ϴ� ��ư : ���� ������ ���� ���� �����ϱ� ���Ƿ� ����*/
		JLabel Money_Input_Title=new JLabel("<�Ʒ� �� ��ư���� �� �ֱ�>");
		Money_Input_Title.setFont(new Font("����",Font.BOLD,15));
		Money_Input_Title.setLocation(50, 320);
		Money_Input_Title.setSize(300, 30);
		c.add(Money_Input_Title);
		
		JButton ten_won=new JButton("10");
		ten_won.setFont(new Font("����",Font.BOLD,15));
		ten_won.setLocation(40, 350);
		ten_won.setSize(80, 30);
		ten_won.addActionListener(new Money_Input_Listener());
		c.add(ten_won);

		JButton fifty_won=new JButton("50");
		fifty_won.setFont(new Font("����",Font.BOLD,15));
		fifty_won.setLocation(120, 350);
		fifty_won.setSize(80, 30);
		fifty_won.addActionListener(new Money_Input_Listener());
		c.add(fifty_won);
		
		JButton one_hundred_won=new JButton("100");
		one_hundred_won.setFont(new Font("����",Font.BOLD,15));
		one_hundred_won.setLocation(200, 350);
		one_hundred_won.setSize(80, 30);
		one_hundred_won.addActionListener(new Money_Input_Listener());
		c.add(one_hundred_won);
		
		JButton five_hundred_won=new JButton("500");
		five_hundred_won.setFont(new Font("����",Font.BOLD,15));
		five_hundred_won.setLocation(280, 350);
		five_hundred_won.setSize(80, 30);
		five_hundred_won.addActionListener(new Money_Input_Listener());
		c.add(five_hundred_won);
		
		JButton one_thousand_won=new JButton("1000");
		one_thousand_won.setFont(new Font("����",Font.BOLD,15));
		one_thousand_won.setLocation(360, 350);
		one_thousand_won.setSize(80, 30);
		one_thousand_won.addActionListener(new Money_Input_Listener());
		c.add(one_thousand_won);
		
		/*���� ���� ���� ȭ�鿡 ���*/
		JLabel Money = new JLabel("���� ��");
		Money.setFont(new Font("���� ���",Font.BOLD,15));
		Money.setLocation(50, 400);
		Money.setSize(100,30);
		c.add(Money);
		
		Input_Output=new JTextField("0");
		Input_Output.setEnabled(false);
		Input_Output.setFont(new Font("���� ���",Font.BOLD,15));
		Input_Output.setLocation(150, 400);
		Input_Output.setSize(100,30);
		c.add(Input_Output);
		
		/*���� ������ ������� ���*/
		JLabel Order = new JLabel("������ ����");
		Order.setFont(new Font("���� ���",Font.BOLD,15));
		Order.setLocation(50, 450);
		Order.setSize(500,30);
		c.add(Order);
		
		Order_Output=new JTextField("");
		Order_Output.setEnabled(false);
		Order_Output.setFont(new Font("���� ���",Font.BOLD,15));
		Order_Output.setLocation(150, 450);
		Order_Output.setSize(100,30);
		c.add(Order_Output);
		
		//����̱� ��ư
		JButton Calculate=new JButton("���� �̱�");
		Calculate.setFont(new Font("���� ���",Font.BOLD,15));
		Calculate.setLocation(250, 450);
		Calculate.setSize(100,30);
		Calculate.addActionListener(new Calculate_Listener());
		c.add(Calculate);
		
		/*�Ž����� ���*/
		JLabel Change = new JLabel("�Ž�����");
		Change.setFont(new Font("���� ���",Font.BOLD,15));
		Change.setLocation(50, 500);
		Change.setSize(500,30);
		c.add(Change);
		
		Change_Output=new JTextField("0");
		Change_Output.setEnabled(false);
		Change_Output.setFont(new Font("���� ���",Font.BOLD,15));
		Change_Output.setLocation(150, 500);
		Change_Output.setSize(100,30);
		c.add(Change_Output);
		
		/*�Ž������� ������ ��ȯ*/
		
		//��ȯ��ư
		JButton Change_Output=new JButton("�Ž����� ��ȯ");
		Change_Output.setFont(new Font("���� ���",Font.BOLD,15));
		Change_Output.setLocation(250, 500);
		Change_Output.setSize(130,50);
		Change_Output.addActionListener(new Change_Output_Listener());
		c.add(Change_Output);
		
		//10�� ����
		JLabel Moneyback_ten = new JLabel("10��");
		Moneyback_ten.setFont(new Font("���� ���",Font.BOLD,15));
		Moneyback_ten.setLocation(50, 580);
		Moneyback_ten.setSize(500,30);
		c.add(Moneyback_ten);
		
		change_ten_won=new JTextField();
		change_ten_won.setText("0");
		change_ten_won.setEnabled(false);
		change_ten_won.setFont(new Font("���� ���",Font.BOLD,15));
		change_ten_won.setLocation(50, 610);
		change_ten_won.setSize(80,30);
		c.add(change_ten_won);
		
		//50�� ����
		JLabel Moneyback_fifty = new JLabel("50��");
		Moneyback_fifty.setFont(new Font("���� ���",Font.BOLD,15));
		Moneyback_fifty.setLocation(150, 580);
		Moneyback_fifty.setSize(500,30);
		c.add(Moneyback_fifty);
		
		change_fifty_won=new JTextField();
		change_fifty_won.setText("0");
		change_fifty_won.setEnabled(false);
		change_fifty_won.setFont(new Font("���� ���",Font.BOLD,15));
		change_fifty_won.setLocation(150, 610);
		change_fifty_won.setSize(80,30);
		c.add(change_fifty_won);
		
		//100�� ����
		JLabel Moneyback_one_hundred = new JLabel("100��");
		Moneyback_one_hundred.setFont(new Font("���� ���",Font.BOLD,15));
		Moneyback_one_hundred.setLocation(250, 580);
		Moneyback_one_hundred.setSize(500,30);
		c.add(Moneyback_one_hundred);
		
		change_one_hundred_won=new JTextField();
		change_one_hundred_won.setText("0");
		change_one_hundred_won.setEnabled(false);
		change_one_hundred_won.setFont(new Font("���� ���",Font.BOLD,15));
		change_one_hundred_won.setLocation(250, 610);
		change_one_hundred_won.setSize(80,30);
		c.add(change_one_hundred_won);
		
		//500��
		JLabel Moneyback_five_hundred = new JLabel("500��");
		Moneyback_five_hundred.setFont(new Font("���� ���",Font.BOLD,15));
		Moneyback_five_hundred.setLocation(350, 580);
		Moneyback_five_hundred.setSize(500,30);
		c.add(Moneyback_five_hundred);
		
		change_five_hundred_won=new JTextField();
		change_five_hundred_won.setText("0");
		change_five_hundred_won.setEnabled(false);
		change_five_hundred_won.setFont(new Font("���� ���",Font.BOLD,15));
		change_five_hundred_won.setLocation(350, 610);
		change_five_hundred_won.setSize(80,30);
		c.add(change_five_hundred_won);
		
		//1000��
		JLabel Moneyback_one_thousand = new JLabel("1000��");
		Moneyback_one_thousand.setFont(new Font("���� ���",Font.BOLD,15));
		Moneyback_one_thousand.setLocation(450, 580);
		Moneyback_one_thousand.setSize(500,30);
		c.add(Moneyback_one_thousand);
		
		change_one_thousand_won=new JTextField();
		change_one_thousand_won.setText("0");
		change_one_thousand_won.setEnabled(false);
		change_one_thousand_won.setFont(new Font("���� ���",Font.BOLD,15));
		change_one_thousand_won.setLocation(450, 610);
		change_one_thousand_won.setSize(80,30);
		c.add(change_one_thousand_won);
		
		
		/*������ �޴�*/
		JLabel Manager_Menu = new JLabel("<������ �޴�>");
		Manager_Menu.setFont(new Font("���� ���",Font.BOLD,18));
		Manager_Menu.setLocation(680, 100);
		Manager_Menu.setSize(300,30);
		c.add(Manager_Menu);
		
		/*������ �޴� �α���*/
		JLabel access_code= new JLabel("��й�ȣ �Է�");//��й�ȣ�� qwer1234
		access_code.setFont(new Font("���� ���",Font.BOLD,13));
		access_code.setLocation(580, 130);
		access_code.setSize(100,30);
		c.add(access_code);
		
		access_code_input=new JTextField();
		access_code_input.setEnabled(true);
		access_code_input.setFont(new Font("���� ���",Font.BOLD,15));
		access_code_input.setLocation(680, 130);
		access_code_input.setSize(100,30);
		c.add(access_code_input);
		
		JButton Login= new JButton("Login");
		Login.setFont(new Font("����",Font.BOLD,15));
		Login.setLocation(780, 130);
		Login.setSize(90,30);
		Login.addActionListener(new Manager_Login_Listener());
		c.add(Login);
		
		/*���Ǳ� �ȿ� �ִ� ���� ���*/
		
		//�� ���
		JLabel Water_stock = new JLabel("�� ���");
		Water_stock.setFont(new Font("���� ���",Font.BOLD,15));
		Water_stock.setLocation(580, 180);
		Water_stock.setSize(300,30);
		c.add(Water_stock);
		
		��_���=new JTextField();
		��_���.setText(Integer.toString(Beverage_list[0].count));
		��_���.setEnabled(false);
		��_���.setFont(new Font("���� ���",Font.BOLD,15));
		��_���.setLocation(750, 180);
		��_���.setSize(50,30);
		c.add(��_���);
		
		��_���_�߰�=new JButton("���߰�");
		��_���_�߰�.setEnabled(false);
		��_���_�߰�.setFont(new Font("���� ���",Font.BOLD,13));
		��_���_�߰�.setLocation(810, 180);
		��_���_�߰�.setSize(120,30);
		��_���_�߰�.addActionListener(new Stock_Plus());
		c.add(��_���_�߰�);
		
		//Ŀ��
		JLabel Coffee_stock = new JLabel("Ŀ�� ���");
		Coffee_stock.setFont(new Font("���� ���",Font.BOLD,15));
		Coffee_stock.setLocation(580, 230);
		Coffee_stock.setSize(300,30);
		c.add(Coffee_stock);
		
		Ŀ��_���=new JTextField();
		Ŀ��_���.setText(Integer.toString(Beverage_list[1].count));
		Ŀ��_���.setEnabled(false);
		Ŀ��_���.setFont(new Font("���� ���",Font.BOLD,15));
		Ŀ��_���.setLocation(750, 230);
		Ŀ��_���.setSize(50,30);
		c.add(Ŀ��_���);
		
		Ŀ��_���_�߰�=new JButton("Ŀ���߰�");
		Ŀ��_���_�߰�.setEnabled(false);
		Ŀ��_���_�߰�.setFont(new Font("���� ���",Font.BOLD,13));
		Ŀ��_���_�߰�.setLocation(810, 230);
		Ŀ��_���_�߰�.setSize(120,30);
		Ŀ��_���_�߰�.addActionListener(new Stock_Plus());
		c.add(Ŀ��_���_�߰�);
		
		//�̿�����
		JLabel Ion_stock = new JLabel("�̿����� ���");
		Ion_stock.setFont(new Font("���� ���",Font.BOLD,15));
		Ion_stock.setLocation(580, 280);
		Ion_stock.setSize(300,30);
		c.add(Ion_stock);
		
		�̿�����_���=new JTextField();
		�̿�����_���.setText(Integer.toString(Beverage_list[2].count));
		�̿�����_���.setEnabled(false);
		�̿�����_���.setFont(new Font("���� ���",Font.BOLD,15));
		�̿�����_���.setLocation(750, 280);
		�̿�����_���.setSize(50,30);
		c.add(�̿�����_���);
		
		�̿�����_���_�߰�=new JButton("�̿������߰�");
		�̿�����_���_�߰�.setEnabled(false);
		�̿�����_���_�߰�.setFont(new Font("���� ���",Font.BOLD,13));
		�̿�����_���_�߰�.setLocation(810, 280);
		�̿�����_���_�߰�.setSize(120,30);
		�̿�����_���_�߰�.addActionListener(new Stock_Plus());
		c.add(�̿�����_���_�߰�);
		
		//�����̾�Ŀ��
		JLabel Premium_Coffee_stock = new JLabel("�����̾�Ŀ�� ���");
		Premium_Coffee_stock.setFont(new Font("���� ���",Font.BOLD,15));
		Premium_Coffee_stock.setLocation(580, 330);
		Premium_Coffee_stock.setSize(300,30);
		c.add(Premium_Coffee_stock);
		
		�����̾�Ŀ��_���=new JTextField();
		�����̾�Ŀ��_���.setText(Integer.toString(Beverage_list[3].count));
		�����̾�Ŀ��_���.setEnabled(false);
		�����̾�Ŀ��_���.setFont(new Font("���� ���",Font.BOLD,15));
		�����̾�Ŀ��_���.setLocation(750, 330);
		�����̾�Ŀ��_���.setSize(50,30);
		c.add(�����̾�Ŀ��_���);
		
		�����̾�Ŀ��_���_�߰�=new JButton("�����̾�Ŀ���߰�");
		�����̾�Ŀ��_���_�߰�.setEnabled(false);
		�����̾�Ŀ��_���_�߰�.setFont(new Font("���� ���",Font.BOLD,10));
		�����̾�Ŀ��_���_�߰�.setLocation(810, 330);
		�����̾�Ŀ��_���_�߰�.setSize(120,30);
		�����̾�Ŀ��_���_�߰�.addActionListener(new Stock_Plus());
		c.add(�����̾�Ŀ��_���_�߰�);
		
		//ź������
		JLabel Soda_stock = new JLabel("ź������ ���");
		Soda_stock.setFont(new Font("���� ���",Font.BOLD,15));
		Soda_stock.setLocation(580, 380);
		Soda_stock.setSize(300,30);
		c.add(Soda_stock);
		
		ź������_���=new JTextField();
		ź������_���.setText(Integer.toString(Beverage_list[4].count));
		ź������_���.setEnabled(false);
		ź������_���.setFont(new Font("���� ���",Font.BOLD,15));
		ź������_���.setLocation(750, 380);
		ź������_���.setSize(50,30);
		c.add(ź������_���);
		
		ź������_���_�߰�=new JButton("ź�������߰�");
		ź������_���_�߰�.setEnabled(false);
		ź������_���_�߰�.setFont(new Font("���� ���",Font.BOLD,13));
		ź������_���_�߰�.setLocation(810, 380);
		ź������_���_�߰�.setSize(120,30);
		ź������_���_�߰�.addActionListener(new Stock_Plus());
		c.add(ź������_���_�߰�);
		
		//�Ž����� ���
		
		//10��
		JLabel �ʿ���� = new JLabel("10�� ���");
		�ʿ����.setFont(new Font("���� ���",Font.BOLD,15));
		�ʿ����.setLocation(580, 450);
		�ʿ����.setSize(300,30);
		c.add(�ʿ����);
		
		�ʿ�_���=new JTextField();
		�ʿ�_���.setText(Integer.toString(change.ten));
		�ʿ�_���.setEnabled(false);
		�ʿ�_���.setFont(new Font("���� ���",Font.BOLD,15));
		�ʿ�_���.setLocation(750, 450);
		�ʿ�_���.setSize(50,30);
		c.add(�ʿ�_���);
		
		�ʿ�_���_�߰�=new JButton("10�� ����");
		�ʿ�_���_�߰�.setEnabled(false);
		�ʿ�_���_�߰�.setFont(new Font("���� ���",Font.BOLD,15));
		�ʿ�_���_�߰�.setLocation(810, 450);
		�ʿ�_���_�߰�.setSize(120,30);
		�ʿ�_���_�߰�.addActionListener(new Change_Plus());
		c.add(�ʿ�_���_�߰�);
		
		//50��
		JLabel ���ʿ���� = new JLabel("50�� ���");
		���ʿ����.setFont(new Font("���� ���",Font.BOLD,15));
		���ʿ����.setLocation(580, 500);
		���ʿ����.setSize(300,30);
		c.add(���ʿ����);
		
		���ʿ�_���=new JTextField();
		���ʿ�_���.setText(Integer.toString(change.fifty));
		���ʿ�_���.setEnabled(false);
		���ʿ�_���.setFont(new Font("���� ���",Font.BOLD,15));
		���ʿ�_���.setLocation(750, 500);
		���ʿ�_���.setSize(50,30);
		c.add(���ʿ�_���);
		
		���ʿ�_���_�߰�=new JButton("50�� ����");
		���ʿ�_���_�߰�.setEnabled(false);
		���ʿ�_���_�߰�.setFont(new Font("���� ���",Font.BOLD,15));
		���ʿ�_���_�߰�.setLocation(810, 500);
		���ʿ�_���_�߰�.setSize(120,30);
		���ʿ�_���_�߰�.addActionListener(new Change_Plus());
		c.add(���ʿ�_���_�߰�);
		
		//100��
		JLabel ������ = new JLabel("100�� ���");
		������.setFont(new Font("���� ���",Font.BOLD,15));
		������.setLocation(580, 550);
		������.setSize(300,30);
		c.add(������);
		
		���_���=new JTextField();
		���_���.setText(Integer.toString(change.one_hund));
		���_���.setEnabled(false);
		���_���.setFont(new Font("���� ���",Font.BOLD,15));
		���_���.setLocation(750, 550);
		���_���.setSize(50,30);
		c.add(���_���);
		
		���_���_�߰�=new JButton("100�� ����");
		���_���_�߰�.setEnabled(false);
		���_���_�߰�.setFont(new Font("���� ���",Font.BOLD,15));
		���_���_�߰�.setLocation(810, 550);
		���_���_�߰�.setSize(120,30);
		���_���_�߰�.addActionListener(new Change_Plus());
		c.add(���_���_�߰�);
		
		//500��
		JLabel �������� = new JLabel("500�� ���");
		��������.setFont(new Font("���� ���",Font.BOLD,15));
		��������.setLocation(580, 600);
		��������.setSize(300,30);
		c.add(��������);
		
		�����_���=new JTextField();
		�����_���.setText(Integer.toString(change.five_hund));
		�����_���.setEnabled(false);
		�����_���.setFont(new Font("���� ���",Font.BOLD,15));
		�����_���.setLocation(750, 600);
		�����_���.setSize(50,30);
		c.add(�����_���);
		
		�����_���_�߰�=new JButton("500�� ����");
		�����_���_�߰�.setEnabled(false);
		�����_���_�߰�.setFont(new Font("���� ���",Font.BOLD,15));
		�����_���_�߰�.setLocation(810, 600);
		�����_���_�߰�.setSize(120,30);
		�����_���_�߰�.addActionListener(new Change_Plus());
		c.add(�����_���_�߰�);
		
		//1000��
		JLabel õ����� = new JLabel("1000�� ���");
		õ�����.setFont(new Font("���� ���",Font.BOLD,15));
		õ�����.setLocation(580, 650);
		õ�����.setSize(300,30);
		c.add(õ�����);
		
		õ��_���=new JTextField();
		õ��_���.setText(Integer.toString(change.one_thousand));
		õ��_���.setEnabled(false);
		õ��_���.setFont(new Font("���� ���",Font.BOLD,15));
		õ��_���.setLocation(750, 650);
		õ��_���.setSize(50,30);
		c.add(õ��_���);
		
		õ��_���_�߰�=new JButton("1000�� ����");
		õ��_���_�߰�.setEnabled(false);
		õ��_���_�߰�.setFont(new Font("���� ���",Font.BOLD,15));
		õ��_���_�߰�.setLocation(810, 650);
		õ��_���_�߰�.setSize(120,30);
		õ��_���_�߰�.addActionListener(new Change_Plus());
		c.add(õ��_���_�߰�);
		
		/*�����*/
		JLabel ���� = new JLabel("����");
		����.setFont(new Font("���� ���",Font.BOLD,15));
		����.setLocation(580, 700);
		����.setSize(300,30);
		c.add(����);
		
		�����=new JTextField("0");
		�����.setEnabled(false);
		�����.setFont(new Font("���� ���",Font.BOLD,15));
		�����.setLocation(680, 700);
		�����.setSize(100,30);
		c.add(�����);
		
		����_���=new JButton("�� ����");
		����_���.setEnabled(false);
		����_���.setFont(new Font("���� ���",Font.BOLD,15));
		����_���.setLocation(780, 700);
		����_���.setSize(100,30);
		����_���.addActionListener(new Withdraw_Income_Listener());
		c.add(����_���);
		
		/*�����ڸ޴� �α׾ƿ�*/
		JButton �����Ϸ�=new JButton("���� �Ϸ�");
		�����Ϸ�.setEnabled(true);
		�����Ϸ�.setFont(new Font("���� ���",Font.BOLD,15));
		�����Ϸ�.setLocation(800, 800);
		�����Ϸ�.setSize(120,30);
		�����Ϸ�.addActionListener(new Manager_Logout_Listener());
		c.add(�����Ϸ�);
	}
		
	//�����ֹ� ��ư �׼Ǹ�����
	private class Order_Button_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton a = (JButton)e.getSource();//�̺�Ʈ�ҽ� ��ư �˾Ƴ���
			Vendingmachine.this.Order_Output.setText(a.getText());//�ֹ��� ���� �̸��ؽ�Ʈ�� �ҷ��� Order_Output�� ����
			client_order=a.getText();//client_order�� �ֹ� ����
		}
	}
		
	//10��,50��,100��,500��,1000�� �߰� ��ư(��, ���� ���� ������ 5000���� ���� ����)
	private class Money_Input_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
				
			//10��
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
				//�ʿ�_���.setText(Integer.toString(change.ten));
			}
				
			//50��
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
				//���ʿ�_���.setText(Integer.toString(change.fifty));
			}
				
			//100��
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
				//���_���.setText(Integer.toString(change.one_hund));
			}
			
			//500��
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
				//�����_���.setText(Integer.toString(change.five_hund));
			}
			
			//1000��
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
				//õ��_���.setText(Integer.toString(change.one_thousand));
			}
		}
	}
	
	//����̱� ��ư
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
						Beverage_list[i].count--;//�ش�
						selled=selled+Beverage_list[i].cost;
						�����.setText(Integer.toString(selled));
						
						if(i==0)//��
						{
							��_���.setText(Integer.toString(Beverage_list[0].count));
							if(Beverage_list[0].count==0)
							{
								Water.setEnabled(false);
							}
						}
						else if(i==1)//Ŀ��
						{
							Ŀ��_���.setText(Integer.toString(Beverage_list[1].count));
							if(Beverage_list[1].count==0)
							{
								Coffee.setEnabled(false);
							}
						}
						else if(i==2)//�̿�����
						{
							�̿�����_���.setText(Integer.toString(Beverage_list[2].count));
							if(Beverage_list[2].count==0)
							{
								Ion.setEnabled(false);
							}
						}
						else if(i==3)//�����̾�Ŀ��
						{
							�����̾�Ŀ��_���.setText(Integer.toString(Beverage_list[3].count));
							if(Beverage_list[3].count==0)
							{
								Premium_Coffee.setEnabled(false);
							}
						}
						else if(i==4)//ź������
						{
							ź������_���.setText(Integer.toString(Beverage_list[4].count));
							if(Beverage_list[4].count==0)
							{
								Soda.setEnabled(false);
							}
						}
					}
				}
				
			}
			client_order="";//�� �ֹ����� ����
			//������ ǥ��
			Vendingmachine.this.Order_Output.setText("");
			Vendingmachine.this.Input_Output.setText(Integer.toString(money_input));
			Vendingmachine.this.Change_Output.setText(Integer.toString(money_input));
		}
	}
	
	//�Ž����� ��ȯ ��ư
	private class Change_Output_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			//1000��¥�� ��ȯ
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
			õ��_���.setText(Integer.toString(change.one_thousand));
			
			//500�� ��ȯ
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
			�����_���.setText(Integer.toString(change.five_hund));
			
			//100��
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
			���_���.setText(Integer.toString(change.one_hund));
			
			//50��
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
			���ʿ�_���.setText(Integer.toString(change.fifty));
			
			//10��
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
			�ʿ�_���.setText(Integer.toString(change.ten));
			
			//�ܵ��� ���� �ʾ��� ��� �ش��ϴ� �ݾ��� �ܰ������ ���Ǳ⿡ ǥ��
			if(change.ten<=0)
			{
				�ʿ�����.setText("10������");
			}
			if(change.fifty<=0)
			{
				���ʿ�����.setText("50������");
			}
			if(change.one_hund<=0)
			{
				�������.setText("100������");
			}
			if(change.five_hund<=0)
			{
				���������.setText("500������");
			}
			if(change.one_thousand<=0)
			{
				õ������.setText("1000������");
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
	
	
	/*������â ����κ� ����*/
	
	//��������Ʈ �α���
	private class Manager_Login_Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(access_code_input.getText().equals("qwer1234"))
			{
				��_���_�߰�.setEnabled(true);
				Ŀ��_���_�߰�.setEnabled(true);
				�̿�����_���_�߰�.setEnabled(true);
				�����̾�Ŀ��_���_�߰�.setEnabled(true);
				ź������_���_�߰�.setEnabled(true);
				�ʿ�_���_�߰�.setEnabled(true);
				���ʿ�_���_�߰�.setEnabled(true);
				���_���_�߰�.setEnabled(true);
				�����_���_�߰�.setEnabled(true);
				õ��_���_�߰�.setEnabled(true);
				����_���.setEnabled(true);
				access_code_input.setText("");
			}
		}
	}
	
	//���ݹ�ư
	private class Withdraw_Income_Listener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			�����.setText("0");
			selled=0;
		}
	}
	
	/*��ǰ ��� ���� ��ư*/
	
	private class Stock_Plus implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
		
			//�� ��� �߰�
			if(b.getText().equals("���߰�")) 
			{
				Beverage_list[0].count++;
				��_���.setText(Integer.toString(Beverage_list[0].count));
				Water.setEnabled(true);
			}
			
			//Ŀ�� ��� �߰�
			if(b.getText().equals("Ŀ���߰�"))
			{
				Beverage_list[1].count++;
				Ŀ��_���.setText(Integer.toString(Beverage_list[1].count));
				Water.setEnabled(true);
			}
			
			//�̿����� ��� �߰�
			if(b.getText().equals("�̿������߰�"))
			{
				Beverage_list[2].count++;
				�̿�����_���.setText(Integer.toString(Beverage_list[2].count));
				Water.setEnabled(true);
			}
			
			//�����̾� Ŀ�� ��� �߰�
			if(b.getText().equals("�����̾�Ŀ���߰�"))
			{
				Beverage_list[3].count++;
				�����̾�Ŀ��_���.setText(Integer.toString(Beverage_list[3].count));
				Water.setEnabled(true);
			}
			
			//ź������ ��� �߰�
			if(b.getText().equals("ź�������߰�"))
			{
				Beverage_list[4].count++;
				ź������_���.setText(Integer.toString(Beverage_list[4].count));
				Water.setEnabled(true);
			}
		}
	}
	
	/*�Ž����� ��� ������ư*/
	private class Change_Plus implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JButton b=(JButton)e.getSource();
		
			//10�� �߰�
			if(b.getText().equals("10�� ����")) 
			{
				change.ten++;
				�ʿ�_���.setText(Integer.toString(change.ten));
				�ʿ�����.setText("");
			}
			
			//50�� �߰�
			if(b.getText().equals("50�� ����"))
			{
				change.fifty++;
				���ʿ�_���.setText(Integer.toString(change.fifty));
				���ʿ�����.setText("");
			}
			
			//100�� �߰�
			if(b.getText().equals("100�� ����"))
			{
				change.one_hund++;
				���_���.setText(Integer.toString(change.one_hund));
				�������.setText("");
			}
			
			//500�� �߰�
			if(b.getText().equals("500�� ����"))
			{
				change.five_hund++;
				�����_���.setText(Integer.toString(change.five_hund));
				���������.setText("");
			}
			
			//1000�� �߰�
			if(b.getText().equals("1000�� ����"))
			{
				change.one_thousand++;
				õ��_���.setText(Integer.toString(change.one_thousand));
				õ������.setText("");
			}
		}
	}
	
	//��������Ʈ �α׾ƿ�
		private class Manager_Logout_Listener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if(access_code_input.getText().equals("qwer1234"))
				{
					��_���_�߰�.setEnabled(false);
					Ŀ��_���_�߰�.setEnabled(false);
					�̿�����_���_�߰�.setEnabled(false);
					�����̾�Ŀ��_���_�߰�.setEnabled(false);
					ź������_���_�߰�.setEnabled(false);
					�ʿ�_���_�߰�.setEnabled(false);
					���ʿ�_���_�߰�.setEnabled(false);
					���_���_�߰�.setEnabled(false);
					�����_���_�߰�.setEnabled(false);
					õ��_���_�߰�.setEnabled(false);
					����_���.setEnabled(false);
				}
			}
		}
	/*������â ����κ� ����*/
	
	//Money Ŭ���� ����
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
	
	//Beverage Ŭ���� ����
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
