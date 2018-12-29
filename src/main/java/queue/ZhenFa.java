package queue;

import creature.Creature;
import space.BattleField;

import java.util.ArrayList;

public interface ZhenFa {

    void arrangeCreatures(ArrayList<? extends Creature> creatures, BattleField battleField, boolean left);

}
