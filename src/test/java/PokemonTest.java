
import static org.junit.Assert.*;
import org.junit.Test;

public class PokemonTest {
  private Pokemon player, enemy;

  @Test(expected = Exception.class)
  public void Error1() throws Exception {
    player = new Pokemon("Error", -1, 199);
  }

  @Test(expected = Exception.class)
  public void Error2() throws Exception {
    player = new Pokemon("Error", 10, 0);
  }

  @Test(expected = Exception.class)
  public void Error3() throws Exception {
    player = new Pokemon("Error", 100000, 80);
  }

  @Test(expected = Exception.class)
  public void Error4() throws Exception {
    player = new Pokemon("Error", 87, 10000);
  }

  @Test
  public void strength() throws Exception {
    player = new Pokemon("player", 87, 63);
    assertEquals(87, player.strength());
  }

  @Test
  public void health() throws Exception {
    player = new Pokemon("player", 87, 63);
    assertEquals(63, player.health());
  }

  @Test
  public void gainExp() throws Exception {
    player = new Pokemon("player", 87, 63);
    assertEquals(18, player.gainExp(18));
  }

  @Test
  public void levelUp() throws Exception {
    player = new Pokemon("player", 87, 63);
    assertEquals("level up", player.levelUp());
  }

  @Test
  public void levelUp3() throws Exception {
    player = new Pokemon("player", 87, 63);
    player.gainExp(30);
    player.gainExp(30);
    assertEquals("level up", player.levelUp());
  }

  @Test
  public void playerWin() throws Exception {
    player = new Pokemon("player", 50, 79);
    enemy = new Pokemon("enemy", 50, 79);
    String result = player.battle(enemy, 100);
//    System.out.println(result);
    assertEquals(result, player.battle(enemy, 100));
  }

  @Test
  public void enemyWin() throws Exception {
    player = new Pokemon("player", 40, 105);
    enemy = new Pokemon("enemy", 40, 105);
    String result = player.battle(enemy, 100);
//    System.out.println(result);
    assertEquals(result, player.battle(enemy, 100));
  }
}
