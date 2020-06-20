
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
    String result = "player對enemy發起了挑戰\n" + "player攻擊,enemy受到37點傷害\n" + "enemy攻擊,player受到22點傷害\n"
        + "player攻擊,enemy受到11點傷害\n" + "enemy攻擊,player受到30點傷害\n" + "player攻擊,enemy受到8點傷害\n" + "player勝利了,player還有1點血量\n"
        + "獲得了36點經驗";
    player = new Pokemon("player", 35, 53, 1, 0);
    enemy = new Pokemon("enemy", 30, 50, 1, 0);
    assertEquals(result, player.battle(enemy, 100));
  }

  @Test
  public void playerLose() throws Exception {
    String result = "player對enemy發起了挑戰\n" + "player攻擊,enemy受到31點傷害\n" + "enemy攻擊,player受到22點傷害\n"
        + "player攻擊,enemy受到10點傷害\n" + "enemy攻擊,player受到30點傷害\n" + "player戰敗了,enemy還有10點血量\n" + "獲得了9點經驗";
    player = new Pokemon("player", 30, 45, 1, 0);
    enemy = new Pokemon("enemy", 30, 51, 1, 0);
    assertEquals(result, player.battle(enemy, 100));
  }

  @Test
  public void getMyRole() throws Exception {
    String result = "名稱:player\n攻擊:1\n血量:50\n等級:1\n經驗值:0";
    player = new Pokemon("player", 1, 50, 1, 0);
    assertEquals(result, player.getMyRole());
  }

  @Test
  public void gainExp() throws Exception {
    String result = "獲得了18點經驗";
    player = new Pokemon("player", 1, 50, 1, 0);
    assertEquals(result, player.gainExp(18));
    assertEquals(18, player.getExp());
  }

  @Test
  public void levelUp() throws Exception {
    String result = "名稱:player\n攻擊:6\n血量:65\n等級:2\n經驗值:-33\nLevel up";
    player = new Pokemon("player", 1, 50, 1, 0);
    assertEquals(result, player.levelUp());
    assertEquals("player", player.getName());
    assertEquals(6, player.getStrength());
    assertEquals(65, player.getHealth());
    assertEquals(2, player.getLevel());
    assertEquals(-33, player.getExp());
  }

}
