package centauri.core

class Core extends Runnable {
  val array = new Array[SpaceObject](2)
  array(0) = new SpaceObject(new Vector2d(0,0), 1391000, "sun")
  array(1) = new SpaceObject(new Vector2d(149600000*Math.sin(Math.PI/4), 149600000*Math.cos(Math.PI/4)), 12742, "earth")
  var timestamp : Long   = 0

  def run() = {
    var angle = 0.0
    while (true) {
      Thread.sleep(1)
      angle += 0.001
      val earth = array(1)
      earth.position = new Vector2d(149600000*Math.sin(angle), 149600000*Math.cos(angle))
    }
  }
}
