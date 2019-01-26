
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.shape.StrokeLineCap;

/**
 * Project: Clock
 * Task: Creates a working clock that can be paused/restarted
 * @author Justin Mangan
 * Date 19 February 2018
 */

public class ClockPane extends Pane{
    
    private int hour;
    private int minute;
    private int second;
    private Timeline action;

    // Clock pane's width and height
    private double w = 600, h = 600;

    // Constructs a default clock with current time
    public ClockPane() {
        setCurrentTime();
        action = new Timeline(new KeyFrame(Duration.millis(1000), e -> moveClock()));
        action.setCycleCount(Timeline.INDEFINITE);
        action.play();
    }

    // Constructs a clock with specific time
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
        action = new Timeline(new KeyFrame(Duration.millis(1000), e -> moveClock()));
        action.setCycleCount(Timeline.INDEFINITE);
        action.play();
    }

    // Returns clock hour
    public int getHour() {
        return hour;
    }

    // Sets clock hour and redraws clock
    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    // Returns clock minute
    public int getMinute() {
        return minute;
    }

    // Sets clock minute and redraws clock
    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    // Returns second
    public int getSecond() {
        return second;
    }

    // Sets second and redraws clock
    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    // Returns clock width
    public double getW() {
        return w;
    }

    // Sets clock width
    public void setW(double w) {
        this.w = w;
        paintClock();
    }

    // Returns clock height
    public double getH() {
        return h;
    }

    // Sets clock height
    public void setH(double h) {
        this.h = h;
        paintClock();
    }

    // Sets the clock to current time
    private void setCurrentTime() {
        
        // Constructs a Calendar for the current date and time
        Calendar calendar = new GregorianCalendar();

        // Sets current hour, minute and second and redraws clock
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paintClock(); 
    }

    // Creates the clock
    private void paintClock() {
        
        // Initialize clock parameters
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double centerX = w / 2;
        double centerY = h / 2;

        // Draws clock and time points
        Circle border = new Circle(centerX, centerY, clockRadius + 10);
        border.setFill(Color.SILVER);
        border.setStroke(Color.BLACK);
        Circle face = new Circle(centerX, centerY, clockRadius);
        face.setFill(Color.BLACK);
        face.setStroke(Color.BLACK);
        Circle rivit = new Circle(centerX, centerY, 2);
        rivit.setFill(Color.BLACK);
        Circle c12 = new Circle(centerX, centerY - clockRadius + 12, 7);
        c12.setFill(Color.ANTIQUEWHITE);
        Circle c11 = new Circle(centerX - clockRadius / 2, centerY - clockRadius + 40, 4);
        c11.setFill(Color.ANTIQUEWHITE);
        Circle c10 = new Circle(centerX - clockRadius / 1.2, centerY - 120, 4);
        c10.setFill(Color.ANTIQUEWHITE);
        Circle c9 = new Circle(centerX - clockRadius + 12, centerY, 7);
        c9.setFill(Color.ANTIQUEWHITE);
        Circle c8 = new Circle(centerX - clockRadius / 1.2, centerY + 120, 4);
        c8.setFill(Color.ANTIQUEWHITE);
        Circle c7 = new Circle(centerX - clockRadius / 2, centerY + clockRadius - 40, 4);
        c7.setFill(Color.ANTIQUEWHITE);
        Circle c6 = new Circle(centerX, centerY + clockRadius - 12, 7);
        c6.setFill(Color.ANTIQUEWHITE);
        Circle c5 = new Circle(centerX + clockRadius / 2, centerY + clockRadius - 40, 4);
        c5.setFill(Color.ANTIQUEWHITE);
        Circle c4 = new Circle(centerX + clockRadius / 1.2, centerY + 120, 4);
        c4.setFill(Color.ANTIQUEWHITE);
        Circle c3 = new Circle(centerX + clockRadius - 12, centerY, 7);
        c3.setFill(Color.ANTIQUEWHITE);
        Circle c2 = new Circle(centerX + clockRadius / 1.2, centerY - 120, 4);
        c2.setFill(Color.ANTIQUEWHITE);
        Circle c1 = new Circle(centerX + clockRadius / 2, centerY - clockRadius + 40, 4);
        c1.setFill(Color.ANTIQUEWHITE);
       
        // Draw second hand
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));        
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.SILVER);
        sLine.setStrokeWidth(5);
        sLine.setStrokeLineCap(StrokeLineCap.ROUND);

        // Draw minute hand
        double mLength = clockRadius * 0.65;
        double minuteX = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.WHITE);
        mLine.setStrokeWidth(7);
        mLine.setStrokeLineCap(StrokeLineCap.ROUND);

        // Draw hour hand 
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.WHITE);
        hLine.setStrokeWidth(9);
        hLine.setStrokeLineCap(StrokeLineCap.ROUND);

        getChildren().clear();
        getChildren().addAll(border, face, c12, c11, c10, c9, c8, c7, c6, c5, c4, c3, c2, c1, sLine, mLine, hLine, rivit);
    }

    // Advances all the clock hands
    protected void moveClock() {
        if (minute == 60) {
            hour += 1; 
        }	
        if (second == 60) {
            minute += 1;
        }
        second = (second < 60 ? second + 1 : 1);
        paintClock();	
    }
    
    // Restarts animation
    public void restart() {
        action.play();
    }

    // Pauses animation
    public void stop() {
        action.pause();
    }
}
