import java.util.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JPanel
{
    static  String[] board;
    static  String turn;
    //A list of buttons is created and, when clicked, can change array values in board[]. This will be used to see if someone won or if a draw occurred.
    static  List<JButton> buttons= new ArrayList<JButton>();
    static  JFrame frame=new JFrame();
    static  int value=0;
    static String winner = null;
    static  JLabel information=new JLabel("<html>Welcome to TicTacToe Tournament.<br/>X plays first.<br/> Click  the center of a slot to place in:");
    static int amtGame;
    static int gameCount;

    static Integer[] options = {1,3};

    public static void main(String[] args) {
        Object selected = JOptionPane.showInputDialog(null,"test","How many games",JOptionPane.DEFAULT_OPTION,null,options,"0");
        amtGame =(int)selected;

        //to do repeat game after completing
        startGame();

    }

    static void startGame()
    {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            TicTacToe ticTacToe = new TicTacToe();
            frame.add(ticTacToe);
            frame.setContentPane(ticTacToe);

            frame.setVisible(true);
            board = new String[9];
            turn = "X";

            populateEmptyBoard();
            gameCount += 1;

    }

    //In winningText, checkWinner is called to see if a player has won. If the player won or a draw occurred, the label on the window is updated to show it.
    static void winningText() {
        winner=checkWinner();
        if(winner!=null) {
            if (winner.equalsIgnoreCase("draw")) {
                information.setText("<html>It's a draw!<br/>");
            } else {
                information.setText("<html>Congratulations!<br/> "+ winner+ " has won!<br/> Thanks for playing.");
            }
        }
    }

    //In this function, the board array is used to see if there is a winner or if a draw occurred. If both of these conditions are false, the game continues.
    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains("Empty")){
                break;
            }
            else if (a == 8) return "draw";
        }
        information.setText("<html>"+turn+"'s turn.<br/> Click near the center of a slot to place "+turn+" in.");
        return null;
    }


    //In this function, buttons are created for the player to put his/her/their turns in. Every time a player clicks on an applicable button, the board array is updated.
    static void populateEmptyBoard() {
        frame.setLayout(null);
        information.setBounds(10,160, 400, 400);
        frame.add(information);
        int xIncrease=0;
        int yIncrease=-100;

        for(int i=0; i<9; i++) board[i]="Empty";

        for(int y=0; y<3; y++){

            xIncrease=0;
            yIncrease+=100;
            for (int x = 0; x < 3; x++) {
                buttons.add(new JButton(""));
                buttons.get(value).setBounds(xIncrease, yIncrease, 100, 100);
                buttons.get(value).setOpaque(false);
                buttons.get(value).setContentAreaFilled(false);
                buttons.get(value).setBorderPainted(false);
                frame.add(buttons.get(value));
                buttons.get(value).addActionListener(new ActionListener() {
                    int val=value;
                    public void actionPerformed(ActionEvent e) {
                        if(winner==null && board[val]=="Empty") {
                            board[val]=turn;
                            buttons.get(val).setText(turn);

                            if (turn.equals("X")) {
                                turn = "O";
                            } else {
                                turn = "X";
                            }
                            winningText();
                        }
                        else if(winner!=null) information.setText("The game has already been finished!");//pop up to play again
                        else information.setText("<html>The slot is already taken!<br/> Pick another slot!");
                    }
                });
                value++;
                xIncrease+=100;
            }
            frame.setSize(300,450);
            frame.setResizable(false);
        }

    }
    //In this in-built function, three black vertical lines and two black horizontal lines are created to separate the buttons in a Tic-Tac-Toe fashion.
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x=100;
        g.setColor(Color.BLACK);
        for(int i=0; i<2; i++) {
            g.drawLine(0, 0+x, 300,0+x);
            if(i==2) break;
            g.drawLine(0+x,0,0+x, 300);
            x+=100;
        }

    }
}
