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
