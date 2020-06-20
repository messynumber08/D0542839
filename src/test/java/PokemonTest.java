
import static org.junit.Assert.*;
import org.junit.Test;

public class PokemonTest {
  private Pokemon player, enemy;

  @Test
  public void Edge() throws Exception {
    player = new Pokemon("player", 1, 1, 1, 0);
  }

  @Test
  public void Edge2() throws Exception {
    player = new Pokemon("player", 2, 2, 2, 1);
  }

  @Test(expected = Exception.class)
  public void nameEdge() throws Exception {
    player = new Pokemon(null, 1, 1, 1, 0);
  }

  @Test(expected = Exception.class)
  public void strengthEdge() throws Exception {
    player = new Pokemon("player", 0, 1, 1, 0);
  }

  @Test(expected = Exception.class)
  public void healthEdge() throws Exception {
    player = new Pokemon("player", 1, 0, 1, 0);
  }

  @Test(expected = Exception.class)
  public void levelEdge() throws Exception {
    player = new Pokemon("player", 1, 1, 0, 0);
  }

  @Test(expected = Exception.class)
  public void expEdge() throws Exception {
    player = new Pokemon("player", 1, 1, 1, -1);
  }

  @Test
  public void playerWin() throws Exception {
    String result = "player challenged enemy\n" + "player attack,enemy takes 37 damage\n"
        + "enemy attack,player takes 22 damage\n" + "player attack,enemy takes 11 damage\n"
        + "enemy attack,player takes 30 damage\n" + "player attack,enemy takes 8 damage\n"
        + "player won,player has 1 HP\n" + "Gained 36 experience";
    player = new Pokemon("player", 35, 53, 1, 0);
    enemy = new Pokemon("enemy", 30, 50, 1, 0);
    assertEquals(result, player.battle(enemy, 100));
  }

  @Test
  public void playerLose() throws Exception {
    String result = "player challenged enemy\n" + "player attack,enemy takes 31 damage\n"
        + "enemy attack,player takes 22 damage\n" + "player attack,enemy takes 10 damage\n"
        + "enemy attack,player takes 30 damage\n" + "player defeated,enemy has 10 HP\n" + "Gained 9 experience";
    player = new Pokemon("player", 30, 45, 1, 0);
    enemy = new Pokemon("enemy", 30, 51, 1, 0);
    assertEquals(result, player.battle(enemy, 100));
  }

  @Test
  public void getMyRole() throws Exception {
    String result = "name:player\nstrength:1\nhealth:50\nlevel:1\nexp:0";
    player = new Pokemon("player", 1, 50, 1, 0);
    assertEquals(result, player.getMyRole());
  }

  @Test
  public void gainExp() throws Exception {
    String result = "Gained 18 experience";
    player = new Pokemon("player", 1, 50, 1, 0);
    assertEquals(result, player.gainExp(18));
    assertEquals(18, player.getExp());
  }

  @Test
  public void levelUp() throws Exception {
    String result = "name:player\nstrength:6\nhealth:65\nlevel:2\nexp:-33\nLevel up";
    player = new Pokemon("player", 1, 50, 1, 0);
    assertEquals(result, player.levelUp());
    assertEquals("player", player.getName());
    assertEquals(6, player.getStrength());
    assertEquals(65, player.getHealth());
    assertEquals(2, player.getLevel());
    assertEquals(-33, player.getExp());
  }

}
