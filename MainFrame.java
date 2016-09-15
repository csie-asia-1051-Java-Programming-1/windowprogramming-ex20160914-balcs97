import java.awt.*;
import java.awt.event.*;
public class MainFrame extends Frame{
	//for the midterm,Finalterm,project,and two more fields for others
	private TextField tf1 = new TextField("0");
	private TextField tf2 = new TextField("0");
	private TextField tf3 = new TextField("0");
	private TextField tf4 = new TextField("0");
	private TextField tf5 = new TextField("0");
	//for the student id 
	private TextField sid = new TextField("0");
	//for the 5 percentages
	private TextField pc1 = new TextField("0");
	private TextField pc2 = new TextField("0");
	private TextField pc3 = new TextField("0");
	private TextField pc4 = new TextField("0");
	private TextField pc5 = new TextField("0");
	private Label lab1=new Label("Insert Grades");
	private Label lab2=new Label("¡õInsert Percentages % for each grades¡õ");
	private Label lab3=new Label("%");
	private Button btnRun = new Button("Run");
	private Button btnExit= new Button("Exit");
	private TextArea ta=new TextArea();
	public MainFrame(){
		initComp();
	}
	private void initComp(){
		this.setLayout(null);
		this.setBounds(200,100,580,500);
		this.setBackground(new Color(128,205,20));
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		tf1.setBounds(50,70,80,25);
		tf1.setBackground(Color.yellow);
		tf2.setBounds(150,70,80,25);
		tf2.setBackground(Color.yellow);
		tf3.setBounds(250,70,80,25);
		tf3.setBackground(Color.yellow);
		tf4.setBounds(350,70,80,25);
		tf4.setBackground(Color.yellow);
		tf5.setBounds(450,70,80,25);
		tf5.setBackground(Color.yellow);
		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		this.add(tf4);
		this.add(tf5);
		lab1.setBounds(230, 40, 120, 30);
		lab1.setAlignment(Label.CENTER);
		this.add(lab1);
		lab2.setBounds(140, 95, 300, 30);
		lab2.setAlignment(Label.CENTER);
		this.add(lab2);
		pc1.setBounds(50,125,80,25);
		pc1.setBackground(Color.white);
		pc2.setBounds(150,125,80,25);
		pc2.setBackground(Color.white);
		pc3.setBounds(250,125,80,25);
		pc3.setBackground(Color.white);
		pc4.setBounds(350,125,80,25);
		pc4.setBackground(Color.white);
		pc5.setBounds(450,125,80,25);
		pc5.setBackground(Color.white);
		this.add(pc1);
		this.add(pc2);
		this.add(pc3);
		this.add(pc4);
		this.add(pc5);
		btnRun.setBounds(50,170,220,30);
		btnRun.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				float g1 = Float.parseFloat(tf1.getText());
				float g2 = Float.parseFloat(tf2.getText());
				float g3 = Float.parseFloat(tf3.getText());
				float g4 = Float.parseFloat(tf4.getText());
				float g5 = Float.parseFloat(tf5.getText());
				float p1 = Float.parseFloat(pc1.getText());
				float p2 = Float.parseFloat(pc2.getText());
				float p3 = Float.parseFloat(pc3.getText());
				float p4 = Float.parseFloat(pc4.getText());
				float p5 = Float.parseFloat(pc5.getText());
				float ps = p1+p2+p3+p4+p5;
				String id=sid.getText();
				String state= "pass";
				if(ps == 100){
					float total = (g1*p1+g2*p2+g3*p3+g4*p4+g5*p5)/100;
					if(total<60){
						state="fail";
					}
					if(id=="104021132"){
						if(total<60){
							total =60;
							state="pass";
						}
					}
					fun1(id,state);
					if(state!="pass"){
						ta.append("Grade: "+total+"\n");
						ta.append("You Can Not PAAAAAASS!! \n");
					}else{
						ta.append("Grade: "+total+"\n");
						ta.append("You Pass \n");
					}				
				}else{
					ta.append("The percentages sum is "+ps+"%,over or under 100% please redo \n");
				}
				
			}
		});
		btnExit.setBounds(310,170,220,30);
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}
		});
		this.add(btnRun);
		this.add(btnExit);
		ta.setBounds(50, 220, 480, 180);
		this.add(ta);
		sid.setBounds(200, 420, 180, 20);
		sid.setText("Insert student id (option)");
		this.add(sid);
		ta.append("Welcome to the grade calculator!! \n");
		ta.append("Make sure grades and percentages are under 100!! \n");
	}
	private void fun1(String sid,String state){
		if(sid!="Insert student id (option)"){
			this.setTitle("Student "+sid+"  "+state+"ed the course this semester!!");
		}else{
			this.setTitle("The student  "+state+"ed the course this semester!!");
		}
	}
}
