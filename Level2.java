//Büşra GÖKMEN 150116027
//Ferihan ÇABUK 150116059

import javafx.animation.FadeTransition;
        import javafx.animation.KeyFrame;
        import javafx.animation.Timeline;
        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.scene.Scene;
        import javafx.scene.layout.Pane;
        import javafx.scene.paint.Color;
        import javafx.scene.shape.Line;
        import javafx.stage.Stage;
        import javafx.scene.control.Button;
        import javafx.util.Duration;

public class Level2 extends Application implements ButtonStyle,Disappear{
    /*game variables*/

    static boolean collision=true;
    static boolean collision2=true;
    static boolean level2_control=true;
    boolean button1Controller=false;
    boolean button2Controller=false;
    boolean button3Controller=false;
    boolean button4Controller=false;

    @Override
    public void start(Stage primaryStage) {

        /*Construct the buttons*/
        Button button2_1 = new Button();
        button2_1.setLayoutX(485);
        button2_1.setLayoutY(500);
        buttonShapeAndColor(button2_1);

        Button button2_2 = new Button();
        button2_2.setLayoutX(625);
        button2_2.setLayoutY(500);
        buttonShapeAndColor(button2_2);

        Button button2_3 = new Button();
        button2_3.setLayoutX(710);
        button2_3.setLayoutY(500);
        buttonShapeAndColor(button2_3);

        Button button2_4 = new Button();
        button2_4.setLayoutX(845);
        button2_4.setLayoutY(500);
        buttonShapeAndColor(button2_4);

        /*Construct the Rectangles*/
        Rectangle_ rec2_1=new Rectangle_(300,310,205,20);
        Rectangle_ rec2_2=new Rectangle_(620,451,40,160);
        Rectangle_ rec2_3=new Rectangle_(715,452,20,160);
        Rectangle_ rec2_4=new Rectangle_(852,340,500,50);


        /*Adding lines and Arcs*/
        LineGray line2_1=   new LineGray(500, 500, 500, 320);
        LineGray line2_2=   new LineGray(500, 320, 505, 320);
        LineBlack line2_3=  new LineBlack(505, 315, 505, 325);
        LineBlack line2_4=  new LineBlack(505, 320, 643, 320);

        LineGray line2_5=   new LineGray(640, 500, 640, 450);
        LineBlack line2_6=  new LineBlack(635, 450, 645, 450);
        LineBlack line2_7=   new LineBlack(640, 450, 640, 380);
        Arc3 arc= new Arc3(635, 375);
        LineBlack line2_8=new LineBlack(640, 360, 640, 330);
        Arc2 arc1=new Arc2(645, 325);
        LineBlack line2_9=new LineBlack(640, 310, 640, 280);

        LineGray line2_10= new LineGray(725, 500, 725, 450);
        LineBlack line2_11=new LineBlack(720, 450, 730, 450);
        LineBlack line2_12=new LineBlack(725, 450, 725, 367);

        LineGray line2_13= new LineGray(860, 370, 860, 500);
        LineGray line2_14= new LineGray(850, 370, 860, 370);
        LineBlack line2_15=new LineBlack(850, 365, 850, 375);
        Arc1 arc3= new Arc1(725, 370);
        LineBlack line2_16=  new LineBlack(735, 370, 850, 370);
        LineBlack line2_17=new LineBlack(637, 370, 715, 370);

        Line white = new Line(10, 20, 10, 30);//extra line is created
        white.setStroke(Color.WHITE);

        Pane pane = new Pane(//adding this object into the pane
                arc,arc1,arc3,
                line2_4,rec2_1,line2_1,line2_2,line2_3,
                line2_7,line2_8,line2_9,rec2_2,line2_5,line2_6,
                line2_12, rec2_3,line2_10,line2_11
               ,line2_16,line2_17, rec2_4,line2_13,  line2_14  ,line2_15
                ,button2_1,button2_2,button2_3,button2_4,white
        );
        pane.setStyle("-fx-background-color: white;");//set the pane color

        //Object arrays are created to disappearence end of the level
        Object[] arr2_1 = {line2_1, line2_2, line2_3};
        Object[] arr2_2 = {line2_5, line2_6};
        Object[] arr2_3 = {line2_10, line2_11};
        Object[] arr2_4 = {line2_13,line2_14,line2_15};

        /*Fade transitions for the disappearance*/
        FadeTransition ft2_1 = new FadeTransition(Duration.millis(1000), button2_1);
        ft2_1.setFromValue(1.0f);
        ft2_1.setToValue(0.0f);

        FadeTransition ft2_2 = new FadeTransition(Duration.millis(1000), button2_2);
        ft2_2.setFromValue(1.0f);
        ft2_2.setToValue(0.0f);

        FadeTransition ft2_3 = new FadeTransition(Duration.millis(1000), button2_3);
        ft2_3.setFromValue(1.0f);
        ft2_3.setToValue(0.0f);

        FadeTransition ft2_4 = new FadeTransition(Duration.millis(1000), button2_4);
        ft2_4.setFromValue(1.0f);
        ft2_4.setToValue(0.0f);

        FadeTransition ft4_pane=new FadeTransition(Duration.millis(1000),pane);
        ft4_pane.setFromValue(1.0);
        ft4_pane.setToValue(0.0);

        FadeTransition ftWhite1 = new FadeTransition(Duration.millis(1000), white);
        FadeTransition ftWhite2 = new FadeTransition(Duration.millis(1000), white);
        FadeTransition ftWhite3 = new FadeTransition(Duration.millis(1000), white);
        FadeTransition ftWhite4 = new FadeTransition(Duration.millis(1000), white);

        ft4_pane.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                start(primaryStage);

            }
        });

        ftWhite1.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                ft2_1.play();
                disappear(arr2_1);
                line2_3.shrinkAndDisappear();
                buttonShrink(button2_1);
                button1Controller=true;

            }
        });

        ftWhite2.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                disappear(arr2_2);
                ft2_2.play();
                buttonShrink(button2_2);
                button2Controller=true;

            }
        });
        ftWhite3.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                ft2_3.play();
                disappear(arr2_3);
                buttonShrink(button2_3);
                button3Controller=true;
            }
        });


        ftWhite4.setOnFinished(new EventHandler<ActionEvent>(){//Fade when the line shrinking end

            @Override
            public void handle(ActionEvent event) {
                buttonShrink(button2_4);
                disappear(arr2_4);
                ft2_4.play();
                button4Controller=true;
            }
        });

        // Create collision3_1 handler for animation && buttons actions
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            button2_1.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button2_1.setScaleX(1.25);
                    button2_1.setScaleY(1.25);
                    line2_3.expandBelowAndAbove();
                    ftWhite1.play();
                    line2_4.lineTranslationToLeftorRight(-150);
                    collision=false;

                }
            });

            button2_2.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button2_2.setScaleX(1.25);
                    button2_2.setScaleY(1.25);

                    if(collision==false&&collision2==false){//if there is no collision execution continue
                        ftWhite2.play();
                        line2_7.lineTranslationToDownorTop(150);
                        line2_8.lineTranslationToDownorTop(150);
                        line2_9.lineTranslationToDownorTop(150);
                        arc1.arcTranslationUporDown(150);
                        arc.arcTranslationUporDown(150);
                        line2_6.expandLeftAndRight();

                    }
                    else {//there is collision and execution end
                        line2_6.expandLeftAndRight();
                        arc.arcTranslationUporDown(7);
                        arc1.arcTranslationUporDown(7);
                        line2_7.lineTranslationToDownorTop(7);
                        line2_8.lineTranslationToDownorTop(7);
                        line2_9.lineTranslationToDownorTop(7);
                        ft4_pane.setDelay(Duration.millis(1000));
                        ft4_pane.play();
                    }

                }
            });
            button2_3.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button2_3.setScaleX(1.25);
                    button2_3.setScaleY(1.25);
                    ftWhite3.play();
                    line2_12.lineTranslationToDownorTop(150);
                    line2_11.expandLeftAndRight();
                    collision2=false;
                }
            });

            button2_4.setOnAction(new EventHandler<ActionEvent>(){//same logic like button2_1

                @Override
                public void handle(ActionEvent event) {
                    button2_4.setScaleX(1.25);
                    button2_4.setScaleY(1.25);

                    if(collision2==false) {
                        arc3.arcTranslationLeftorRight(350);
                        line2_16.lineTranslationToLeftorRight(350);
                        line2_17.lineTranslationToLeftorRight(350);
                        ftWhite4.play();
                        line2_15.expandBelowAndAbove();
                    }

                    else{
                        line2_15.expandBelowAndAbove();
                        arc3.arcTranslationLeftorRight(7);
                        line2_17.lineTranslationToLeftorRight(7);
                        line2_16.lineTranslationToLeftorRight(7);
                        ft4_pane.setDelay(Duration.millis(1000));
                        ft4_pane.play();

                    }
                }
            });
                /*If there is no collision and buttons run successfully pass second level*/
            if (button1Controller == true && button2Controller == true && checkCollision() == false &&  level2_control==true) {
                level2_control=false;
                Level3 level_3 = new Level3();
                level_3.start(primaryStage);
            }
        };

        Scene scene = new Scene(pane, 1500, 700);//put the pane into the scene
        primaryStage.setTitle("Level 2");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    public boolean checkCollision(){
        return (collision && collision2);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
