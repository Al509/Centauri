package centauri.ui

import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.control.{Button, Label}

class Controller {
  @FXML var canvas : Canvas = null
  @FXML var earthLabel : Label = null
  @FXML var sunLabel: Label = null
  @FXML var timeLabel: Label = null
  @FXML var pauseButton: Button = null

  def initialize() {

  }
}


