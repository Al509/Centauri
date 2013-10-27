package centauri.ui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.{Parent, Scene}
;

import javafx.scene.canvas.Canvas;


import javafx.stage.Stage
import javafx.fxml.FXMLLoader
import centauri.core.{Vector2d, Core}
;

class CentauriApp extends Application {
  val engine = new Core
  var canvas : Canvas = null
  var controller : Controller = null

  @Override
  def start(primaryStage: Stage) {

    val str = getClass.getResource("/sample.fxml")
    val loader = new FXMLLoader(str)
    loader.load()
    val root: Parent = loader.getRoot[Parent]
    primaryStage.setTitle("Hello World")
    primaryStage.setScene(new Scene(root, 500, 500))
    primaryStage.show()

    val thread = new Thread(engine)
    thread.start()


    //val root = new Group();
    //val scene = new Scene(root, 650, 220, Color.rgb(0, 0, 0));

    // create a canvas node
    //val canvas = new Canvas;
    controller = loader.getController[Controller]
    canvas = loader.getController[Controller].canvas

    // bind the dimensions when the user resizes the window.
    canvas.widthProperty().bind(primaryStage.widthProperty());
    canvas.heightProperty().bind(primaryStage.heightProperty());

    // obtain the GraphicsContext (drawing surface)
    val gc = canvas.getGraphicsContext2D();

    // create three clocks
    val blueClock = new ArcClock(20, ArcClock.BLUE1, ArcClock.BLUE2, 200);
    val greenClock = new ArcClock(20, ArcClock.BLUE1, ArcClock.GREEN1, 200);
    val redClock = new ArcClock(20, ArcClock.BLUE1, ArcClock.RED1, 200);
//
    // create an animation (update & render loop)
    new AnimationTimer {
      val scalefactor = 500000
      val shiftx = 500
      val shifty = 500

      def transform(vector2d: Vector2d): Vector2d = {
        new Vector2d(shiftx + vector2d.x / scalefactor, shifty + vector2d.y / scalefactor)
      }

      def scale(d: Double) : Double = {
        val size = d/scalefactor
        if(d < 1)
          1
        else
          size
      }

      @Override
      def handle(now : Long) {
        gc.clearRect(0, 0, primaryStage.getWidth(),primaryStage.getHeight());
        val builder = new StringBuilder
        for (element <- engine.array) {
          val position = transform(element.position)
          val size = scale(element.size)

          builder.append("label size = " + size + " position = " + position+ "\n")
          gc.fillOval(position.x-size/2, position.y-size/2, size, size)
          gc.fillText(element.name, position.x, position.y )
        }
        controller.earthLabel.setText(builder.toString())

        gc.fillOval(100, 100, 100, 100)

//        // update clocks
//        blueClock.update(now);
//        greenClock.update(now);
//        redClock.update(now);
//
//        // clear screen
//        gc.clearRect(0, 0, primaryStage.getWidth(),
//          primaryStage.getHeight());
//
//        // draw blue clock
//        blueClock.draw(gc);
//        // save the origin or the current state
//        // of the Graphics Context.
//        gc.save();
//
//        // shift x coord position the width of a clock plus 20 pixels
//        gc.translate(blueClock.maxDiameter + 20, 0);
//        greenClock.draw(gc);
//
//        // shift x coord position past the first clock
//        gc.translate(blueClock.maxDiameter + 20, 0);
//        redClock.draw(gc);
//
//        // reset Graphics Context to last saved point.
//        // Translate x, y to (0,0)
//        gc.restore();

      }
    }.start()

    // add the single node onto the scene graph
    //root.getChildren().add(canvas);
    //primaryStage.setScene(scene);
    //primaryStage.show();
  }

}