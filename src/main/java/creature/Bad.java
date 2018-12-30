package creature;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class Bad extends Creature {

    @Override
    protected void attack() {
        ArrayList<Creature> atkList = creatureToAttack();
        if (status == Status.DEAD || status == Status.STOP)
            return;
        synchronized (bf) {
            for (int i = 0; i < atkList.size(); i++) {
                if (atkList.get(i) instanceof Good) {
                    Creature c = atkList.get(i);
                    bf.drawAttack(canvas, this, c);
                    System.out.print(this.toString() + " atk " + c.toString());
                    c.setHp(c.getHp() - atkPoint);
                    System.out.println(",伤害 " + atkPoint + ",余血 " + c.getHp());
                    if (c.getHp() <= 0) {
                        c.setStatus(Status.DEAD);
                    }
                }

            }
            if (hasAliveBad() && !hasAliveGood())
                status = Status.STOP;
            if (hasAliveGood() && !hasAliveBad()) {
                status = Status.STOP;
                bf.win = true;
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
