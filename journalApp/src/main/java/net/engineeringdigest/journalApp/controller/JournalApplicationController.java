//package net.engineeringdigest.journalApp.controller;
//
//
//import net.engineeringdigest.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("_/journal")
//public class JournalApplicationController {
//
//
//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll()
//    {
//            return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public  boolean create(@RequestBody JournalEntry myEntry)
//    {
//        journalEntries.put(myEntry.getId(),myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalbyId(@PathVariable Long myId)
//    {
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournalById(@PathVariable long myId)
//    {
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{myId}")
//    public JournalEntry updateJournalEntryById(@PathVariable long myId,@RequestBody JournalEntry newEntry)
//    {
//        return journalEntries.put(myId,newEntry);
//    }
//}
