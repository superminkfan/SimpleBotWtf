package com.web.service;

import com.web.model.Record;

import java.util.List;

public interface RecordService {
    Record getRecordById(Long id);
    List<Record> getAllRecords();
    List<Record> findByChatId(String author);
    void addRecord(Record record);
    void editRecord(Record record);
}