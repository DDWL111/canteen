static void main_1() {//������
	    final JFrame jf1=new JFrame("ʳ�ù���ϵͳ");
		JButton b1,b2;
		JPanel jp1;
		b1=new JButton("���");
		b2=new JButton("��ֵ");
		jp1=new JPanel();
		jp1.setLayout(null);
		b1.setSize(150,50);
		b1.setLocation(325, 150);
		b1.setVisible(true);
		b1.setFont(new Font("����",Font.PLAIN,20));
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
		b2.setFont(new Font("����",Font.PLAIN,20));
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
