package com.web.service;

import com.web.dao.RecordEntity;
import com.web.dao.RecordRepository;
import com.web.exception.RecordNotFoundException;
import com.web.mapper.RecordToEntityMapper;
import com.web.model.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DefaultRecordService implements RecordService {
    private final RecordRepository recordRepository;
    private final RecordToEntityMapper mapper;

    @Override
    public Record getRecordById(Long id) {
        RecordEntity RecordEntity = recordRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Record not found: id = " + id));

        return mapper.recordEntityToBook(RecordEntity);
    }

    @Override
    public List<Record> getAllRecords() {
        Iterable<RecordEntity> iterable = recordRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::recordEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public List<Record> findByChatId(String username) {
        Iterable<RecordEntity> iterable = recordRepository.findAllByUsernameContaining(username);
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(mapper::recordEntityToBook)
                .collect(Collectors.toList());
    }

    @Override
    public void addRecord(Record record) {
        RecordEntity RecordEntity = mapper.recordToBookEntity(record);
        recordRepository.save(RecordEntity);
    }

    @Override
    public void editRecord(Record record) {
        if (!recordRepository.existsById(record.getId()))
            throw new RecordNotFoundException("Record not found: id = " + record.getId());

        RecordEntity recordEntity = mapper.recordToBookEntity(record);
        recordRepository.save(recordEntity);

    }
}
