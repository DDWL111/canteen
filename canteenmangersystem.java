package ST1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
public class STmaster extends JFrame{
	static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=ST";
	static String us="sa";
	static String pw="123456";
static void main_1() {//主界面
	    final JFrame jf1=new JFrame("食堂管理系统");
		JButton b1,b2;
		JPanel jp1;
		b1=new JButton("点餐");
		b2=new JButton("充值");
		jp1=new JPanel();
		jp1.setLayout(null);
		b1.setSize(150,50);
		b1.setLocation(325, 150);
		b1.setVisible(true);
		b1.setFont(new Font("隶书",Font.PLAIN,20));
		jp1.add(b1);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				usermessage();
				jf1.dispose();
			}
		});
		b2.setSize(150,50);
		b2.setLocation(325, 250);
		b2.setFont(new Font("隶书",Font.PLAIN,20));
		b2.setVisible(true);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userborrow();
				jf1.dispose();
			}
		});
		jp1.add(b2);
		jf1.add(jp1,BorderLayout.CENTER);
		jf1.setSize(800,600);
		jf1.setVisible(true);
		jf1.setLocation(500, 300);
		jf1.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
static void userborrow() {//充值界面
	final JFrame jf1;
	JPanel jp1;
	JButton b1,b2;
	final JTextField t1;
	final JTextField t2;
	final JTextField t3;
	JLabel lb1,lb2,lb3;
	jf1=new JFrame("充值");
	jf1.setSize(800,600); 
	jf1.setLocation(500,300);
	jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	jf1.setVisible(true);
	jp1=new JPanel();
	lb1=new JLabel("充值金额：",JLabel.CENTER); 
	lb1.setFont(new Font("隶书",Font.PLAIN,20)); 
	lb1.setBounds(280,170, 120, 20);
	lb2=new JLabel("输入账号：",JLabel.CENTER); 
	lb2.setFont(new Font("隶书",Font.PLAIN,20));
	lb2.setBounds(280, 200, 120, 20);
	t1=new JTextField(); 
	t1.setBounds(400, 170, 100, 20);
	t2=new JTextField(); 
	t2.setBounds(400, 200, 100, 20);
	b1=new JButton("充值");
	b1.setSize(90,60);
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setLocation(355,300);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			addok();
		}
	});
	b2=new JButton("返回");
	b2.setFont(new Font("隶书",Font.PLAIN,20));
	b2.setSize(90,40);
	b2.setLocation(650,480);
	b2.setVisible(true);
	b2.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			main_1();
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(t1);
	jp1.add(b2);
	jp1.add(b1);
	jp1.add(lb2);
	//jp1.add(lb3);
	jp1.add(t2);
	//jp1.add(t3);
}

