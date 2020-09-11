package com.example.gadsleaderboard;

public class UserResponse {
    /*{
        "emailAdress":"String",
        "name":"String",
            "lastName":"String",
            "linkToProject":"String",
    }*/

    private String emailAdress;
    private String name;
    private String lastName;
    private String linkToProject;

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLinkToProject() {
        return linkToProject;
    }

    public void setLinkToProject(String linkToProject) {
        this.linkToProject = linkToProject;
    }
}