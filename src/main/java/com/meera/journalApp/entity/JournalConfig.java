package com.meera.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "config_journal_app")
@Data
@NoArgsConstructor
public class JournalConfig {
    private String key;
    private String value;
}
