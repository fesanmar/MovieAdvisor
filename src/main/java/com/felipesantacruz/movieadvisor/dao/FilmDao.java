package com.felipesantacruz.movieadvisor.dao;

import java.util.Collection;

import com.felipesantacruz.movieadvisor.model.Film;

public interface FilmDao
{
	Film findById(long id);
	
	Collection<Film> findAll();
	
	void insert(Film film);
	
	void edit(Film film);
	
	void delete(long id);
}
