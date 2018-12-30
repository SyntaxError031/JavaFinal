package space;

import creature.Grandpa;
import creature.Loluo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BattleFieldTest {

    private BattleField battleField;

    @Before
    public void setUp() {
        battleField = new BattleField(5, 5);
    }

    @Test
    public void setCreature() {
        Grandpa grandpa = new Grandpa();
        battleField.setCreature(grandpa, 1,1);
        assertEquals(battleField.getCreature(1, 1), grandpa);
    }

    @Test
    public void eraseCreature() {
        Loluo loluo = new Loluo(1);
        battleField.setCreature(loluo, 2, 2);
        battleField.eraseCreature(2, 2);
        assertEquals(battleField.getCreature(2, 2), null);
    }
}