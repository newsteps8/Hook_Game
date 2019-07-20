//Büşra GÖKMEN 150116027
//Ferihan ÇABUK 150116059

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Level5 extends Application implements ButtonStyle,Disappear{
    static boolean collision3 = false;
    static boolean collision4 = false;
    static boolean collision5= false;
    static int control=1;
    static int control2=3;
    boolean level5arr1=false;
    boolean level5arr2=false;
    boolean level5arr3=false;
    boolean level5arr4=false;


    @Override
    public void start(Stage primaryStage) {

        Button button5_1= new Button();
        button5_1.setLayoutX(480);
        button5_1.setLayoutY(350);
        buttonShapeAndColor(button5_1);

        Button button5_2 = new Button();
        button5_2.setLayoutX(480);
        button5_2.setLayoutY(400);
        buttonShapeAndColor(button5_2);

        Button button5_3= new Button();
        button5_3.setLayoutX(632);
        button5_3.setLayoutY(510);
        buttonShapeAndColor(button5_3);

        Button button5_4= new Button();
        button5_4.setLayoutX(720);
        button5_4.setLayoutY(510);
        buttonShapeAndColor(button5_4);

        DropShadow shadow = new DropShadow();
        // Constructing buttons
        Button disconnector5_ = new Button();
        disconnector5_.setLayoutX(633);
        disconnector5_.setLayoutY(350);
        buttonShapeAndColor(disconnector5_);

      //  disconnector5_.setEffect(shadow);
        Button disconnector5_1 =new Button();
        disconnector5_1.setLayoutX(633);
        disconnector5_1.setLayoutY(400);
        buttonShapeAndColor(disconnector5_1);
       // disconnector5_1.setEffect(shadow);

        //Lines and arc is created/
        LineGray line5_1 = new LineGray(658,365,698,365);
        LineGray line5_2 =  new LineGray(698,365,698,355);
        LineGray line5_3_ =  new LineGray(648,380,648,350);
        LineBlack line5_4 = new LineBlack(698,288,698,351);
        LineBlack line5_5 =  new LineBlack(698,265,698,242);
        LineGray line5_6 = new LineGray(495,365,637,365);
        Arc3 arc5_3 = new Arc3(693,281);
        LineGray line5_7 = new LineGray(495,415,765,415 );
        LineGray line5_8 = new LineGray(765,415,765,405);
        LineBlack line5_9 = new LineBlack(760,405,770,405);
        LineBlack line5_10 = new LineBlack(693,352,703,352);
        LineBlack line5_11 = new LineBlack(765,402,765,257);
        LineBlack line5_12=  new LineBlack(765,235,765,223);
        Arc2 arc5_2 = new Arc2(771,251);
        LineGray line5_13=new LineGray(648,425,648,525);
        LineGray line5_14=new LineGray(648,405,648,245);
        LineGray line5_15_= new LineGray(632,415,663,415);
        LineGray line5_16= new LineGray(648,245,658,245);
        LineBlack line5_17= new LineBlack(658,240,658,250);
        LineBlack line5_18=new LineBlack(708,245,768,245);
        LineBlack line5_19= new LineBlack(658,245,688,245);
        Arc1 arc5_1 =  new Arc1(698,245);
        LineGray line5_20= new LineGray(735,525,735,275);
        LineGray line5_21=  new LineGray(735,275,725,275);
        LineBlack line5_22=   new LineBlack(725,270,725,280);
        LineBlack line5_23= new LineBlack(725,275,694,275);
        //rectangles are created
        Rectangle_ rec1 = new Rectangle_(685,352,20,130);
        Rectangle_ rec2 = new Rectangle_(760,407,20,180);
        Rectangle_ rec3 = new Rectangle_(458,233,198,22);
        Rectangle_ rec4 = new Rectangle_(727,267,35,20);

        Rectangle winn=new Rectangle(0,0,1500,700);
        winn.setFill(Color.ALICEBLUE);

        Button btwinn=new Button();
        btwinn.setLayoutX(500);
        btwinn.setLayoutY(500);

        //object arrays for disappering
        Object[] arr5_1 = {line5_4,line5_5,line5_1,line5_2,line5_6};
        Object[] arr5_2 = {line5_9,line5_11,line5_12,line5_7,line5_8};
        Object[] arr5_3 = {line5_17,line5_18,line5_19,line5_13,line5_14,line5_16};
        Object[] arr5_4 = {line5_22,line5_23,line5_20,line5_21};

        Line white1 = new Line(10, 20, 10, 30);//trick
        Line white2 = new Line(10, 20, 10, 30);
        Line white3 = new Line(10, 20, 20, 30);
        Line white4 = new Line(10, 20, 25, 30);
        white1.setStroke(Color.WHITE);
        white2.setStroke(Color.WHITE);
        white3.setStroke(Color.WHITE);
        white4.setStroke(Color.WHITE);

        Pane pane = new Pane(  arc5_2,arc5_1,arc5_3,line5_4,line5_5,rec1,line5_1,line5_2,line5_6,//group of button5_0
                line5_10,line5_11,line5_12,rec2,line5_7,line5_8,line5_9,//group of button5_2
                line5_17,line5_18,line5_19,rec3,line5_13,line5_14,line5_16,//group of button5_3
                line5_23,rec4,line5_20,line5_21,line5_22,disconnector5_1,line5_15_,//group of button5_4
                white1,white2,white3,white4);//tricks
        //Lines,circle and arc are adding into the pane

        pane.setStyle("-fx-background-color: white;");//set the pane color
        pane.getChildren().add(button5_1);
        pane.getChildren().add(button5_2);
        pane.getChildren().add(button5_3);
        pane.getChildren().add(button5_4);
        pane.getChildren().add(disconnector5_);

        pane.getChildren().add(line5_3_);
        LineGray line_rotate1= new LineGray(633,365,664,365);
        LineGray line_rotate2= new LineGray(648,400,648,430);

        FadeTransition ft5_0 = new FadeTransition(Duration.millis(1500), white1);
        FadeTransition ft5_2 = new FadeTransition(Duration.millis(1500), white2);
        FadeTransition ft5_3 = new FadeTransition(Duration.millis(1500), white3);
        FadeTransition ft5_4 = new FadeTransition(Duration.millis(1500), white4);
        FadeTransition ft5_5 = new FadeTransition(Duration.millis(2000), pane);
        ft5_5.setFromValue(1.0);
        ft5_5.setToValue(0.0);

        FadeTransition extra = new FadeTransition(Duration.millis(1500), line5_10);
        extra.setFromValue(1.0f);
        extra.setToValue(0.0f);

        FadeTransition but_5_0 = new FadeTransition(Duration.millis(1500), button5_1);
        but_5_0.setFromValue(1.0f);
        but_5_0.setToValue(0.0f);

        FadeTransition but_5_2 = new FadeTransition(Duration.millis(1500), button5_2);
        but_5_2.setFromValue(1.0f);
        but_5_2.setToValue(0.0f);

        FadeTransition but_5_3 = new FadeTransition(Duration.millis(1500), button5_3);
        but_5_3.setFromValue(1.0f);
        but_5_3.setToValue(0.0f);

        FadeTransition but_5_4 = new FadeTransition(Duration.millis(1500), button5_4);
        but_5_4.setFromValue(1.0f);
        but_5_4.setToValue(0.0f);

        FadeTransition dis5_= new FadeTransition(Duration.millis(1500), disconnector5_);
        dis5_.setFromValue(1.0f);
        dis5_.setToValue(0.0f);

        FadeTransition dis5_1 = new FadeTransition(Duration.millis(1500), disconnector5_1);
        dis5_1.setFromValue(1.0f);
        dis5_1.setToValue(0.0f);

        FadeTransition fade_line5_3 = new FadeTransition(Duration.millis(1500),line5_3_);
        fade_line5_3.setFromValue(1.0f);
        fade_line5_3.setToValue(0.0f);

        FadeTransition fade_line5_15= new FadeTransition(Duration.millis(1500),line5_15_);
        fade_line5_15.setFromValue(1.0f);
        fade_line5_15.setToValue(0.0f);

        FadeTransition fade5_pane= new FadeTransition(Duration.millis(1500),pane);
        fade_line5_15.setFromValue(1.0f);
        fade_line5_15.setToValue(0.0f);

        fade5_pane.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {

                start(primaryStage);
            }
        });


        ft5_0.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                but_5_0.play();
                disappear(arr5_1);
                line5_10.shrinkAndDisappear2();
                buttonShrink(button5_1);
                extra.play();
                level5arr1=true;
            }
        });

        ft5_2.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                but_5_2.play();
                disappear(arr5_2);
                line5_9.shrinkAndDisappear2();
                buttonShrink(button5_2);
                level5arr2=true;
            }
        });
        ft5_3.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                but_5_3.play();
                disappear(arr5_3);
                line5_17.shrinkAndDisappear();
                buttonShrink(button5_3);
                dis5_.play();
                level5arr3=true;
            }
        });
        ft5_4.setOnFinished(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                but_5_4.play();
                disappear(arr5_4);
                line5_22.shrinkAndDisappear();
                buttonShrink(button5_4);
                level5arr4=true;
            }
        });

        EventHandler<ActionEvent> eventHandler = e -> {
            button5_1.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button5_1.setScaleX(1.25);
                    button5_1.setScaleY(1.25);

                    if(collision3==true && control==2){
                        line5_4.lineTranslationToDownorTop(110);
                        line5_5.lineTranslationToDownorTop(110);
                        arc5_3.arcTranslationUporDown(110);
                        line5_10.expandLeftAndRight();
                        collision4 = true;
                        ft5_0.play();

                    }
                    else if (collision3==false && control == 2){
                        line5_4.lineTranslationToDownorTop(5);
                        line5_5.lineTranslationToDownorTop(5);
                        arc5_3.arcTranslationUporDown(5);
                        ft5_5.setDelay(Duration.millis(1000));
                        ft5_5.play();
                        fade5_pane.play();
                        //pane is fading
                    }
                }
            });

            button5_2.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button5_2.setScaleX(1.25);
                    button5_2.setScaleY(1.25);

                    if(collision5 == true && control2==3){
                        arc5_2.arcTranslationUporDown(182);
                        line5_11.lineTranslationToDownorTop(182);
                        line5_12.lineTranslationToDownorTop(182);
                        line5_9.expandLeftAndRight();
                        ft5_2.play();
                        dis5_1.setDelay(Duration.millis(1000));
                        dis5_1.play();


                        fade_line5_15.setDelay(Duration.millis(1000));
                        fade_line5_15.play();
                    }
                    else if (collision5== false && control2==3){
                        arc5_2.arcTranslationUporDown(5);
                        line5_11.lineTranslationToDownorTop(5);
                        line5_12.lineTranslationToDownorTop(5);
                        line5_9.expandLeftAndRight();
                        ft5_5.setDelay(Duration.millis(1000));
                        ft5_5.play();//pane is fading
                        fade5_pane.play();
                    }
                }
            });
            button5_3.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button5_3.setScaleX(1.25);
                    button5_3.setScaleY(1.25);

                    if(collision4 == true && control==1 && control2==4){
                        line5_18.lineTranslationToLeftorRight(-120);
                        arc5_1.arcTranslationLeftorRight(-120);
                        line5_19.lineTranslationToLeftorRight(-120);
                        line5_17.expandBelowAndAbove();
                        ft5_3.play();
                        dis5_.setDelay(Duration.millis(1000));
                        dis5_.play();
                        fade_line5_3.setDelay(Duration.millis(1000));
                        fade_line5_3.play();
                        collision5 = true;
                    }
                    else if (collision4 == false && control==1 && control2==4){
                        line5_18.lineTranslationToLeftorRight(-5);
                        arc5_1.arcTranslationLeftorRight(-5);
                        line5_17.expandBelowAndAbove();
                        line5_19.lineTranslationToLeftorRight(-5);
                        ft5_5.setDelay(Duration.millis(1000));
                        ft5_5.play();
                    }

                }
            });
            button5_4.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    button5_4.setScaleX(1.25);
                    button5_4.setScaleY(1.25);
                    line5_23.lineTranslationToLeftorRight(28);
                    line5_22.expandBelowAndAbove();
                    ft5_4.play();
                    collision3 = true;
                }

            });

            disconnector5_.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    if(control==1){
                        pane.getChildren().add(line_rotate1);
                        pane.getChildren().remove(line5_3_);
                        control = 2;
                    }
                    else if(control==2 && (control2==4 || control2==3)){
                        pane.getChildren().remove(line_rotate1);
                        pane.getChildren().add(line5_3_);
                        control =1;
                    }
                }
            });

            disconnector5_1.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {

                    if(control2==3){

                        pane.getChildren().add(line_rotate2);
                        pane.getChildren().remove(line5_15_);

                        control2=4;
                    }

                    else if(control2==4){

                        pane.getChildren().add(line5_15_);
                        pane.getChildren().remove(line_rotate2);
                        control2=3;
                    }
                }
            });



        };
        Timeline animation = new Timeline(
                new KeyFrame(new Duration(1500), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(pane, 1500, 700);
        primaryStage.setTitle("Level 5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}