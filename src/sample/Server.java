package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Server{

    public String sec;

    public String getSec() {
        return sec;
    }

    @FXML
    private TextArea show;
    @FXML
    private Button random;

    ServerSocket ss = null;
    Socket s = null;

    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ss = new ServerSocket(4999);
                    s = ss.accept();
                    show.setText("player connecting");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    List<String> list = Arrays.asList("rock", "paper", "scissors");

    @FXML //เชื่อมปุ่ม Random
    public void randomOn(ActionEvent event) throws IOException {
        int[] rang = new int[3];
        Random random = new Random();
        int index = random.nextInt(rang.length);
        sec = list.get(index);

        show.setText("Server: "+sec);
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(sec);
        pr.flush();
    }

}