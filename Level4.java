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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level4 extends Application implements ButtonStyle,Disappear{
    //Declaring Variables

    static int directionControl =1;
    boolean collision4=true;
    boolean disconnector=false;
    boolean disconnector2=false;
    boolean button1Controller=false;
    boolean button2Controller=false;
    boolean level4_control=true;


    @Override
    public void start(Stage primaryStage) {
        // Constructing buttons
        Button button4_1 = new Button();
        button4_1.setLayoutY(395);
        button4_1.setLayoutX(500);
        buttonShapeAndColor(button4_1);

        Button button4_2 = new Button();
        button4_2.setLayoutX(600);
        button4_2.setLayoutY(500);
        buttonShapeAndColor(button4_2);

        Button disconnector_4 =new Button();
        disconnector_4.setLayoutX(600);
        disconnector_4.setLayoutY(395);
        buttonShapeAndColor(disconnector_4);
      //  DropShadow shadow = new DropShadow();
      //  disconnector_4.setEffect(shadow);

        /*Constructing rectangles*/
        Rectangle_ rectangle4_1 = new Rectangle_(400, 230, 224, 40);
        Rectangle_ rectangle4_2 = new Rectangle_(750, 402, 30, 200);

        /*Lines and arc is created*/
        LineGray line4_1 = new LineGray(530, 410, 605, 410);
        LineGray line4_2 = new LineGray(627, 410, 760, 410);
        LineGray line4_3 = new LineGray(760, 410, 760, 400);
        LineBlack line4_4 = new LineBlack(755, 400, 765, 400);
        LineBlack line4_5 = new LineBlack(760, 400, 760, 252);

        LineGray line4_6 = new LineGray(615, 500, 615, 422);
        LineGray line4_7 = new LineGray(615, 425, 615, 395);
        LineGray line4_7_ =new LineGray(600,410,630,410);
        LineGray line4_8 = new LineGray(615, 398, 615, 255);
        LineGray line4_9 = new LineGray(615, 255, 625, 255);
        LineBlack line4_10 = new LineBlack(625, 250, 625, 260);
        LineBlack line4_11 = new LineBlack(625, 255, 750, 255);
        Arc1 arc4 = new Arc1(760, 255);
        LineBlack line4_12 = new LineBlack(770, 255, 803, 255);

        Line white = new Line(10, 20, 10, 30);//Extra line
        white.setStroke(Color.WHITE);

        //Arcs , lines and rectangles adding to pane
        Pane pane4 = new Pane(arc4,
                line4_1, line4_5, rectangle4_2, line4_3, line4_2, line4_4,
                white, line4_6,line4_11, line4_12, rectangle4_1, line4_8, line4_9,disconnector_4, line4_7, line4_10,button4_1,button4_2);
        pane4.setStyle("-fx-background-color: white;");

        //Object arrays are created to disappearance end of the level
        Object[] arr4_1 = {line4_3,line4_2,line4_1,line4_4};
        Object[] arr4_2 = {line4_9, line4_8,line4_6,line4_10};

        /*Fade transitions for the disappearance*/
        FadeTransition ft4_white = new FadeTransition(Duration.millis(1000), white);
        FadeTransition ft4_white2 = new FadeTransition(Duration.millis(1000), white);

        FadeTransition ftButton4_1 = new FadeTransition(Duration.millis(1000), button4_1);
        ftButton4_1.setFromValue(1.0f);
        ftButton4_1.setToValue(0.0f);

        FadeTransition ftButton4_2 = new FadeTransition(Duration.millis(1000), button4_2);
        ftButton4_2.setFromValue(1.0f);
        ftButton4_2.setToValue(0.0f);

        FadeTransition ftDisconnector4_ = new FadeTransition(Duration.millis(1000), disconnector_4);
        ftDisconnector4_.setFromValue(1.0f);
        ftDisconnector4_.setToValue(0.0f);

        FadeTransition ft4_pane=new FadeTransition(Duration.millis(1000),pane4);
        ft4_pane.setFromValue(1.0);
        ft4_pane.setToValue(0.0);

        ft4_pane.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the corresponding line shrinking end

            @Override
            public void handle(ActionEvent event) {
              start(primaryStage);
            }
        });

        ft4_white.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the corresponding line shrinking end

            @Override
            public void handle(ActionEvent event) {
                ftButton4_1.play();
                disappear(arr4_1);
                disconnector=true;
                buttonShrink(button4_1);
                line4_4.shrinkAndDisappear2();
                button1Controller=true;
                if(disconnector==true&&disconnector2==true){//disconnector is removed when 2. clicked button removing
                    ftDisconnector4_.play();
                    pane4.getChildren().remove(line4_7);
                    pane4.getChildren().remove(line4_7_);}
            }
        });

        ft4_white2.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the corresponding line shrinking end

            @Override
            public void handle(ActionEvent event) {

                disappear(arr4_2);
                ftButton4_2.play();
                disconnector2=true;
                line4_10.shrinkAndDisappear();
                button2Controller=true;
                buttonShrink(button4_2);
                 if(disconnector==true&&disconnector2==true){//disconnector is removed when 2 buttons clicked
                   ftDisconnector4_.play();
                    pane4.getChildren().remove(line4_7);
                    pane4.getChildren().remove(line4_7_);}
            }
        });

        // Create  handler for animation
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            disconnector_4.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {

                    if(directionControl ==1){//when the directionControl is 1 line rotate and parallel to x axis
                        pane4.getChildren().remove(line4_7);
                        pane4.getChildren().add(line4_7_);
                        directionControl =2;
                    }

                    else if(directionControl ==2){//when the directionControl is 2 line rotate and parallel to y axis
                        pane4.getChildren().remove(line4_7_);
                        pane4.getChildren().add(line4_7);
                        directionControl =1;
                    }


                }
            });

            button4_1.setOnAction(new EventHandler<ActionEvent>(){

                @Override
                public void handle(ActionEvent event){

                    if(directionControl ==2){//if the line is parallel with lines which connect button4_1 continue
                        button4_1.setScaleX(1.25);
                        button4_1.setScaleY(1.25);
                        line4_4.expandLeftAndRight();
                        ft4_white.play();
                        line4_5.lineTranslationToDownorTop(160);

                    }
                    collision4=false;
                }
            });


                button4_2.setOnAction(event -> {
                   if(collision4==false){//if there is no collision execution continue
                    if(directionControl ==1) {//if the line is parallel with lines which connect button4_1 continue
                        System.out.print("ferihan");
                        button4_2.setScaleX(1.25);
                        button4_2.setScaleY(1.25);
                        line4_10.expandBelowAndAbove();
                        ft4_white2.play();
                        line4_11.lineTranslationToLeftorRight(-200);
                        line4_12.lineTranslationToLeftorRight(-200);
                        arc4.arcTranslationLeftorRight(-200);
                    }}
                    else if(directionControl==1 && collision4==true) {
                       System.out.print("ferihan");
                        button4_2.setScaleX(1.25);
                        button4_2.setScaleY(1.25);
                        line4_11.lineTranslationToLeftorRight(-7);
                        line4_12.lineTranslationToLeftorRight(-7);
                        arc4.arcTranslationLeftorRight(-7);
                        ft4_pane.setDelay(Duration.millis(4000));
                        ft4_pane.play();
                    }
                });

            /*If there is no collision and buttons run successfully pass second level*/
            if (button1Controller == true && button2Controller == true  && checkCollision() == false && level4_control==true) {
                level4_control=false;
                Level5 level_5 = new Level5();
                level_5.start(primaryStage);
            }

        };

        Scene scene = new Scene(pane4, 1500, 700);//Pane adding into the scene
        primaryStage.setTitle("Level 4");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

        public static void main (String[]args){
            launch(args);

        }
        public boolean checkCollision(){//control collision
             return collision4;
      }



}