static void addok() {//��ֵ�ɹ�
	final JFrame jf1;
	JPanel jp1;
	JLabel lb1;
	JButton b1;
	jf1=new JFrame("��ֵ");
	jp1=new JPanel();
	jf1.setSize(300,200);
	jf1.setLocationRelativeTo(null);
	jf1.setVisible(true);
	lb1=new JLabel("��ֵ�ɹ���",JLabel.CENTER);
	lb1.setFont(new Font("����",Font.PLAIN,20));
	lb1.setSize(280,30);
	lb1.setLocation(10, 20);
	lb1.setVisible(true);
	b1=new JButton("ȷ��");
	b1.setFont(new Font("����",Font.PLAIN,20));
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
