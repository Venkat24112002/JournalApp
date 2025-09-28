package net.engineeringdigest.journalApp.scheduler;

import net.engineeringdigest.journalApp.Service.EmailService;
import net.engineeringdigest.journalApp.entity.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class UserScheduler {
    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    public void fetchUsersAndSaMail() {

    }

}
