package com.example.ClinicaV2.repository;


public interface Dao <T>{

    public T add(T t);

    public void remove(Long id);

    public T update(T t, Long id);

    public void search(Long id);

    public void serachAll();


}
