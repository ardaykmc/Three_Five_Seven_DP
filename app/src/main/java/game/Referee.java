package game;

import android.content.Context;
import android.content.Intent;

import com.example.three_five_seven_dp.MainActivity;
import com.example.three_five_seven_dp.testact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


import exception.InvalidMovementException;
import game.rules.IRule;
import game.rules.Rule;

public class Referee {
    private GameBoard gameBoard;
    private List<IRule> ruleList  = new ArrayList<>();
    private Layout layout;
    public Referee(List<IRule> ruleList, String mapPath, Context context, Player player1, Player player2) throws IOException {
        this.ruleList = ruleList;
        this.layout = new Layout(mapPath,context);
        this.gameBoard = new GameBoard(layout,player1,player2);
    }

    /**
     * The winning condition of games is left the last box to your opponent
     * @return true if there is a box left on layout
     */
    private boolean checkEndOfGame(){
        int counter  = 0 ;
        for (List<Box> boxList : this.layout.getLayoutList()){
            for (Box box : boxList) {
                if (box != null)
                    counter++;
            }
        }
        return counter == 1;
    }

    /**
     *
     * @param movement
     * @return result true if the movement hold all conditions for all rules in list
     */
    private boolean checkMoves(Movement movement){
        boolean result = true;
        for(IRule rule : this.ruleList){
            if (! rule.isValid()){
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Check the user moves if it is acceptable it will calculate the corresponding point and assign it as new score of user otherwise gives error
     * @param player that gives and updates score of users
     * @param movement takes the movement elment that will be check availability
     */
    private void giveScore(Player player, Movement movement) throws InvalidMovementException{
        if (checkMoves(movement)){
            List<Box> boxList  = movement.getChosenElement();
            double point = 0;
            int counter = 1;
            for (Box box : boxList){
                point  = point + counter * box.getPoint();
            }
            double currentScore = player.getScore();
            double updatedScore = point + currentScore;
            player.setScore(updatedScore);
        }else {
            throw new InvalidMovementException();
        }

    }

}
