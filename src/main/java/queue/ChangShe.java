package queue;

import creature.Creature;
import space.BattleField;

import java.util.ArrayList;

public class ChangShe implements ZhenFa {

    public void arrangeCreatures(ArrayList<? extends Creature> creatures, BattleField battleField, boolean left) {
        int row = battleField.getRow(), col = battleField.getCol();

        if (creatures.size() > row) {
            System.out.println("无法排长蛇");
            return;
        }

        int start = (row - creatures.size()) / 2;

        for (int i = 0; i < creatures.size(); i++) {
            if (left)
                battleField.setCreature(creatures.get(i), 2, i + start);
            else
                battleField.setCreature(creatures.get(i), col - 3, i + start);
        }

    }
}
