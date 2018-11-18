package com.roberto.cotaeasy.business.converter;

public interface Converter<T, U> {
    T toEntity(U dto);
    U toDto(T entity);
}
