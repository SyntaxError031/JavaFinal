package queue;

import creature.Creature;
import space.BattleField;

import java.util.ArrayList;

public class FengShi implements ZhenFa {

    public void arrangeCreatures(ArrayList<? extends Creature> creatures, BattleField battleField, boolean left) {
        if(creatures.size() < 8) {
            System.out.println("无法排锋矢");
            return;
        }

        int row = battleField.getRow(), col = battleField.getCol();
        int start = (row - creatures.size() + 4) / 2;

        for (int i = 0; i < creatures.size() - 4; i++) {
            if (left)
                battleField.setCreature(creatures.get(i), 2, start + i);
            else
                battleField.setCreature(creatures.get(i), 8, start + i);
        }

        int cnt = creatures.size() - 4;
        if (left) {
            battleField.setCreature(creatures.get(cnt), 1, start + 1);
            cnt++;
            battleField.setCreature(creatures.get(cnt), 3, start + 1);
            cnt++;
            battleField.setCreature(creatures.get(cnt), 0, start + 2);
            cnt++;
            battleField.setCreature(creatures.get(cnt), 4, start + 2);
        }
        else {
            battleField.setCreature(creatures.get(cnt), 7, start + 1);
            cnt++;
            battleField.setCreature(creatures.get(cnt), 9, start + 1);
            cnt++;
            battleField.setCreature(creatures.get(cnt), 6, start + 2);
            cnt++;
            battleField.setCreature(creatures.get(cnt), 10, start + 2);
        }
    }
}
