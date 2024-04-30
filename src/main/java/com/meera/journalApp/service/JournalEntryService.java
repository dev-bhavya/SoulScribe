package com.meera.journalApp.service;

import com.meera.journalApp.entity.JournalEntry;
import com.meera.journalApp.entity.User;
import com.meera.journalApp.repository.JournalEntryRepo;
import com.meera.journalApp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    public List<JournalEntry> findAll() {
        return journalEntryRepo.findAll();
    }

    @Transactional
    public void save(JournalEntry journalEntry, String username) {
        try {
            journalEntry.setDate(LocalDateTime.now());
            User user = userService.findByUsername(username);
            JournalEntry saved = journalEntryRepo.save(journalEntry);
            user.getJournalEntries().add(saved);
            System.out.println("Entry saved with id: " + saved.getId());
            userService.saveUser(user);
        } catch (Exception ex) {
            log.error("User not found: {}", username);
            throw new RuntimeException();
        }
    }

    public void save(JournalEntry journalEntry) {
        journalEntryRepo.save(journalEntry);
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepo.findById(id);
    }

    public boolean deleteById(ObjectId id, String username) {
        boolean removed = false;
        try {
            User user = userService.findByUsername(username);
            removed = user.getJournalEntries().removeIf(x -> journalEntryRepo.existsById(id));
            if(removed) {
                userService.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error while deleting entry", e);
        }
        return removed;
    }

    public List<JournalEntry> entries(String username) {
        User user = userRepo.findByUsername(username);
        return user.getJournalEntries();
    }
}
