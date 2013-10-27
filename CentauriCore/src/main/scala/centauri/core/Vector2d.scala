package centauri.core

import java.lang.reflect.Field

class Vector2d(val x: Double, val y: Double) {
  val this.x = x
  val this.y = y

  override def toString() = {
    getClass().getDeclaredFields().map { field:Field =>
      field.setAccessible(true)
      field.getName() + ": " + field.getType() + " = " + field.get(this).toString()
    }.mkString("\n")
  }

}
