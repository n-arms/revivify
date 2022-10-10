# revivify
A library that aims to reduce code duplication in wpilib projects

## rationale
### goals
- make it easier for future [arctos](https://github.com/arctos6135) programmers to develop robot code
- abstract over code that is repeated between years

### non-goals
- provide a general high-level abstraction over wpilib. Revivify will focus on making common tasks easier rather than reducing boilerplate for all wpilib code

### data
A quick `find . -type f -exec wc -l {} \; | sort -rn | head` shows that the largest files (by number of lines) in [arctos's 2022 codebase](https://github.com/arctos6135/frc-2022-updated) are:

475 ./frc/robot/RobotContainer.java
449 ./frc/robot/subsystems/Drivetrain.java
442 ./frc/robot/util/Limelight.java
337 ./frc/robot/commands/auto/routines/ThreeBallExitAuto.java
320 ./frc/robot/commands/auto/routines/ThreeBallTerminalAuto.java
304 ./frc/robot/commands/auto/routines/ThreeBallAuto.java
291 ./frc/robot/subsystems/Shooter.java
279 ./frc/robot/commands/auto/routines/TwoBallAuto.java
275 ./frc/robot/commands/auto/routines/TwoBallWallAuto.java
266 ./frc/robot/commands/auto/routines/TwoBallExitAuto.java

These can be broken down into 5 categories:

#### RobotContainer
This file is entirely too big. It manages three things, each of which should probably be its own file:
1. Setting up relevant commands and subsystems
2. Configuring Shuffleboard
3. Configuring buttons on XboxController objects

Point 1. is the primary feature of RobotContainer, but numbers 2 and 3 contain enough logic that they should be abstracted out into (hopefully reusable) classes

#### Drivetrain
This file contains the code for the drivetrain subsystem. It seems unlikely that arctos will use a non-tank drive in the near future so it makes sense to put a generic tank drive implementation into revivify.

#### Limelight
This file contains logic for streaming limelight data to the dashboard. We could just copy and paste it into revivify, it is already very generic and reusable. The primary reason it is so long isn't the complexity of code, but rather the number of comments.

#### Auto Commands
[The files](https://github.com/Arctos6135/frc-2022-updated/tree/master/src/main/java/frc/robot/commands/auto/routines) contain logic for autonomous commands. Autonomous is the meat and potatoes of FRC code and changes every year, but it still seems like there is some boilerplate that can be abstracted away.

#### Shooter
This file contains the code for the shooter subsystem. Shooters tend to be fairly similar, so it might be possible to include a generic shooter implementation in revivify, but it would have to be very basic and not very customizable and might not be worth the effort.

## features
Based off of the largest, most duplicated code, revivify should include
- a reusable abstraction over Shuffleboard including streaming limelight data **(hard)**
- a reusable abstraction over XboxControllers **(hard)**
- a generic drivetrain implementation that allows for customization **(easy)**
- an abstraction to reduce common boilerplate in autonomous commands **(hard)**
- potentially a generic shooter implementation **(easy)**

