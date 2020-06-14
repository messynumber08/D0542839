
import java.util.Random;

public class Pokemon {
  private String name = null;
  private int health = 0;
  private int strength = 0;
  private int level = 1;
  private int exp = 0;

  public Pokemon(String name, int strength, int health) throws Exception {

    if (health < 1 || health > 1023 || strength < 1 || strength > 1023) {
      throw new Exception();
    }

    this.name = name;
    this.health = health;
    this.strength = strength;
  }

  public String battle(Pokemon enemy, int seed) {
    Random random = new Random(seed);
    StringBuilder result = new StringBuilder();
    int health1 = this.health;
    int health2 = enemy.health;
    result.append(this.name + "��" + enemy.name + "�o�_�F�D��");
    boolean flag = true;
    do {

      int attack1 = random.nextInt(this.strength) + (int) (this.strength * 0.2);
      health2 -= attack1;
      result.append("\n" + this.name + "����," + enemy.name + "����" + attack1 + "�I�ˮ`");

      if (health2 <= 0)
        break;

      int attack2 = random.nextInt(enemy.strength) + (int) (enemy.strength * 0.4);
      health1 -= attack2;
      result.append("\n" + enemy.name + "����," + this.name + "����" + attack2 + "�I�ˮ`");

      if (health1 <= 0)
        flag = false;
    } while (flag);

    if (health1 < 1) {
      result.append("\n" + this.name + "�ԱѤF," + enemy.name + "�٦�" + health2 + "�I��q");
    } else {
      result.append("\n" + this.name + "�ӧQ�F," + this.name + "�٦�" + health1 + "�I��q");
    }
    return result.toString();
  }

  public String getMyRole() {
    StringBuilder result = new StringBuilder();

    result.append("�W��:" + this.name);
    result.append("\n" + "����" + this.strength);
    result.append("\n" + "��q" + this.health);
    result.append("\n" + "����" + this.level);
    result.append("\n" + "�g���" + this.exp);
    return result.toString();
  }

  public int gainExp(int exp) {
    this.exp += exp;
    if (this.exp >= (Math.pow(this.level, 3) + 60) * 3 - 150) {
      this.levelUp();
    }
    return this.exp;
  }

  public String levelUp() {
    this.exp -= (Math.pow(this.level, 3) + 60) * 3 - 150;
    this.level++;
    this.strength += 5;
    this.health += 15;

    this.getMyRole();
    return "level up";
  }

  public int strength() {
    return this.strength;
  }

  public int health() {
    return this.health;
  }

}
