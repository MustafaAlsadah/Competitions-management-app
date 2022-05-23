package com.Alsadah;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Competition implements Serializable {
    ArrayList<String> competitionDetails;
    String date;
    CompetitionDataBase excelDataBase;
    String link;
    boolean isTeamBased;
    ArrayList<Competitor> listOfCompetitors;
    String nameOfCompetition;
    ArrayList<Competitor> listOfWinners;
    public Competition() throws IOException {}

    public Competition (String sheetName, boolean isItTeamBased) throws IOException {
        this.excelDataBase = new CompetitionDataBase(sheetName, isItTeamBased);
        this.isTeamBased = isItTeamBased;
        this.listOfCompetitors = excelDataBase.readAndSaveCompetitorsData();

        competitionDetails = excelDataBase.readAndSaveCompetitionData();
        this.link = competitionDetails.get(1);
        this.nameOfCompetition = competitionDetails.get(0);
        this.date = competitionDetails.get(2);
    }

    public void addNewStudent(Competitor newStudent){
        listOfCompetitors.add(newStudent);
    }
    public void addNewTeam(ArrayList<TeamMemberCompetitor> teamStudents){
        for (TeamMemberCompetitor competitor : teamStudents){
            listOfCompetitors.add(competitor);
        }
    }

    /**
     *
     * @param indexInDataBase: The index of the competitor in the excel sheet
     * @param itemsToEdit: ["ID;201918765", "Name;Ali", "Major;MKT", "TeamNumber;2", "TeamName;Tigers", "Rank;1"]
     */
    public void updateCompetitorDetails(int indexInDataBase, String[] itemsToEdit){
        for (Competitor competitor : listOfCompetitors){
            if (competitor.indexInDataBase==indexInDataBase){
                for (String detail : itemsToEdit){
                    String[] detailElements = detail.split(";");
                    switch (detailElements[0]){
                        case "ID":
                            competitor.setID(detailElements[1]);
                            break;
                        case "Name":
                            competitor.name=detailElements[1];
                            break;
                        case "Major":
                            competitor.major=detailElements[1];
                            break;
                        case "Rank":
                            if (competitor instanceof  TeamMemberCompetitor)
                                ((TeamMemberCompetitor)competitor).teamRank=detailElements[1];
                            else
                                competitor.rank=detailElements[1];
                            break;
                        case "TeamNumber":
                            if (competitor instanceof TeamMemberCompetitor)
                                ((TeamMemberCompetitor)competitor).teamNumber=Integer.parseInt(detailElements[1]);
                            break;
                        case "TeamName":
                            if (competitor instanceof TeamMemberCompetitor)
                                ((TeamMemberCompetitor)competitor).teamName=detailElements[1];
                            break;
                    }
                }
            }else {
                continue;
            }
        }
    }

    /**
     * [Clears the winners list and add new winners (update)]
     * @param winnersList: list that contains Competitors object of winners
     */
    public void updateWinners(ArrayList<Competitor> winnersList){
        listOfWinners.clear();
        for (Competitor winner : winnersList){
            listOfWinners.add(winner);
        }
    }

    public void updateCompetitorsDataInExcelFile() throws IOException {
        String[][] updatedData = readAndSaveCompetitorsDataIn2DArray(this.isTeamBased);
        int numberOfRows = updatedData.length;
        int numberOfColumns = updatedData[0].length;

        for (int r=0; r<numberOfRows; r++){
            XSSFRow currentRow = excelDataBase.competitionSheet.getRow(r+5);
            for (int c=0; c<numberOfColumns; c++){
                XSSFCell cuurentCell = currentRow.getCell(c);
                String currentValue = updatedData[r][c];
                cuurentCell.setCellValue(currentValue);
            }
        }
        FileOutputStream outstream = new FileOutputStream("src/Competitions Participations.xlsx");
        excelDataBase.MAIN_DATA_BASE_WORK_BOOK.write(outstream);
        outstream.close();
    }

    public String[][] readAndSaveCompetitorsDataIn2DArray(boolean isTeamBased){
        if (isTeamBased){
            String[][] newData = new String[listOfCompetitors.size()][7];
            for (int i=0; i<listOfCompetitors.size(); i++){
                newData[i][0] = ""+listOfCompetitors.get(i).indexInDataBase;
                newData[i][1] = ""+listOfCompetitors.get(i).getID();
                newData[i][2] = ""+listOfCompetitors.get(i).name;
                newData[i][3] = ""+listOfCompetitors.get(i).major;
                newData[i][4] = ""+((TeamMemberCompetitor)listOfCompetitors.get(i)).teamNumber;
                newData[i][5] = ""+((TeamMemberCompetitor)listOfCompetitors.get(i)).teamName;
                newData[i][6] = ""+((TeamMemberCompetitor)listOfCompetitors.get(i)).teamRank;
            }
            return newData;
        }else {
            String[][] newData = new String[this.listOfCompetitors.size()][5];
            for (int i=0; i<this.listOfCompetitors.size(); i++){
                newData[i][0] = ""+listOfCompetitors.get(i).indexInDataBase;
                newData[i][1] = ""+listOfCompetitors.get(i).getID();
                newData[i][2] = ""+listOfCompetitors.get(i).name;
                newData[i][3] = ""+listOfCompetitors.get(i).major;
                newData[i][4] = ""+listOfCompetitors.get(i).rank;
            }
            return newData;
        }
    }

    @Override
    public String toString(){
        return "Name: "+nameOfCompetition+"\n" +
                "Date: "+date+"\n" +
                "Website link: "+link;
    }
}
