// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/*** 
 * https://docs.ctre-phoenix.com/
 * (1) Install the CTRE Phoenix Framework Installer first. See https://github.com/CrossTheRoadElec/Phoenix-Releases/releases
 
 * (2) Add to Java project
 ** Right click build.gradle
 ** Manage vendor libraries 
 ** Install new libraries offline
 ** CTRE Phoenix.
 ** See https://docs.ctre-phoenix.com/en/stable/ch05a_CppJava.html for full documentation
 *
***/
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/*** We aren't using Sparks
 * import edu.wpi.first.wpilibj.PWMSparkMax;
 ***/

/** A number of imports used in Infite Recharge 
 * import com.ctre.phoenix.motorcontrol.NeutralMode;
 * import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
 * import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
 * import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
 * import com.kauailabs.navx.frc.AHRS;
*/



/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
 // ORIGINAL Example private final PWMSparkMax m_leftMotor = new PWMSparkMax(0);
 // ORIGINAL Example private final PWMSparkMax m_rightMotor = new PWMSparkMax(1);
 
  private final WPI_TalonSRX m_leftMotor1 = new WPI_TalonSRX(3);
  private final WPI_TalonSRX m_leftMotor2 = new WPI_TalonSRX(4);

  private final WPI_TalonSRX m_rightMotor1 = new WPI_TalonSRX(0);
  private final WPI_TalonSRX m_rightMotor2 = new WPI_TalonSRX(1);

  SpeedControllerGroup leftMotor = new SpeedControllerGroup(m_leftMotor1, m_leftMotor2);
  SpeedControllerGroup rightMotor = new SpeedControllerGroup(m_rightMotor1, m_rightMotor2);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotor, rightMotor);
  private final Joystick m_stick = new Joystick(0);

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
  }
}
