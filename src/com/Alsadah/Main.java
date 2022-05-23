//package com.Alsadah;
//
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Font;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Main implements Serializable{
//
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
////        TextField nameOfComp = new TextField();
////        TextField idOfComp = new TextField();
////        TextField rankOfComp= new TextField();
////        TextField majorOfComp = new TextField();
////        TextField teamNameOfComp = new TextField();
////        TextField teamNumberOfComp = new TextField();
////        teamNameOfComp.setEditable(true);
////        teamNumberOfComp.setEditable(true );
////
////        nameOfComp.setEditable(true);
////        idOfComp.setEditable(true);
////        rankOfComp.setEditable(true);
////        majorOfComp.setEditable(true);
////        AtomicInteger r= new AtomicInteger();
////        comboBox.setOnAction(e->{
////            r.set(comboBox.getSelectionModel().getSelectedIndex());
////            nameOfComp.setText(name.get(r.intValue()).toString());
////            idOfComp.setText(id.get(r.intValue()).toString());
////            rankOfComp.setText(rank.get(r.intValue()).toString());
////            majorOfComp.setText(major.get(r.intValue()).toString());
////            teamNameOfComp.setText(teamName.get(r.intValue()).toString());
////            teamNumberOfComp.setText(teamNumber.get(r.intValue()).toString());
////
////        });
////        teamNameOfComp.setLayoutX(100);
////        teamNameOfComp.setLayoutY(300);
////        teamNumberOfComp.setLayoutX(100);
////        teamNumberOfComp.setLayoutY(350);
////        nameOfComp.setLayoutX(100);
////        nameOfComp.setLayoutY(105);
////        nameOfComp.setMinWidth(200);
////        idOfComp.setLayoutX(100);
////        idOfComp.setLayoutY(150);
////        idOfComp.setMinWidth(200);
////        rankOfComp.setLayoutX(100);
////        rankOfComp.setLayoutY(200);
////        rankOfComp.setMinWidth(200);
////        majorOfComp.setLayoutY(250);
////        majorOfComp.setLayoutX(100);
////        ArrayList dates   = new ArrayList();
////        ArrayList websites = new ArrayList();
////        TextField isItBasedOnTeam = new TextField();
////        isItBasedOnTeam.setLayoutX(200);
////        isItBasedOnTeam.setLayoutY(250);
////
////        Label nameLabel = new Label("Name:");
////        nameLabel.setFont(new Font(20));
////        nameLabel.setLayoutX(20);
////        nameLabel.setLayoutY(100);
////        Label dateLabel = new Label("ID:");
////        dateLabel.setFont(new Font(20));
////        dateLabel.setLayoutX(20);
////        dateLabel.setLayoutY(145);
////        Label webLabel = new Label("Rank:");
////        webLabel.setFont(new Font(20));
////        webLabel.setLayoutX(20);
////        webLabel.setLayoutY(195);
////        Label teamLabel = new Label("Major:");
////        teamLabel.setFont(new Font(20));
////        teamLabel.setLayoutX(20);
////        teamLabel.setLayoutY(245);
////        Label team = new Label("Team Name");
////        team.setFont(new Font(20));
////
////        //
////        Label teamN = new Label("Team Number:");
////        teamN.setFont(new Font(20));
////        team.setLayoutX(20);
////        team.setLayoutY(295);
////        teamN.setLayoutX(20);
////        teamN.setLayoutY(345);
////        Button close = new Button("Close");
////        Button confirm = new Button("Confirm");
////
////        confirm.setLayoutX(400);
////        confirm.setLayoutY(400);
////        close.setLayoutX(350);
////        close.setLayoutY(400);
////
////        confirm.setOnAction(e->{
//////Here should update the data by the function
////            String editedName = nameOfComp.getText();
////            String editedID = idOfComp.getText();
////            String editedRank = rankOfComp.getText();
////            String editedMajor = majorOfComp.getText();
////            String editedTeamName = teamNameOfComp.getText();
////            String editedTeamNumber = teamNumberOfComp.getText();
////            int indexInDataBase = Integer.parseInt(indexInDataBaseList.get(r.intValue()).toString());  //TODO
////            Competition competitionToBeEdited = mainDataBase.get(indexOfCompetitionInDB);
////            competitionToBeEdited.updateCompetitorDetails(indexInDataBase, new String[]{"ID;"+editedID, "Name;"+editedName, "Major;"+editedMajor, "TeamNumber;"+editedTeamNumber, "TeamName;"+editedTeamName, "Rank;"+editedRank});
////            try {
////                competitionToBeEdited.updateCompetitorsDataInExcelFile();
////            } catch (IOException ex) {
////                ex.printStackTrace();
////            }
////            edit.close();
////
////        });
////
////    }
////
////    public static ArrayList<Competition> readAndSaveCompetitionsFromDataBase() throws IOException {
////        ArrayList<Competition> DB = new ArrayList<>();
////        FileInputStream MAIN_DATA_BASE_FILE = new FileInputStream("src/Competitions Participations.xlsx" );
////        XSSFWorkbook ourExcelDB = new XSSFWorkbook(MAIN_DATA_BASE_FILE);
////        int numberOfSheets = ourExcelDB.getNumberOfSheets();
////
////        for (int i=0; i<numberOfSheets; i++){
////            XSSFSheet sheet = ourExcelDB.getSheetAt(i);
////            boolean isTeamBased = sheet.getRow(4).getLastCellNum()==5?false:true;
////            Competition c = new Competition(sheet.getSheetName(), isTeamBased);
////            DB.add(c);
////        }
////        return DB;
////    }
//}
//
