package by.bsuir.DimaVaneka.client.controller;


import by.bsuir.DimaVaneka.client.view.menu.MenuViewInput;
import by.bsuir.DimaVaneka.client.view.menu.MenuViewPrinter;
import by.bsuir.DimaVaneka.client.view.student.StudentCardViewInput;
import by.bsuir.DimaVaneka.client.view.student.StudentCardViewPrinter;
import by.bsuir.DimaVaneka.entity.StudentCard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by dima on 11/11/2021.
 */
public class ClientController implements Runnable {

    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    private void initConnection(){
        try {
            socket = new Socket("",5678);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(){
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendRequest(Object responseObject){
        try {
            outputStream.writeObject(responseObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchStudentCard(){
        String studentName = StudentCardViewInput.studentCardNameInput();
        sendRequest(studentName);
        try {
            Object responsetObject = inputStream.readObject();
            if (responsetObject instanceof StudentCard) {
                StudentCard studentCard = (StudentCard) responsetObject;
                StudentCardViewPrinter.printStudentCard(studentCard);
            }else{
                StudentCardViewPrinter.printReportNoSuchStudentCard();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void createStudentCard(){
        StudentCard studentCard = StudentCardViewInput.studentCardCreationInput();
        sendRequest(studentCard);
        try {
            Object responseObject = inputStream.readObject();
            if (responseObject instanceof String) {
                String response = (String) responseObject;
                System.out.println(response);
            } else {
                System.out.println("Uncorrect response type");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void editStudentCard(){
        String studentName = StudentCardViewInput.studentCardNameInput();
        sendRequest(studentName);
        try {
            Object responseObject = inputStream.readObject();
            if (responseObject instanceof StudentCard) {
                StudentCard studentCard = (StudentCard) responseObject;
                StudentCardViewPrinter.printStudentCard(studentCard);
                StudentCardViewInput.studentCardEditInput(studentCard);
                sendRequest(studentCard);

                Object responseObject_2 = inputStream.readObject();
                if (responseObject_2 instanceof String) {
                    String response = (String) responseObject_2;
                    System.out.println(response);
                } else {
                    System.out.println("Некорректный тип ответа.");
                }

            }else{
                StudentCardViewPrinter.printReportNoSuchStudentCard();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        initConnection();
        boolean closeConnection = false;
        while (!closeConnection) {

            MenuViewPrinter.printMenu();
            String actionChoice = MenuViewInput.menuActionInput();

            switch (actionChoice){
                case "1":{
                    searchStudentCard();
                    break;
                }
                case "2":{
                    createStudentCard();
                    break;
                }
                case "3":{
                    editStudentCard();
                    break;
                }
                case "4":{
                    closeConnection = true;
                    break;
                }
                default:{
                    System.out.println("Некорректное действие.");
                }
            }
        }
        sendRequest("CloseConnection");
        closeConnection();
    }
}
