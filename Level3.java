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

public class Level3 extends Application implements ButtonStyle,Disappear{

    //Declare variables
    boolean collision3_1 = true;
    boolean collision3_2 = true;
    boolean button1Controller=false;
    boolean button2Controller=false;
    boolean button3Controller=false;
    boolean level3_control=true;

    @Override
    public void start(Stage primaryStage) {

        /*Construct the Buttons*/
        Button button3_0 = new Button();
        button3_0.setLayoutX(450);
        button3_0.setLayoutY(350);
        buttonShapeAndColor(button3_0);

        Button button3_1 = new Button();
        button3_1.setLayoutX(520);
        button3_1.setLayoutY(390);
        buttonShapeAndColor(button3_1);

        Button button3_2= new Button();
        button3_2.setLayoutX(610);
        button3_2.setLayoutY(450);
        buttonShapeAndColor(button3_2);

        //Rectangles are generated
        Rectangle_ x= new Rectangle_(760,357,30,200);
        Rectangle_ y= new Rectangle_(520,250,155,30);
        Rectangle_ z= new Rectangle_(409,185,224,40);
        Rectangle_ m= new Rectangle_(409,185,224,45);

        //Lines and arcs are created
        LineGray line3_1 = new LineGray(465, 365, 775, 365);
        LineBlack line3_2 = new LineBlack(775,355,775,287);
        LineBlack line3_3=  new LineBlack(775,265,775,202);
        LineGray line3_4 = new LineGray(775, 365,775,355);
        LineBlack line3_5 = new LineBlack(770,355,780,355);
        Arc2 arc3_2 = new Arc2(780,280);

        LineGray line3_6 = new LineGray(535,405,665,405);
        LineGray line3_7 =  new LineGray(665,405, 665,275);
        LineGray line3_8 = new LineGray(665,275,675,275);
        LineBlack line3_9 =  new LineBlack(675,270,675,280);
        LineBlack line3_10 =  new LineBlack(675,275,778,275);

        LineGray line3_11 =new LineGray(625, 475, 625, 205);
        LineGray line3_12 = new LineGray(625,205,635,205);
        LineBlack line3_13 = new LineBlack(635,200,635,210);
        LineBlack line3_14 =new LineBlack(635, 205, 763, 205);
        LineBlack line3_15 = new LineBlack(787,205,855,205);
        Arc1 arc3_3= new Arc1(775,205);

        Line white1 = new Line(10, 20, 10, 30);//trick
        Line white2 = new Line(10, 20, 15, 30);
        Line white3 = new Line(10, 20, 20, 30);
        white1.setStroke(Color.WHITE);
        white2.setStroke(Color.WHITE);
        white3.setStroke(Color.WHITE);

        //Black and gray lines are added
        Pane pane = new Pane (arc3_2, arc3_3,line3_2, line3_3,x,line3_1,line3_4,line3_5,
                line3_10,y,line3_6, line3_7,line3_8,line3_9,
                line3_15,line3_14,z,line3_11,line3_12,line3_13,
                white1,white2,white3,button3_0,button3_1,button3_2);

        pane.setStyle("-fx-background-color: white;");//set the pane color

        //Object arrays are created to disappearance end of the level
        Object[] arr3_0 = {line3_2, line3_3,line3_1,line3_4,line3_5};
        Object[] arr3_1 = {line3_10,line3_6, line3_7,line3_8,line3_9};
        Object[] arr3_2= {line3_15,line3_14,line3_11,line3_12,line3_13};

        //Fade transitions for disappearing
        FadeTransition ft3_1 = new FadeTransition(Duration.millis(1000), white1);
        FadeTransition ft3_2 = new FadeTransition(Duration.millis(1000), white2);
        FadeTransition ft3_3 = new FadeTransition(Duration.millis(1000), white3);

        FadeTransition ft3_pane = new FadeTransition(Duration.millis(1000), pane);
        ft3_pane.setFromValue(1.0);
        ft3_pane.setToValue(0.0);

        FadeTransition but_3_0 = new FadeTransition(Duration.millis(1000), button3_0);
        but_3_0.setFromValue(1.0f);
        but_3_0.setToValue(0.0f);

        FadeTransition but_3_1 = new FadeTransition(Duration.millis(1000), button3_1);
        but_3_1.setFromValue(1.0f);
        but_3_1.setToValue(0.0f);

        FadeTransition but_3_2 = new FadeTransition(Duration.millis(1000), button3_2);
        but_3_2.setFromValue(1.0f);
        but_3_2.setToValue(0.0f);

        ft3_pane.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                start(primaryStage);
            }
        });


        ft3_1.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                but_3_0.play();
                disappear(arr3_0);
                line3_5.shrinkAndDisappear2();
                buttonShrink(button3_0);
                button1Controller=true;
            }
        });

        ft3_2.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                but_3_1.play();
                disappear(arr3_1);
                line3_9.shrinkAndDisappear();
                buttonShrink(button3_1);
                button2Controller= true;
            }
        });
        ft3_3.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                but_3_2.play();
                disappear(arr3_2);
                line3_13.shrinkAndDisappear();
                buttonShrink(button3_2);
                button3Controller=true;
            }
        });

        EventHandler<ActionEvent> eventHandler = e -> {// Create  handler for animation
            button3_0.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button3_0.setScaleX(1.25);
                    button3_0.setScaleY(1.25);

                    if(collision3_1==false){//if there is no collision execution continue

                        line3_2.lineTranslationToDownorTop(200);
                        line3_3.lineTranslationToDownorTop(200);
                        line3_5.expandLeftAndRight();
                        arc3_2.arcTranslationUporDown(200);
                        ft3_1.play();
                        collision3_2 = false;

                    }
                    else {//else execution finished and pane is disappear
                        line3_2.lineTranslationToDownorTop(5);
                        line3_3.lineTranslationToDownorTop(5);
                        line3_5.expandLeftAndRight();
                        arc3_2.arcTranslationUporDown(5);
                        ft3_pane.setDelay(Duration.millis(1000));
                        ft3_pane.play();//pane sönme//fade ve delay
                    }
                }
            });

            button3_1.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button3_1.setScaleX(1.25);
                    button3_1.setScaleY(1.25);
                    line3_9.expandBelowAndAbove();
                    line3_10.lineTranslationToLeftorRight(-150);
                    ft3_2.play();
                    collision3_1 = false;

                }
            });
            button3_2.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button3_2.setScaleX(1.25);
                    button3_2.setScaleY(1.25);
                    if(collision3_2 ==false){//same logic with collision3_1
                        line3_15.lineTranslationToLeftorRight(-220);
                        line3_14.lineTranslationToLeftorRight(-220);
                        line3_13.expandBelowAndAbove();
                        arc3_3.arcTranslationLeftorRight(-220);
                        ft3_3.play();


                    }
                    else {
                        line3_15.lineTranslationToLeftorRight(-5);
                        line3_14.lineTranslationToLeftorRight(-5);
                        line3_13.expandBelowAndAbove();
                        arc3_3.arcTranslationLeftorRight(-5);
                        ft3_pane.setDelay(Duration.millis(2000));
                        ft3_pane.play();//pane sönme//fade ve delay
                    }

                }
            });
            /*If there is no collision and buttons run successfully pass second level*/
            if (button1Controller == true && button2Controller == true && button3Controller == true &&/*checkCollision() == false && */level3_control==true) {
                level3_control=false;
                Level4 level_4 = new Level4();
                level_4.start(primaryStage);
            }
        };

        Timeline animation = new Timeline(new KeyFrame(new Duration(1000),eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(pane, 1500, 700);//put the pane into the scene
        primaryStage.setTitle("Level 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
    public boolean checkCollision(){//Collision detector method
        return (collision3_1 && collision3_2);
    }
}