static void usermessage() {//食堂点餐界面
	//定义一些控件
		final JFrame jf1;
		JTable jt;
		JScrollPane jsp;
		JPanel jp1;
		jf1=new JFrame("点餐");
		jf1.setSize(800,600);
		jf1.setLocation(500, 300);
		jf1.setVisible(true);
		jf1.setLayout(null);
		jf1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton b1,b2,b3,b4;
		JLabel lb1,lb2,lb3,lb4;
		final JTextField t1;
		final JTextField t2;
		jp1=new JPanel();
		t1=new JTextField();
		t2=new JTextField();
		t1.setBounds(170, 60,40,30);
		t2.setBounds(170, 110, 40, 30);
		b1=new JButton("购买");
		b1.setSize(60, 30);
		b1.setLocation(60,60);
		b1.setFont(new Font("隶书",Font.PLAIN,12));
		b1.setVisible(true);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String a=t1.getText();
				if(a.equals("")){
					nullError();
		}else {
			//int n1=Integer.parseInt(t1.getText());
				//Updateuser(n1);
			okUPdate();
		}
			}
		});
		b2=new JButton("删除");
		b2.setSize(60, 30);
		b2.setLocation(60,110);
		b2.setFont(new Font("隶书",Font.PLAIN,12));
		b2.setVisible(true);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String a=t2.getText();
				if(a.equals("")){
					nullError();
		}else {
			int n1=Integer.parseInt(a);
				try {
					peopleDel(n1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Delok();
		}
				
			}
		});
		lb1=new JLabel("id为");
		lb1.setSize(30, 30);
		lb1.setLocation(130, 60);
		lb1.setVisible(true);
		lb3=new JLabel("菜品");
		lb3.setSize(60, 30);
		lb3.setLocation(220, 60);
		lb3.setVisible(true);
		b4=new JButton("返回");
		b4.setSize(60, 30);
		b4.setLocation(650,110);
		b4.setFont(new Font("隶书",Font.PLAIN,12));
		b4.setVisible(true);
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MasterFrame();
				main_1();
				jf1.dispose();
			}
		});
		PreparedStatement ps = null;
	    Connection ct = null;
	    ResultSet rs = null;
	    Vector rowData,columnNames;
	       columnNames=new Vector();
	        //设置列名
	       columnNames.add("id");
	       columnNames.add("菜品名");
	       columnNames.add("价格");
	       columnNames.add("剩余数量");;
	        rowData = new Vector();
	        try {
	            Connection conn=getConn(driverName, dbUrl, us, pw);
	       	 	Statement sta=conn.createStatement();
	       	 	ResultSet rs1=sta.executeQuery("select * from people");
	       	 	while(rs1.next()){
	       	 			Vector hang = new Vector();
	       	 			hang.add(rs1.getInt(1));
	       	 			hang.add(rs1.getString(2));
	       	 			hang.add(rs1.getString(3));
	       	 			hang.add(rs1.getString(4));
	       	 			rowData.add(hang);
	       	 		}
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally {
	            try {
	                if (rs!= null) rs.close();
	                if(ps!=null) ps.close();
	                if(ct!=null) ct.close();
	            }catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        jt = new JTable(rowData,columnNames);
	        jsp = new JScrollPane(jt);
	        jp1=new JPanel();
	        jsp.setSize(800, 400);
	        jp1=new JPanel();
	        jp1.setLayout(null);
	        jp1.setSize(800, 200);
	        jp1.setLocation(0,400);
	        //jp1.add(t2);
	        jp1.add(t1);
	       // jp1.add(lb4);
	        jp1.add(lb3);
	       // jp1.add(lb2);
	        jp1.add(lb1);
	        jp1.add(b4);
	       // jp1.add(b3);
	       // jp1.add(b2);
	        jp1.add(b1);
	        jf1.add(jp1);
	        jf1.add(jsp);
}
static void okUPdate() {//点菜ok界面
		final JFrame jf1;
		JPanel jp1;
		JLabel lb1;
		JButton b1;
		jf1=new JFrame("点菜");
		jp1=new JPanel();
		jf1.setSize(300,200);
		jf1.setLocationRelativeTo(null);
		jf1.setVisible(true);
		lb1=new JLabel("点菜成功！");
		lb1.setFont(new Font("隶书",Font.PLAIN,20));
		lb1.setSize(280,30);
		lb1.setLocation(20, 20);
		lb1.setVisible(true);
		b1=new JButton("确定");
		b1.setFont(new Font("隶书",Font.PLAIN,20));
		b1.setSize(80,30);
		b1.setLocation(105,100);
		b1.setVisible(true);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf1.dispose();
			}
		});
		jp1.setLayout(null);
		jf1.add(jp1,BorderLayout.CENTER);
		jp1.add(lb1);
		jp1.add(b1);
	}
static void ErrorBorrow() {//借书错误
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Error");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("您选择的书籍不存在！");
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(20, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void ErrorBorrow1() {//借书错误1
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Error");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("您选择的书籍已被借出！");
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(20, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void money1() {//罚款界面弹出
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Error");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("您已超过还书期限罚款2元！");
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(20, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void stillok() {//还书完成
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Error");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("您已成功还书",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(20, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void Errorstill() {//借书错误界面
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Error");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("您并未借阅该书！",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(20, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void Updateok() {//维护成功
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Updateok");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("维护信息提交成功！",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(10, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void UpdateError() {//维护错吴
    final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("UpdateError");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("请确认还书后在进行维护！",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(10, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void addError() {//添加错误
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("addError");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("该id已被添加！",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(10, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void addok() {//充值成功
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("充值");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("充值成功！",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(10, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void Delok() {//删除成功
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Delok");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("删除成功！",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(10, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void nullError() {//空警告
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("nullErro");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("输入框不能为空！",JLabel.CENTER);
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(10, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
static void UpdateError1() {
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("Error");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("您输入的用户名不存在！");
	lb1.setFont(new Font("隶书",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(20, 20);
	lb1.setVisible(true);
	b1=new JButton("确定");
	b1.setFont(new Font("隶书",Font.PLAIN,20));
	b1.setSize(80,30);
	b1.setLocation(105,100);
	b1.setVisible(true);
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jf1.dispose();
		}
	});
	jp1.setLayout(null);
	jf1.add(jp1,BorderLayout.CENTER);
	jp1.add(lb1);
	jp1.add(b1);
}
public static void main(String[] args) {
		main_1(); 
	}
}
