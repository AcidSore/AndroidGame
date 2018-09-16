package ru.bukova.se;

public class Team {
    String TeamName;
    Member [] members = new Member [4];

    public Team(String Name){
        TeamName = Name;

    }
    public Team(String Name, String member1, String member2, String member3, String member4){
        TeamName = Name;
        members[0] = new Member(member1);
        members[1] = new Member(member2);
        members[2] = new Member(member3);
        members[3] = new Member(member4);
    }

    public void ShowTeamResults(){
        for (int i =0;i<4;i++){
            System.out.println(members[i].Name);
            System.out.println(members[i].isPassed);
        }
    }

    public void ShowPassedResults(){
        for (int i =0;i<4;i++){
            if (members[i].isPassed) {
                System.out.println(members[i].Name);
            }
        }
    }

}
