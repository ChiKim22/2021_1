package CH12;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class PizzaOrder extends JFrame implements ActionListener{

		private int sum, temp1, temp2, temp3;

		private JButton orderBtn, cancelBtn;
		private JPanel orderPanel;
		private JTextField Field;

		private WelcomePanel welcomePanel = new WelcomePanel();
		private TypePanel typePanel = new TypePanel();
		private ToppingPanel toppingPanel = new ToppingPanel();
		private SizePanel sizePanel = new SizePanel();

		public PizzaOrder() {

			this.setSize(500, 200);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("자바 피자");

			orderBtn = new JButton("주문");
			orderBtn.addActionListener(this);

			cancelBtn = new JButton("취소");
			cancelBtn.addActionListener(this);

			Field = new JTextField();
			Field.setEditable(false);
			Field.setColumns(6);

			orderPanel = new JPanel();
			orderPanel.add(orderBtn);
			orderPanel.add(cancelBtn);
			orderPanel.add(Field);

			this.add(welcomePanel, BorderLayout.NORTH);
			this.add(orderPanel, BorderLayout.SOUTH);
			this.add(sizePanel, BorderLayout.EAST);
			this.add(typePanel, BorderLayout.WEST);
			this.add(toppingPanel, BorderLayout.CENTER);

			this.setVisible(true);

		}

	class WelcomePanel extends JPanel{

		private JLabel message;

		public WelcomePanel() {
			message = new JLabel("자바 피자에 오신것을 환영합니다.");
			this.add(message);
		}
	}

	class TypePanel extends JPanel implements ChangeListener{


		private JRadioButton combo, potato, bulgogi;
		private ButtonGroup btnGroup;

		public TypePanel() {
			this.setLayout(new GridLayout(3, 1));
			combo = new JRadioButton("콤보", true);
			combo.addChangeListener(this);
			potato = new JRadioButton("포테이토");
			potato.addChangeListener(this);
			bulgogi = new JRadioButton("불고기");
			bulgogi.addChangeListener(this);

			btnGroup = new ButtonGroup();
			btnGroup.add(combo);
			btnGroup.add(potato);
			btnGroup.add(bulgogi);

			this.setBorder(BorderFactory.createTitledBorder("종류"));

			this.add(combo);
			this.add(potato);
			this.add(bulgogi);



		}

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub

			if(e.getSource() == combo) {
				temp1 = 15000;
			}else if (e.getSource() == potato) {
				temp1 = 15000;
			}else {
				temp1 = 15000;
			}

		}
	}
	class ToppingPanel extends JPanel implements ChangeListener{

		private JRadioButton pepper, cheese, peperoni, bacon;
		private ButtonGroup btnGroup;

		public ToppingPanel() {

			this.setLayout(new GridLayout(4, 1));

			pepper = new JRadioButton("피망", true);
			pepper.addChangeListener(this);
			cheese = new JRadioButton("치즈");
			cheese.addChangeListener(this);
			peperoni = new JRadioButton("페파로니");
			peperoni.addChangeListener(this);
			bacon = new JRadioButton("베이컨");
			bacon.addChangeListener(this);

			btnGroup = new ButtonGroup();
			btnGroup.add(pepper);
			btnGroup.add(cheese);
			btnGroup.add(peperoni);
			btnGroup.add(bacon);

			this.setBorder(BorderFactory.createTitledBorder("종류"));

			this.add(pepper);
			this.add(peperoni);
			this.add(cheese);
			this.add(bacon);


		}


		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub

			if(e.getSource() == pepper) {
				temp2 = 200;
			}else if(e.getSource() == cheese) {
				temp2 = 500;
			}else if(e.getSource() == peperoni) {
				temp2 = 700;
			}else {
				temp2 = 700;
			}

		}

	}

	class SizePanel extends JPanel implements ChangeListener{


		private JRadioButton small, medium, large;
		private ButtonGroup btnGroup;

		public SizePanel() {
			this.setLayout(new GridLayout(3, 1));
			small = new JRadioButton("스몰", true);
			small.addChangeListener(this);
			medium = new JRadioButton("미디엄");
			medium.addChangeListener(this);
			large = new JRadioButton("라지");
			large.addChangeListener(this);

			btnGroup = new ButtonGroup();
			btnGroup.add(small);
			btnGroup.add(medium);
			btnGroup.add(large);

			this.setBorder(BorderFactory.createTitledBorder("종류"));

			this.add(small);
			this.add(medium);
			this.add(large);


		}

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub

			if(e.getSource() == small) {
				temp3 = 0;
			}else if (e.getSource() == medium) {
				temp3 = 3000;
			}else {
				temp3 = 4000;
			}

		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == orderBtn) {
			sum = (temp1 + temp2 + temp3);

			Field.setText(String.valueOf(sum));
			System.out.println("temp1:" + temp1 + ", temp2:" + temp2 + ", temp3:" + temp3);
		}else {
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			Field.setText(String.valueOf(sum));
		}

	}

		public static void main(String args[]) {
			new PizzaOrder();
		}

}
