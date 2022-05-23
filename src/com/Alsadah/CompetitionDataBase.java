package com.Alsadah;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class CompetitionDataBase extends Competition implements Serializable {

    public  FileInputStream MAIN_DATA_BASE_FILE = new FileInputStream("src/Competitions Participations.xlsx" );
    public  XSSFWorkbook MAIN_DATA_BASE_WORK_BOOK = new XSSFWorkbook(MAIN_DATA_BASE_FILE);
    public String competitionSheetName;
    boolean competitionIsTeamBased;
    XSSFSheet competitionSheet;

    /**
     * [CONSTRUCTOR]
     * @param competitionSheetName --> the name of the competition sheet inside the excel file.
     * @param competitionIsTeamBased --> a boolean variables that indicates the type of the competition (Teams or indivisual) because each different type has different excel sheet format so we've to determine the competition type to let the program read it from the file properly.
     * @throws IOException --> the function throws IOException if the excel file is not found.
     */
    public CompetitionDataBase(String competitionSheetName, boolean competitionIsTeamBased) throws IOException {
        this.competitionSheetName = competitionSheetName;
        this.competitionIsTeamBased = competitionIsTeamBased;
        this.competitionSheet = MAIN_DATA_BASE_WORK_BOOK.getSheet(this.competitionSheetName);
    }


    public ArrayList<Competitor> readAndSaveCompetitorsData(){
        ArrayList<Competitor> listOfCompetitors = new ArrayList<>();

        if (competitionIsTeamBased){
            int numberOfRows = competitionSheet.getLastRowNum();
            int numberOfColumns = competitionSheet.getRow(4).getLastCellNum();
            boolean thereIsCompetitors = numberOfRows>4?true:false;
            if (thereIsCompetitors) {//////////////////////

                System.out.println(numberOfRows);
                DataFormatter formatter = new DataFormatter();
                String competitionName = formatter.formatCellValue(competitionSheet.getRow(0).getCell(1));
                String competitionLink = formatter.formatCellValue(competitionSheet.getRow(1).getCell(1));
                String competitionDate = formatter.formatCellValue(competitionSheet.getRow(2).getCell(1));

                String[][] competitorsInfo = new String[numberOfRows - 4][numberOfColumns];//TODO
                for (int currentRow = 5, compR = 0; currentRow < numberOfRows+1; currentRow++, compR++) {
                    XSSFRow row = competitionSheet.getRow(currentRow);
                    for (int currentColumn = 0; currentColumn < numberOfColumns; currentColumn++) {
                        competitorsInfo[compR][currentColumn] = formatter.formatCellValue(row.getCell(currentColumn));
                    }
                }
                for (String[] row : competitorsInfo) {
                    String name = row[2];
                    String ID = row[1];
                    String major = row[3];
                    int indexInDataBase = Integer.parseInt(row[0]);
                    String teamRank = row[6];
                    String teamName = row[5];
                    int teamNumber = Integer.parseInt(row[4]);
                    TeamMemberCompetitor competitor = new TeamMemberCompetitor(name, ID, major, indexInDataBase, teamRank, teamName, teamNumber);
                    listOfCompetitors.add(competitor);
                }
                return listOfCompetitors;
            }else {
                return listOfCompetitors;
            }
        }
        else{//COMPETITION IS SOLO BASED
            int numberOfRows = competitionSheet.getLastRowNum();
            int numberOfColumns = competitionSheet.getRow(4).getLastCellNum();

            DataFormatter formatter = new DataFormatter();
            String[][] competitorsInfo = new String[numberOfRows-4][numberOfColumns];
            for(int currentRow = 5, competitorRow = 0; currentRow<=numberOfRows; currentRow++, competitorRow++){
                XSSFRow row = competitionSheet.getRow(currentRow);
                for(int currentColumn=0; currentColumn<numberOfColumns; currentColumn++){
                    competitorsInfo[competitorRow][currentColumn] = formatter.formatCellValue(row.getCell(currentColumn));
                }
            }
            for(String[] row : competitorsInfo){
                String name = row[2];
                String ID = row[1];
                String major = row[3];
                int indexInDataBase = Integer.parseInt(row[0]);
                String competitorRank =  row[4];

                Competitor competitor = new Competitor(name, ID, major, indexInDataBase, competitorRank);
                listOfCompetitors.add(competitor);
            }
            return listOfCompetitors;
        }
    }

    public ArrayList<String> readAndSaveCompetitionData(){
        ArrayList<String> competitionDetails = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();
        /*index 0*/String competitionName = formatter.formatCellValue(competitionSheet.getRow(0).getCell(1));
        /*index 1*/String competitionLink = formatter.formatCellValue(competitionSheet.getRow(1).getCell(1));
        /*index 2*/String competitionDate = formatter.formatCellValue(competitionSheet.getRow(2).getCell(1));
        competitionDetails.add(competitionName);
        competitionDetails.add(competitionLink);
        competitionDetails.add(competitionDate);
        return competitionDetails;
    }


}
