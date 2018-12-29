package space;

import creature.Creature;

public class Block {

    private Creature creature;

    Block() {
        creature = null;
    }

    void putCreature(Creature creature) {
        this.creature = creature;
    }

    void eraseCreature() {
        this.creature = null;
    }

    Creature getCreature() {
        return creature;
    }

}
