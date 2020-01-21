package com.zhuravlov.bugtracker.rest.config;

import com.zhuravlov.bugtracker.rest.model.MessageEntity;
import com.zhuravlov.bugtracker.rest.model.TicketEntity;
import com.zhuravlov.bugtracker.rest.model.UserEntity;
import com.zhuravlov.bugtracker.rest.repository.MessageRepository;
import com.zhuravlov.bugtracker.rest.repository.RoleRepository;
import com.zhuravlov.bugtracker.rest.repository.TicketRepository;
import com.zhuravlov.bugtracker.rest.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class TestUsers implements InitializingBean {

    @Autowired
    private UserService userService;


    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        roleRepository.createRoleIfNotFound("ROLE_ADMIN");
        roleRepository.createRoleIfNotFound("ROLE_USER");
        roleRepository.createRoleIfNotFound("ROLE_BOSS");


        UserEntity admin = new UserEntity("Alex", "Zhuravlov", "alexzhuravlov13@gmail.com", "111111");

        UserEntity bigBoss = new UserEntity("Big", "Boss", "BigBoss@email.com", "111111");


        UserEntity usualEmployee = new UserEntity("Usual", "Employee", "employee@email.com", "111111");

        userService.addUser(bigBoss);
        bigBoss.setRoles(new ArrayList<>(Arrays.asList(roleRepository.findByName("ROLE_USER"), roleRepository.findByName("ROLE_BOSS"))));

        userService.addUser(admin);
        admin.setRoles(new ArrayList<>(Arrays.asList(roleRepository.findByName("ROLE_USER"), roleRepository.findByName("ROLE_ADMIN"))));

        userService.updateUser(bigBoss);
        userService.updateUser(admin);

        userService.addUser(usualEmployee);

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreator(bigBoss);
        ticketEntity.setHolder(usualEmployee);
        ticketEntity.setTitle("Test");

        ticketRepository.save(ticketEntity);

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setText("TEEEEEEEEEEEEEEST");
        messageEntity.setAuthor(bigBoss);
        messageEntity.setRecipient(usualEmployee);
        messageEntity.setTicket(ticketEntity);

        messageRepository.save(messageEntity);

    }
}
