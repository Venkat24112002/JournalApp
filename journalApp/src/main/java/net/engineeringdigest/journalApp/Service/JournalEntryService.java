package net.engineeringdigest.journalApp.Service;


import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JounralEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JounralEntryRepository jounralEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry jounrnalEntry, String userName)
    {
        try {
            User user = userService.findByUserName(userName);
            jounrnalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = jounralEntryRepository.save(jounrnalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);
        }
        catch (Exception e)
        {
            System.out.println(e);
            throw new RuntimeException("An error occured in saving",e);
        }
    }

    public  void saveEntry(JournalEntry journalEntry)
    {
        jounralEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll()
    {
        return jounralEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id)
    {
        return jounralEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id,String userName)
    {
        try{
            User user = userService.findByUserName(userName);
            boolean removed = user.getJournalEntries().removeIf(x-> x.getId().equals(id));
            if(removed) {
                userService.saveUser(user);
                jounralEntryRepository.deleteById(id);
            }
            return removed;
        }
        catch (Exception e){
            throw new RuntimeException("An error occured while deleting the entry",e);
        }
    }
}


//controller-->service-->Repository