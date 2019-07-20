//Büşra GÖKMEN 150116027
//Ferihan ÇABUK 150116059

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level1 extends Application implements ButtonStyle,Disappear{

    static boolean collision=true;
    boolean button1Controller=false;
    boolean button2Controller=false;
    static boolean level1_control=true;

    public void start(Stage primaryStage) {

        /*Construct the Buttons*/
        Button button1_1 = new Button();
        button1_1.setLayoutX(785);
        button1_1.setLayoutY(425);
        buttonShapeAndColor(button1_1);

        Button button1_2 = new Button();
        button1_2.setLayoutX(623);
        button1_2.setLayoutY(470);
        buttonShapeAndColor(button1_2);

        //Rectangles are generated
        Rectangle_ rectangle1_1 = new Rectangle_(348, 200, 200, 100);
        Rectangle_ rectangle1_2 = new Rectangle_(623, 433, 30, 300);

        //Lines and arcs are generated
        LineGray line1 = new LineGray(785, 440, 540, 440);
        LineGray line2 = new LineGray(540, 440, 540, 250);
        LineGray line3 = new LineGray(540, 250, 548, 250);
        LineBlack line4 = new LineBlack(548, 255, 548, 245);
        LineBlack line5 = new LineBlack(548, 250, 628, 250);
        Arc1 arc = new Arc1(638, 250);
        LineBlack line6 = new LineBlack(648, 250, 720, 250);
        LineGray line7 = new LineGray(638, 430, 638, 470);
        LineBlack line8 = new LineBlack(633, 430, 643, 430);
        LineBlack line9 = new LineBlack(638, 430, 638, 247);

        Line white = new Line(10, 20, 10, 30);//extra line is created
        white.setStroke(Color.WHITE);

        Pane pane = new Pane(//Black and gray lines are added
                arc,  line6, line5,
                line9, rectangle1_2,line7,button1_2,  line8,
                rectangle1_1, line3 , line1, button1_1,line4,line2
        );

        pane.setStyle("-fx-background-color: white;");//set the pane color

        //Object arrays are created to disappearance end of the level
        Object[] arr1 = {line1, line2, line3, line4};
        Object[] arr2 = {line7, line8};

        /*Fade transitions for the disappearance*/
        FadeTransition ftPane = new FadeTransition(Duration.millis(2000), pane);
        ftPane.setFromValue(1.0);
        ftPane.setToValue(0.0);

        FadeTransition ftWhite1 = new FadeTransition(Duration.millis(1500), white);
        FadeTransition ftWhite2 = new FadeTransition(Duration.millis(1500), white);

        FadeTransition ftButton = new FadeTransition(Duration.millis(1500), button1_1);
        ftButton.setFromValue(1.0f);
        ftButton.setToValue(0.0f);

        FadeTransition ftButton1 = new FadeTransition(Duration.millis(1500), button1_2);
        ftButton1.setFromValue(1.0f);
        ftButton1.setToValue(0.0f);

        ftPane.setOnFinished(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                start(primaryStage);
            }
            });

        ftWhite1.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end
            @Override
            public void handle(ActionEvent event) {
                ftButton.play();
                disappear(arr1);
                line4.shrinkAndDisappear();
                buttonShrink(button1_1);
                button1Controller=true;
            }
        });

        ftWhite2.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end
            @Override
            public void handle(ActionEvent event) {
                ftButton1.play();
                disappear(arr2);
                line8.shrinkAndDisappear2();
                buttonShrink(button1_2);
                button2Controller=true;
            }
        });

        // Create  handler for animation
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {

            button1_1.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    //button grows
                    button1_1.setScaleX(1.25);
                    button1_1.setScaleY(1.25);

                    if(checkCollision()==false){//if there is no collision execution continue
                    line4.expandBelowAndAbove();

                    line6.lineTranslationToLeftorRight(-180);

                    line5.lineTranslationToLeftorRight(-180);

                    arc.arcTranslationLeftorRight(-180);
                    ftWhite1.play();

                    }
                    else {//else execution finished and pane is disappear
                        line4.expandBelowAndAbove();
                        arc.arcTranslationLeftorRight(-7);
                        line5.lineTranslationToLeftorRight(-7);
                        line6.lineTranslationToLeftorRight(-7);
                        ftPane.setDelay(Duration.millis(1000));
                        ftPane.play();

                    }
                }
            });

            button1_2.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button1_2.setScaleY(1.25);
                    button1_2.setScaleX(1.25);
                    line8.expandLeftAndRight();
                    line9.lineTranslationToDownorTop(212);
                    ftWhite2.play();
                   collision=false;

                }
            });
                /*If there is no collision and buttons run successfully pass second level*/
            if (button1Controller == true && button2Controller == true && checkCollision() ==false &&level1_control==true) {
                    level1_control=false;
                    Level2 level_2 = new Level2();
                    level_2.start(primaryStage); }

            };
        //Timeline for handler
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(pane, 1500, 700);

        primaryStage.setTitle("Level 1");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public boolean checkCollision(){
        return collision;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

