package creature;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class Bad extends Creature {

    @Override
    protected void attack() {
        ArrayList<Creature> atkList = creatureToAttack();
        if (status == Status.DEAD)
            return;
        synchronized (bf) {
            for (int i = 0; i < atkList.size(); i++) {
                if (atkList.get(i) instanceof Good) {
                    Creature c = atkList.get(i);
                    System.out.print(this.toString() + " atk " + c.toString());
                    c.setHp(c.getHp() - atkPoint);
                    System.out.println(",伤害 " + atkPoint + ",余血 " + c.getHp());
                    if (c.getHp() <= 0)
                        c.setStatus(Status.DEAD);
                }
            }

            //bf.drawBattleField(canvas);
        }
          try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }

    }
}
