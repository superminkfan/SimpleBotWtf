package com.web.mapper;


import com.web.dao.RecordEntity;
import com.web.model.Record;
import com.web.model.RecordRequest;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface RecordToEntityMapper {
    RecordEntity recordToBookEntity(Record book);
    Record recordEntityToBook(RecordEntity bookEntity);
}