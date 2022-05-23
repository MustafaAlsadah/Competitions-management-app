package com.Alsadah;


import java.io.Serializable;

public class TeamMemberCompetitor extends Competitor implements Serializable {
    String teamName;
    int teamNumber;
    String teamRank;
    String major;

    public TeamMemberCompetitor(String name, String ID, String major, int indexInDataBase, String teamRank, String teamName, int teamNumber){
        super(name, ID, major, indexInDataBase, teamRank);
        this.teamName = teamName;
        this.teamNumber = teamNumber;
        this.teamRank = teamRank;
        this.major=major;
    }

    @Override
    public void setID(String ID) {
        super.setID(ID);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamRank(String teamRank) {
        this.teamRank = teamRank;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getID() {
        return super.getID();
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamRank() {
        return teamRank;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString(){
        return super.toString()+"\nTeam number: "+this.teamNumber+"\nTeam name: "+this.teamName;
    }
}
