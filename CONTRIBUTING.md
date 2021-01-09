# Contributing Guidelines

***Thanks for taking out time to contribute!***

Any contributions are highly appreciated. Add customised obstacles, and make the game more interesting for everyone! 

## Setup Up Development Environment

### Linux
Package manager used for demonstration: `apt` and `snap`
- Setting up `java` : Install JDK (Recommended version 15) on your system. 

```shell
sudo apt install openjdk-15-jdk
```

- Installing `intellij-idea-community` : We recommend using IDEA Community for working on this project. You can install the same
using the following command:
```shell
sudo snap install intellij-idea-community --classic
```

- Installing `JavaFX` : Download [JavaFX](https://gluonhq.com/products/javafx/) (Recommended version 15.0.1). Extract the
file in a suitable place. Note the full path of `lib` folder.

  
- Fetch the source code of this project : `Fork` this repository. Copy the link of the forked repository. It should look 
like `https://github.com/<your_username>/Color-Switch-Game`. Open terminal and navigate to a suitable location where you would
like to save this project. If `git` is not installed on your system, install `git` first. To fetch the project, type:
```shell
git clone https://github.com/<your_username>/Color-Switch-Game
```


- Setting Up the project : Open the project folder in `Intellij IDEA`. You'll notice that `.idea` folder is created automatically. 
  Go to `Run > Edit Configurations...`. After this, click on `+` symbol to add configuration, choose `Application`from dropdown. 
  Click on `Modify Options` and choose `Add VM Options`. Fill the following fields:
```shell
Name: Main
Class: Main
VM Options: --module-path <path_to_lib_folder> --add-modules javafx.controls, javafx.fxml, javafx.media
Working Directory: <path_to_project>/out/production/Color-Switch-Game
```

- Adding `JavaFX Libraries` to project: Go to `File > Project Structre > Libraries`. Click on `+` button to add library.
  Choose `Java` from dropdown. Browse to `lib` folder of `JavaFX` folder.
  
#### Optional

- Installing `scenebuilder` : This is required if you want to edit `FXML` files with ease. Download 
  [Scene Builder](https://gluonhq.com/products/scene-builder/) (Recommended version 11.0.0). Choose the `Linux Deb` 
  format for easy installation. Simply double-click on `.deb` file and install it on your system. 

***Now you are ready to run this project! Click on run button on top right corner.***

### Windows

- *Setting up `Java`* : Download the [JDK](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html) (Recommended version 15.0.1) executable or zip archive and install it on your system. 


- *Installing `IntelliJ IDEA`* : We recommend using IntelliJ IDEA by JetBrains for working on this project. To use the Community Edition, you can download the executable or zip archive from [here](https://www.jetbrains.com/idea/download/#section=windows).


- *Installing `JavaFX`* : Download [JavaFX](https://gluonhq.com/products/javafx/) (Recommended version 15.0.1). Extract the
file in a suitable place. Note the full path of `lib` folder.

  
- *Fetch the source code of this project* : `Fork` this repository. Copy the link of the forked repository. It should look 
like `https://github.com/<USERNAME>/Color-Switch-Game`. You can download [Git for Windows](https://gitforwindows.org/) and use Git Bash, which provides a Bash emulation for using Git through command line interface.

    Open Git Bash and set the current directory to a suitable location where you would like to save this project. To clone the project repository, use the command:
```shell
git clone https://github.com/<USERNAME>/Color-Switch-Game
```


- *Setting up the project* : Open the project folder in `IntelliJ IDEA`. A `.idea` folder will be created. It contains the project metadata.
  Go to `Run > Edit Configurations...`. After this, click on `+` symbol to add configuration, choose `Application`from dropdown. The `Main` class provides entry point into the JavaFX application.

  Click on `Modify Options` and choose `Add VM Options`. Fill the following fields:
```shell
Name: Main
Class: Main
VM Options: --module-path <path_to_lib_folder> --add-modules javafx.controls,javafx.fxml,javafx.media,javafx.graphics
Working Directory: <path_to_project>/out/production/Color-Switch-Game
```

- Adding `JavaFX Libraries` to project: Go to `File > Project Structure > Libraries`. Click on `+` button to add library.
  Choose `Java` from dropdown. Browse to `lib` folder of `JavaFX` folder.
  
#### Optional

- *Installing `Scene Builder`* : It is advisable to use Scene Builder for designing the GUI components. The layout is saved by SceneBuilder in FXML files which are interpreted to render the GUI. Download [Scene Builder](https://gluonhq.com/products/scene-builder/) (Recommended version 11.0.0). Select the Windows Installer option.  

***Now you are ready to run this project! Click on run button on top right corner.***

### MacOS

Instruction for MacOS are not yet available. If you are setting this up on MacOS, please add instructions here.
Any contributions are highly appreciated.

## How to Add new Obstacles?

There are three major steps to add a new obstacle to this Game.  
  
### Step 1 : Adding FXML file

This file decides the basic layout of the obstacle. Open `Scene Bhilder` and create a new layout and save it into 
`src/obstacles/fxml`.

#### Important things to keep in mind

- The whole obstacle should be inside a parent `Pane` container. The `min-width` and `max-width` should be set to equal values
  (about ~400). Similarly, `min-width` and `max-height` should be set to equal values within similar range.
  
- Import the stylesheet in `src/style/style.css` in the parent `Pane`.

- Color the different portions of obstacle using `css` classes defined. And also, do give `fx:id` property to these
parts, as we will need to access them while doing collision check.

- To any node that you would like to give transition or animation later, set their suitable `fx:id` properties.

- To add stars to your obstacle, create empty Pane with `prefWidth` and `prefHeight` set to `75`. Set the `fx:id` property 
to it.
  
#### Template

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?import java.net.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.shape.*?>

<!-- Parent Container with min-height, min-width, max-height, max-width set -->
<Pane xmlns:fx="http://javafx.com/fxml/1" minWidth="350" minHeight="350" maxHeight="350" maxWidth="350" xmlns="http://javafx.com/javafx/11.0.1" fx:controller="obstacles.controllers.<YourObstacleControllerClass>">

    <!-- Import stylesheet -->
    <stylesheets>
        <URL value="@../../style/style.css" />
    </stylesheets>
  
    <!--Obstacle Pane-->
    <Pane fx:id="<obstacle_name>" >
  
    </Pane>
  
    <!-- To load star -->
    <Pane layoutX="138.0" layoutY="138.0" prefHeight="75" prefWidth="75">
        <Pane fx:id="star" />
    </Pane>
</Pane>
```

## Step 2 : Defining Controller Class for the Obstacle

Now that we need a `Controller` class for our obstacle, which will define the behavior of the Obstacle on screen.
We can add animations and transitions in our obstacle.

To get started, create a new `java` class inside `src/obstacles/controllers/`.

#### Important things to keep in mind

- You must extend `SuperController` class.

- You can directly access the components inside `Controller`, which were defined and given `fx:id` properties inside the `fxml` file.

- To add transitions, you can find predefined code inside `SuperController`. For eg, to add rotation, simply call 
`addRoation(Pane)` from `SuperController` class.

#### Template

```Java
package obstacles.controllers;

import global.SuperController;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import java.net.URL;
import java.util.ResourceBundle;

public class NewController extends SuperController {
    @FXML
    public Pane circle;
    @FXML
    public Arc yellowRing, blueRing, purpleRing, pinkRing;

    public NewController() {
        super();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Add transitions
        addRotation(circle);
    }
}
```

### Step 3 : Defining the Obstacle Class

This class will be actually used inside our `Game` class. It defines the collision behaviour, and defines a simple interface.

#### Important things to keep in mind

- It must extend `Obstacle` class.
- You must set the `Pane` and `Controller` as given in the template below.  
- Use `loadStar(Pane)` function to load stars inside the obstacle.
- You must `@Override` the `hasCollided(Ball b)` method. You can check collision using `Shape.intersect()` function.
See other obstacles for help.

#### Template

```Java
package obstacles;

import elements.Ball;
import javafx.scene.shape.Shape;
import obstacles.controllers.CircleController;

public class Circle extends Obstacle {
    private NewController newController;

    public Circle() {
        // Load the FXML and set 'pane' in Parent
        loadFXMLtoPane("/obstacles/fxml/<fxml_file_name>");
        newController = (NewController) controller;
        loadStar(newController.star);
    }

    @Override
    public int hasCollided(Ball b) {
        // Returns :-
        // 0  -> not collided
        // -1 -> star earned
        // 1  -> collided
        int result = 0;
        // Check for collision and set result
        return result;
    }
}
```

Now your obstacle is ready to be inserted into Game. Add your obstacle class in `Game.java` in `map` object. 
