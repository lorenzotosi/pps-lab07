package ex2

import ex2.Direction.North
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MyRobots extends AnyFlatSpec with Matchers:
  "A robot with battery" should " move only when the battery is not empty" in:
    val robot = RobotWithBattery(SimpleRobot((0, 0), North))
    robot.batteryLevel should be(100)
    robot.act()
    robot.batteryLevel should be(50)
    robot.act()
    robot.batteryLevel should be(0)
    robot.act()
    robot.batteryLevel should be(0)
    robot.position should be(0, 2)

  "A RobotCanFail" should "has a probability to fail" in:
    val robot = RobotCanFail(SimpleRobot((0, 0), North), 100)
    robot.act()
    robot.position should be (0,0)

    val robot2 = RobotCanFail(SimpleRobot((0, 0), North), 0)
    robot2.act()
    robot2.position should be (0, 1)

  "A RobotRepeated" should "repeat its action a number of times" in:
    val robot = RobotRepeated(SimpleRobot((0, 0), North), 3)
    robot.position should be (0,0)
    robot.act()
    robot.position should be (0, 3)
