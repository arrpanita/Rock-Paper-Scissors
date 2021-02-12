package client;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Server {
    @Override
    public String getSec() {
        return super.getSec();
    }

    @FXML
    Button rock,paper,scissors;
    @FXML
    TextArea show;

    Socket s = null;
    @FXML
    public void initialize() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                s = null;
                disable();
                try {
                    s = new Socket("localhost",4999);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void disable(){
        rock.setDisable(true);
        paper.setDisable(true);
        scissors.setDisable(true);
    }
    @FXML void clickStart(ActionEvent event){
        rock.setDisable(false);
        paper.setDisable(false);
        scissors.setDisable(false);
        show.setText("You choose : ");
    }

    @FXML
    public void clickRock(ActionEvent event) throws IOException {
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        if(str.equals("rock")){
            show.setText("Server choose : "+str+ "\nTie");

        }
        else if(str.equals("paper")) {
            show.setText("Server choose : "+str+"\nYou Lose!!");

        }
        else if(str.equals("scissors")){
            show.setText("Server choose : "+str+"\nYou Win!!");

        }
        disable();
    }

    @FXML
    public void clickPaper(ActionEvent event) throws IOException {
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        if(str.equals("rock")){
            show.setText("Server choose : "+str+"\nYou Win!!");
        }
        else if(str.equals("paper")) {
            show.setText("Server choose : "+str+ "\nTie");
        }
        else if(str.equals("scissors")){
            show.setText("Server choose : "+str+"\nYou Lose!!");
        }
        disable();
    }

    @FXML
    public void clickScissors(ActionEvent event) throws IOException {
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        if(str.equals("rock")){
            show.setText("Server choose : "+str+"\nYou Lose!!");
        }
        else if(str.equals("paper")) {
            show.setText("Server choose : "+str+"\nYou Win!!");
        }
        else if(str.equals("scissors")){
            show.setText("Server choose : "+str+ "\nTie");
        }
        disable();
    }






}




