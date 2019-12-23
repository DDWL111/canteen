static void usermessage() {食堂点餐界面
	定义一些控件
		final JFrame jf1;
		JTable jt;
		JScrollPane jsp;
		JPanel jp1;
		jf1=new JFrame(点餐);
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
		b1=new JButton(购买);
		b1.setSize(60, 30);
		b1.setLocation(60,60);
		b1.setFont(new Font(隶书,Font.PLAIN,12));
		b1.setVisible(true);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String a=t1.getText();
				if(a.equals()){
					nullError();
		}else {
			int n1=Integer.parseInt(t1.getText());
				Updateuser(n1);
			okUPdate();
		}
			}
		});
		b2=new JButton(删除);
		b2.setSize(60, 30);
		b2.setLocation(60,110);
		b2.setFont(new Font(隶书,Font.PLAIN,12));
		b2.setVisible(true);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String a=t2.getText();
				if(a.equals()){
					nullError();
		}else {
			int n1=Integer.parseInt(a);
				try {
					peopleDel(n1);
				} catch (SQLException e1) {
					 TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Delok();
		}
				
			}
		});
		lb1=new JLabel(id为);
		lb1.setSize(30, 30);
		lb1.setLocation(130, 60);
		lb1.setVisible(true);
		lb2=new JLabel(id为);
		lb2.setSize(30, 30);
		lb2.setLocation(130, 110);
		lb2.setVisible(true);
		lb3=new JLabel(菜品);
		lb3.setSize(60, 30);
		lb3.setLocation(220, 60);
		lb3.setVisible(true);
		lb4=new JLabel(的用户);
		lb4.setSize(60, 30);
		lb4.setLocation(220, 110);
		lb4.setVisible(true);
		b3=new JButton(添加);
		b3.setSize(60, 30);
		b3.setLocation(650,60);
		b3.setFont(new Font(隶书,Font.PLAIN,12));
		b3.setVisible(true);
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adduser();
			}
		});
		b4=new JButton(返回);
		b4.setSize(60, 30);
		b4.setLocation(650,110);
		b4.setFont(new Font(隶书,Font.PLAIN,12));
		b4.setVisible(true);
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MasterFrame();
				main_1();
				jf1.dispose();
			}
		});