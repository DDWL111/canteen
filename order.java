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
				Login_2();
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
