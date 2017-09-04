import java.io.*;
import java.nio.file.Paths;
import java.lang.*;
import javafx.scene.media.*;
import javafx.embed.swing.JFXPanel;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.*;

/**
 * Launches a music player that does all the things I want it to.  Command-line usage: java BestMusicPlayer
 * This is specifically designed to be poorly coded.  If that sentence remains in the version that gets turned in, I'm going to be very suspicious...
 *
 * @author Kyle Burke <paithanq@gmail.com>
 */
public class BestMusicPlayer extends Application {
public static Label songtitle = new Label("No song currently playing.");

/**
 * Main method to launch the program.
 *
 * @param args  Command-line arguments for the program.  Currently unused.
 */
public static void main(String[] args) {launch(args);}
    
    @Override
    public void start(Stage primaryStage) 
    {
        //solution from stackoverflow user Sagar Damani at: https://stackoverflow.com/questions/14025718/javafx-toolkit-not-initialized-when-trying-to-play-an-mp3-file-through-mediap
        final JFXPanel bananarama = new JFXPanel();
        
        
        primaryStage.setTitle("The Best Music Player Ever!");
        Button button = new Button();
        button.setText("Play Wolverines Pride (3:42)");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //code to play a song modified from stackoverflow user jasonwaste's answer on https://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java
                String song = "../songs/PrideOfTheWolverines.mp3";
                Media media = new Media(new File(song).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
                songtitle.setText("Pride of the Wolverines");}});
        
        GridPane paneofgridmonkeys = new GridPane();
        paneofgridmonkeys.setAlignment(Pos.CENTER);
        paneofgridmonkeys.setVgap(10);
        paneofgridmonkeys.add(button, 0, 0);
        paneofgridmonkeys.add(songTitle, 0, 1);
        primaryStage.setScene(new Scene(paneofgridmonkeys, 300, 250));
        primaryStage.show();
    }

} //end of BestMusicPlayer.java