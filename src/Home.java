import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class Home
{
    static int amtGame;
    static int curGame;
     static Integer[] options = {1,3,5};
    //
     static JFrame frameMenu = new JFrame();
    static JLabel lblHeader = new JLabel("Welcome to The Tic Tac Toe Tournament");
    static JLabel lblSubHeader = new JLabel("Enter players name below");
    static JTextField player1 = new JTextField("Player1");
    static JTextField player2 = new JTextField("Player2");
    static JButton butStart = new JButton("Start");
    static String player1Name;
    static String player2Name;
    //
    static JFrame frameResults = new JFrame();
    static JLabel lblHeader1 = new JLabel("Results of The Tic Tac Toe Tournament");
    static JLabel lblSubHeader1 = new JLabel("The Ladder is:");
    static JLabel lblBody = new JLabel();


    static public  void main(String[] args) {

        //
        frameMenu.setTitle("TTTT");
        frameMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameMenu.setLayout(null);
        frameMenu.add(lblHeader);
        lblHeader.setBounds(25,10,300,10);
        frameMenu.add(lblSubHeader);
        lblSubHeader.setBounds(70,10,400,40);
        frameMenu.add(player1);
        player1.setBounds(50,50,200,20);
        frameMenu.add(player2);
        player2.setBounds(50,80,200,20);
        frameMenu.add(butStart);
        butStart.setBounds(50,110,200,20);
        frameMenu.setSize(300,200);

        frameMenu.setVisible(true);

        //
        butStart.addActionListener(actionEvent ->
        {
            player1Name = player1.getText();
            player2Name = player2.getText();
            Object selected = JOptionPane.showInputDialog(null,"How many Games","How many games",JOptionPane.DEFAULT_OPTION,null,options,"0");
            amtGame =(int)selected;
            game(player1Name,player2Name,0,0,0,0);
            frameMenu.dispatchEvent(new WindowEvent(frameMenu,WindowEvent.WINDOW_CLOSING));

        });
    }
     static void game(String n1, String n2,int p1,int p2,int dr,int cGame)
    {

        TicTacToe  TTTTGame = new TicTacToe();
        if (cGame<amtGame) {

            TTTTGame.startGame(cGame,n1,n2);

        }
        else if (cGame == amtGame)
        {

            if (p1>p2)
            {
                lblBody.setText("<html>1st place: "+player1Name+" with "+p1+" wins<br/>2nd place: "+player2Name+" with "+p2+" wins");
            }
            else if (p1<p2)
            {
                lblBody.setText("<html>1st place: "+player2Name+" with "+p2+" wins<br/>2nd place: "+player1Name+" with "+p1+" wins");
            }
            else if (p1 == p2)
            {
                lblBody.setText("<html>The game was a draw <br/>"+player1Name+" and "+player2Name+" having "+p1+" wins <br/>And "+dr+" draws");
            }
            frameResults.setTitle("TTTT");
            frameResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameResults.setLayout(null);
            frameResults.add(lblHeader1);
            lblHeader1.setBounds(25,10,300,10);
            frameResults.add(lblSubHeader1);
            lblSubHeader1.setBounds(70,10,400,40);
            frameResults.add(lblBody);
            lblBody.setBounds(50,50,200,60);
            frameResults.setSize(300,200);
            frameResults.setResizable(false);
            frameResults.setVisible(true);

        }
    }


}
