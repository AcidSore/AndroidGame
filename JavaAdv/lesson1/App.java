package ru.bukova.se;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Course TestCourse = new Course("IrishaCourse");// course created
        Team  team1  = new Team("Test","player 1","player 2","player 3","player 4");
        TestCourse.DoCourse("IrishaCourse");
        team1.members[2].Pass();
        team1.members[3].Pass();
        team1.ShowPassedResults();
        team1.ShowTeamResults();
    }
}
