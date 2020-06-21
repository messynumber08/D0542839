

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class MainTest {

  @Test
  public void test() {
    StringBuilder test = new StringBuilder();
    String result = "Enter your name:\n" + "Role information\n" + "name:QQ\n" + "strength:10\n" + "health:30\n"
        + "level:1\n" + "exp:0\n" + "0.exit\n" + "1.battle\n" + "2.practice\n" + "Please enter the correct option\n"
        + "0.exit\n" + "1.battle\n" + "2.practice\n" + "QQ challenged enemy\n" + "QQ attack,enemy takes 5 damage\n"
        + "enemy attack,QQ takes 7 damage\n" + "QQ attack,enemy takes 8 damage\n" + "enemy attack,QQ takes 6 damage\n"
        + "QQ attack,enemy takes 4 damage\n" + "enemy attack,QQ takes 7 damage\n" + "QQ attack,enemy takes 5 damage\n"
        + "enemy attack,QQ takes 7 damage\n" + "QQ attack,enemy takes 4 damage\n" + "enemy attack,QQ takes 2 damage\n"
        + "QQ attack,enemy takes 11 damage\n" + "QQ won,QQ has 1 HP\n" + "Gained 36 experience\n" + "name:QQ\n"
        + "strength:15\n" + "health:45\n" + "level:2\n" + "exp:3\n" + "Level up\n" + "0.exit\n" + "1.battle\n"
        + "2.practice\n" + "QQ challenged enemy\n" + "QQ attack,enemy takes 16 damage\n"
        + "enemy attack,QQ takes 24 damage\n" + "QQ attack,enemy takes 9 damage\n" + "enemy attack,QQ takes 18 damage\n"
        + "QQ attack,enemy takes 6 damage\n" + "enemy attack,QQ takes 18 damage\n" + "QQ defeated,enemy has 32 HP\n"
        + "Gained 9 experience\n" + "0.exit\n" + "1.battle\n" + "2.practice\n" + "Gained 18 experience\n" + "0.exit\n"
        + "1.battle\n" + "2.practice\n" + "Thanks for playing\n";

    Random random = new Random(100);
    Pokemon player = null;
    int choose = -1;
    int[] nextInt = { 3, 1, 1, 2, 0 };
    int i = 0;

    try {
//      System.out.print("Enter your name:\n");
      test.append("Enter your name:\n");
//      String s = getNext();
      String s = "QQ";
      player = new Pokemon(s, 10, 30, 1, 0);
      test.append("Role information\n");
//      System.out.println("Role information");
      test.append(player.getMyRole() + "\n");
//      System.out.println(player.getMyRole());
    } catch (Exception e) {
      System.out.println(e.toString());
    }

    try {
      while (true) {
        test.append("0.exit\n");
        test.append("1.battle\n");
        test.append("2.practice\n");
//        System.out.println("0.exit");
//        System.out.println("1.battle");
//        System.out.println("2.practice");
        choose = -1;
//        choose = getNextInt();
        choose = nextInt[i];
        i++;
        if (choose == 0) {
          test.append("Thanks for playing" + "\n");
//          System.out.println("Thanks for playing");
          break;
        } else if (choose == 1) {
          Pokemon enemy = new Pokemon("enemy", player.getStrength() * (random.nextInt(100) + 50) / 100,
              player.getHealth() * (random.nextInt(100) + 50) / 100, 1, 0);
          test.append(player.battle(enemy, random.nextInt()) + "\n");
//          System.out.println(player.battle(enemy, random.nextInt()));
          if (player.getExp() >= (Math.pow(player.getLevel(), 3) + 60) * 3 - 150) {
            test.append(player.levelUp() + "\n");
//            System.out.println(player.levelUp());
          }

        } else if (choose == 2) {
          test.append(player.gainExp(18) + "\n");
//          System.out.println(player.gainExp(18));
          if (player.getExp() >= (Math.pow(player.getLevel(), 3) + 60) * 3 - 150) {
            test.append(player.levelUp() + "\n");
//            System.out.println(player.levelUp());
          }
        } else {
//          System.out.println("Please enter the correct option");
          test.append("Please enter the correct option\n");
        }
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }

    assertEquals(result, test.toString());
  }

}
