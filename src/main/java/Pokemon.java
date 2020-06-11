
import java.security.SecureRandom;
import java.util.Random;


public class Pokemon {
  private String name = null;
  private int health = 0;
  private int strength = 0;
  private int level = 1;
  private int exp = 0;
  private Random ran = SecureRandom.getInstanceStrong();

  public Pokemon(String name, int strength, int health) throws Exception {

    if (health < 1 || health > 1023 || strength < 1 || strength > 1023) {
      throw new Exception();
    }

    this.name = name;
    this.health = health;
    this.strength = strength;
  }

  public Pokemon battle(Pokemon enemy) {
    int health1 = this.health;
    int health2 = enemy.health;
    System.out.println(this.name + "對" + enemy.name + "發起了挑戰");
    do {

      int attack1 = ran.nextInt(this.strength) + (int) (this.strength * 0.2);
      health2 -= attack1;
      System.out.println(this.name + "攻擊," + enemy.name + "受到" + attack1 + "點傷害");
      if (health2 <= 0)
        break;

      int attack2 = ran.nextInt(enemy.strength) + (int) (enemy.strength * 0.4);
      health1 -= attack2;
      System.out.println(enemy.name + "攻擊," + this.name + "受到" + attack2 + "點傷害");
      if (health1 <= 0)
        break;
    } while (true);

    if (health1 < 1) {
      System.out.println(this.name + "戰敗了," + enemy.name + "還有" + health2 + "點血量");
      return enemy;
    } else {
      System.out.println(this.name + "勝利了," + this.name + "還有" + health1 + "點血量");
      return this;
    }
  }

  public void getMyRole() {
    System.out.println("名稱:" + this.name);
    System.out.println("攻擊" + this.strength);
    System.out.println("血量" + this.health);
    System.out.println("等級" + this.level);
    System.out.println("經驗值" + this.exp);
  }

  public int gainExp(int exp) {
    this.exp += exp;
    if (this.exp >= (Math.pow(this.level, 3) + 60) * 3 - 150) {
      this.levelUp();
    }
    return this.exp;
  }

  public int levelUp() {
    this.exp -= (Math.pow(this.level, 3) + 60) * 3 - 150;
    this.level++;
    this.strength += 5;
    this.health += 15;
    System.out.println("level up");
    this.getMyRole();
    return this.level;
  }

  public int strength() {
    return this.strength;
  }

  public int health() {
    return this.health;
  }

}
