package queue;

import creature.Creature;
import space.BattleField;

import java.util.ArrayList;

public class ChongE implements ZhenFa {

    public void arrangeCreatures(ArrayList<? extends Creature> creatures, BattleField battleField, boolean left) {
        int row = battleField.getRow(), col = battleField.getCol();
        if (creatures.size() > row) {
           System.out.println("无法排冲轭");
           return;
        }

        int start = (row - creatures.size()) / 2;

        for (int i = 0; i < creatures.size(); i++) {
            if (left)
                battleField.setCreature(creatures.get(i), 2 + i % 2, start + i);
            else
                battleField.setCreature(creatures.get(i), col - 3 - i % 2, start + i);
        }
    }
}
