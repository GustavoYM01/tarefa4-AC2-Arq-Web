package com.example.tarefa4.models.Converter;

import java.time.LocalTime;

import jakarta.persistence.AttributeConverter;

public class DateLocalTime implements AttributeConverter<LocalTime, String> {
  @Override
  public String convertToDatabaseColumn(LocalTime lt) {
    return lt.toString();
  }

  @Override
  public LocalTime convertToEntityAttribute(String ts) {
    return LocalTime.parse(ts);
  }
}
