import javax.swing.*;


public class Home
{
    static int amtGame;
    static int gameCount;
    static Integer[] options = {1,3};

    public static void main(String[] args) {
        Object selected = JOptionPane.showInputDialog(null,"test","How many games",JOptionPane.DEFAULT_OPTION,null,options,"0");
        amtGame =(int)selected;
        TicTacToe TTTTGame = new TicTacToe();
        TTTTGame.startGame();

        //to do repeat game after completing


    }

}
