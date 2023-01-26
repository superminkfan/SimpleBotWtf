package com.web.mapper;


import com.web.model.Record;
import com.web.model.RecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecordToDtoMapper {
    Record AddBookRequestToBook(RecordRequest recordRequest);
    Record EditBookRequestToBook(Long id, RecordRequest recordRequest);
}