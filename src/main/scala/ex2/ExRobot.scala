package ex2

import scala.util.Random

class RobotWithBattery(val robot: Robot) extends Robot:
  var batteryLevel = 100
  export robot.{position, direction, turn}
  override def act(): Unit =
    if batteryLevel > 0 then
      robot.act()
      println(robot.toString)
      batteryLevel = batteryLevel - 50
    else
      println("No energy")

class RobotCanFail(val robot: Robot, val failProbability: Int) extends Robot:
  require(failProbability >= 0 && failProbability <= 100, "failProbability deve essere compreso tra 0 e 10")

  export robot.{position, direction, turn}
  private val random: Random = Random
  override def act(): Unit =
    if random.nextInt(101) <= failProbability then println("Fail!") else robot.act()

class RobotRepeated(val robot: Robot, val times: Int) extends Robot:
  export robot.{position, direction, turn}
  override def act(): Unit =
    for _ <- 1 to times do
      robot.act()
