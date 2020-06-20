
import java.util.Random;

public class Pokemon {
  private String name = null;
  private int strength = 1;
  private int health = 1;
  private int level = 1;
  private int exp = 0;

  public Pokemon(String name, int strength, int health, int level, int exp) throws Exception {
    if (name == null)
      throw new Exception("名字不可為空");

    if (strength < 1)
      throw new Exception("力量不可小於1");

    if (health < 1)
      throw new Exception("體力不可小於1");

    if (level < 1)
      throw new Exception("等級不可小於1");

    if (exp < 0)
      throw new Exception("經驗不可小於0");

    this.name = name;
    this.strength = strength;
    this.health = health;
    this.level = level;
    this.exp = exp;
  }

  public String battle(Pokemon enemy, int seed) throws Exception {
    Random random = new Random(seed);
    StringBuilder result = new StringBuilder();
    int playerHealth = this.health;
    int enemyHealth = enemy.health;
    result.append(this.name + "對" + enemy.name + "發起了挑戰");
    boolean flag = true;
    do {
      int playerStrength = random.nextInt(this.strength) + (int) (this.strength * 0.2);
      enemyHealth -= playerStrength;
      result.append("\n" + this.name + "攻擊," + enemy.name + "受到" + playerStrength + "點傷害");

      if (enemyHealth <= 0)
        break;

      int enemyStrength = random.nextInt(enemy.strength) + (int) (enemy.strength * 0.4);
      playerHealth -= enemyStrength;
      result.append("\n" + enemy.name + "攻擊," + this.name + "受到" + enemyStrength + "點傷害");

      if (playerHealth <= 0)
        flag = false;
    } while (flag);

    if (playerHealth < 1) {
      result.append("\n" + this.name + "戰敗了," + enemy.name + "還有" + enemyHealth + "點血量");
      result.append("\n" + this.gainExp(9));
    }
    if (enemyHealth < 1) {
      result.append("\n" + this.name + "勝利了," + this.name + "還有" + playerHealth + "點血量");
      result.append("\n" + this.gainExp(36));
    }
    return result.toString();
  }

  public String getMyRole() {
    StringBuilder result = new StringBuilder();

    result.append("名稱:" + this.name + "\n");
    result.append("攻擊:" + this.strength + "\n");
    result.append("血量:" + this.health + "\n");
    result.append("等級:" + this.level + "\n");
    result.append("經驗值:" + this.exp);
    return result.toString();
  }

  public String gainExp(int exp) {
    StringBuilder result = new StringBuilder();
    result.append("獲得了" + exp + "點經驗");
    this.exp += exp;
    return result.toString();
  }

  public String levelUp() {
    this.exp -= (Math.pow(this.level, 3) + 60) * 3 - 150;
    this.level++;
    this.strength += 5;
    this.health += 15;

    StringBuilder result = new StringBuilder();
    result.append(this.getMyRole());
    result.append("\nLevel up");
    return result.toString();
  }

  public String getName() {
    return this.name;
  }

  public int getStrength() {
    return this.strength;
  }

  public int getHealth() {
    return this.health;
  }

  public int getExp() {
    return this.exp;
  }

  public int getLevel() {
    return this.level;
  }

}
