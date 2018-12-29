package queue;

import creature.Creature;
import space.BattleField;

import java.util.ArrayList;

public class FangYuan implements ZhenFa {

    public void arrangeCreatures(ArrayList<? extends Creature> creatures, BattleField battleField, boolean left) {
        if (creatures.size() != 8 && creatures.size() != 4) {
            System.out.println("无法排方円");
            return;
        }
        int sideLength = creatures.size() / 4;
        int row = battleField.getRow(), col = battleField.getCol();
        int start = (row - (sideLength * 2 + 1)) / 2;
        int end = start + sideLength * 2;

        int cnt = 0;
        if (left)
            battleField.setCreature(creatures.get(cnt), 2, start);
        else
            battleField.setCreature(creatures.get(cnt), 8, start);
        cnt++;

        while (cnt < creatures.size()) {
            for (int i = 1 ; i <= sideLength; i++) {
                if (left) {
                    battleField.setCreature(creatures.get(cnt), 2 + i, start + i);
                    cnt++;
                    battleField.setCreature(creatures.get(cnt), 2 - i, start + i);
                    cnt++;
                }
                else {
                    battleField.setCreature(creatures.get(cnt), col - 3 - i, start + i);
                    cnt++;
                    battleField.setCreature(creatures.get(cnt), col - 3 + i, start + i);
                    cnt++;
                }
            }
            for (int i = sideLength - 1; i > 0; i--) {
                if (left) {
                    battleField.setCreature(creatures.get(cnt), 2 + i, end - i);
                    cnt++;
                    battleField.setCreature(creatures.get(cnt), 2 - i, end - i);
                    cnt++;
                }
                else {
                    battleField.setCreature(creatures.get(cnt), col - 3 - i, end - i);
                    cnt++;
                    battleField.setCreature(creatures.get(cnt), col - 3 + i, end - i);
                    cnt++;
                }
            }

            if (left)
                battleField.setCreature(creatures.get(cnt), 2, end);
            else
                battleField.setCreature(creatures.get(cnt), 8, end);
            cnt++;

        }
    }
}
