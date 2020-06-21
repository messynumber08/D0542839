
import java.util.Random;

public class Pokemon {
  private String name = null;
  private int strength = 1;
  private int health = 1;
  private int level = 1;
  private int exp = 0;

  public Pokemon(String name, int strength, int health, int level, int exp) throws Exception {
    if (name == null)
      throw new myException("name cannot be empty");

    if (strength < 1)
      throw new myException("strength cannot be less than 1");

    if (health < 1)
      throw new myException("health cannot be less than 1");

    if (level < 1)
      throw new myException("level cannot be less than 1");

    if (exp < 0)
      throw new myException("exp  cannot be less than 0");

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
    result.append(this.name + " challenged " + enemy.name);
    boolean flag = true;
    do {
      int playerStrength = random.nextInt(this.strength) + (int) (this.strength * 0.2);
      enemyHealth -= playerStrength;
      result.append("\n" + this.name + " attack," + enemy.name + " takes " + playerStrength + " damage");

      if (enemyHealth <= 0)
        break;

      int enemyStrength = random.nextInt(enemy.strength) + (int) (enemy.strength * 0.4);
      playerHealth -= enemyStrength;
      result.append("\n" + enemy.name + " attack," + this.name + " takes " + enemyStrength + " damage");

      if (playerHealth <= 0)
        flag = false;
    } while (flag);

    if (playerHealth < 1) {
      result.append("\n" + this.name + " defeated," + enemy.name + " has " + enemyHealth + " HP");
      result.append("\n" + this.gainExp(9));
    }
    if (enemyHealth < 1) {
      result.append("\n" + this.name + " won," + this.name + " has " + playerHealth + " HP");
      result.append("\n" + this.gainExp(36));
    }
    return result.toString();
  }

  public String getMyRole() {
    StringBuilder result = new StringBuilder();

    result.append("name:" + this.name + "\n");
    result.append("strength:" + this.strength + "\n");
    result.append("health:" + this.health + "\n");
    result.append("level:" + this.level + "\n");
    result.append("exp:" + this.exp);
    return result.toString();
  }

  public String gainExp(int exp) {
    StringBuilder result = new StringBuilder();
    result.append("Gained " + exp + " experience");
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
