package org.example;

import java.util.List;

import org.example.model.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.templates.PlayerJDBCTemplate;

public class PlayerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        PlayerJDBCTemplate playerJDBCTemplate = (PlayerJDBCTemplate)context.getBean("playerJDBCTemplate");

        System.out.println("------Records Creation--------" );
        playerJDBCTemplate.create("Steph", "Curry");
        playerJDBCTemplate.create("Klay", "Thompson");
        playerJDBCTemplate.create("Draymond", "Green");

        System.out.println("------Listing Multiple Records--------" );
        List<Player> students = playerJDBCTemplate.listPlayers();

        for (Player record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Firstname : " + record.getFirstname() );
            System.out.println(", Lastname : " + record.getLastname());
        }

        System.out.println("----Updating Record with ID = 2 -----" );
        playerJDBCTemplate.update(5, "Chicago");

        System.out.println("----Listing Record with ID = 2 -----" );
        Player student = playerJDBCTemplate.getPlayer(2);
        System.out.print("ID : " + student.getId() );
        System.out.print(", Firstname : " + student.getLastname() );
        System.out.println(", Lastname : " + student.getLastname());
    }
}
