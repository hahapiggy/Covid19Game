
/*****************************************
UI程式設計範本
*************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//想想還有沒有其他的東西要import
public class test extends JFrame implements ActionListener,MouseMotionListener,MouseListener //名稱改一改
{
Container c;
//設定UI元件
//設定共用的變數與類別
Timer ut,bt;//ut是飛碟的計時器bt式子彈
int ux,uy,x,y,bx,by,mode;//ux,uy是飛碟;x,y是砲台;bx,by是發射點
public test() //建構元，名稱改一改
{
super("打飛碟");
//初始化共用變數
uy=80;ux=0;mode=0;
y=400;x=200;
by=395;bx=x+23;
c=getContentPane();//取得ContentPane
//設定版面設定
//初始化UI元件
//將UI元件加入ContentPane
ut=new Timer(300,this);
ut.start();
bt=new Timer(50,this);
//設定UI元件與滑鼠的事件觸發傾聽者
addMouseMotionListener(this);
addMouseListener(this);
setSize(640,480);//設定size，顯示出去
setVisible(true);
}
public void paint(Graphics g)
{
super.paint(g);//畫出元件
g.setColor(Color.pink);
g.fillRect(ux,uy,50,20);
g.setColor(Color.blue);
g.fillRect(x,y,50,20);
g.setColor(Color.black);
g.fillRect(bx,by,5,5);
if (bx>=ux && bx<=ux+50 && by>=uy && by<=uy+20)
{
ut.stop();
bt.stop();
g.setColor(Color.red);
g.fillOval(bx-25,by-25,50,50);
}

//額外的畫圖程式寫在這裡
}
//UI元件事件處理類別寫在這裡
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==ut)
{
ux=ux+10;
if(ux>590)ux=0;
}
else if (e.getSource()==bt)
{
by=by-10;
if(by<0)
{
bt.stop();
mode=0;
by=398;
}
}
repaint();
}
//滑鼠事件處理類別寫在這裡
public void mouseEntered(MouseEvent e){ };
public void mouseExited(MouseEvent e){ };
public void mousePressed(MouseEvent e)
{
bt.start();
mode=1;
};
public void mouseReleased(MouseEvent e){ };
public void mouseClicked(MouseEvent e){ };
public void mouseDragged(MouseEvent xxx) { };
public void mouseMoved(MouseEvent e)
{
x=e.getX();
if (mode==0)
bx=x+23;
repaint();
};

/***主程式***/
public static void main(String args[]) //程式起點
{
test app=new test(); //名稱改一改，啟動UI元件
app.addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent e)
{
System.exit(0);
}
}); //處理視窗關閉要求
}
}