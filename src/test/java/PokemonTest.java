
import static org.junit.Assert.*;

import org.junit.Test;

public class PokemonTest {
  private Pokemon pokemon1;

  @Test(expected = Exception.class)
  public void Error1() throws Exception {
    pokemon1 = new Pokemon("Error", -1, 199);
  }

  @Test(expected = Exception.class)
  public void Error2() throws Exception {
    pokemon1 = new Pokemon("Error", 10, 0);
  }

  @Test(expected = Exception.class)
  public void Error3() throws Exception {
    pokemon1 = new Pokemon("Error", 100000, 80);
  }

  @Test(expected = Exception.class)
  public void Error4() throws Exception {
    pokemon1 = new Pokemon("Error", 87, 10000);
  }

  @Test
  public void strength() throws Exception {
    pokemon1 = new Pokemon("enemy", 87, 63);
    assertEquals(87, pokemon1.strength());
  }

  @Test
  public void health() throws Exception {
    pokemon1 = new Pokemon("enemy", 87, 63);
    assertEquals(63, pokemon1.health());
  }

  @Test
  public void gainExp() throws Exception {
    pokemon1 = new Pokemon("enemy", 87, 63);
    assertEquals(18, pokemon1.gainExp(18));
  }

  @Test
  public void levelUp() throws Exception {
    pokemon1 = new Pokemon("enemy", 87, 63);
    assertEquals("level up", pokemon1.levelUp());
  }

  @Test
  public void levelUp3() throws Exception {
    pokemon1 = new Pokemon("enemy", 87, 63);
    pokemon1.gainExp(30);
    pokemon1.gainExp(30);
    assertEquals("level up", pokemon1.levelUp());
  }

}
