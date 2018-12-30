package creature;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class Good extends Creature {

    @Override
    protected void attack() {
        if (status == Status.DEAD || status == Status.STOP)
            return ;
        synchronized (bf) {
            System.out.println(this.toString() + " in attack");
            ArrayList<Creature> atkList = creatureToAttack();
            for (int i = 0; i < atkList.size(); i++) {
                if (atkList.get(i) instanceof Bad) {
                    Creature c = atkList.get(i);
                    System.out.print(this.toString() + " atk " + c.toString());
                    bf.drawAttack(canvas, this, c);
                    c.setHp(c.getHp() - atkPoint);

                    System.out.println(",伤害 " + atkPoint + ",余血 " + c.getHp());
                    if (c.getHp() <= 0) {
                        c.setStatus(Status.DEAD);
                    }
                }
            }

            //bf.drawBattleField(canvas);
            if (hasAliveBad() && !hasAliveGood())
                status = Status.STOP;
            if (hasAliveGood() && !hasAliveBad()) {
                status = Status.STOP;
                bf.win = true;
            }

        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }
}
