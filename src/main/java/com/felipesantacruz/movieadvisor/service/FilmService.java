package com.felipesantacruz.movieadvisor.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipesantacruz.movieadvisor.dao.FilmDao;
import com.felipesantacruz.movieadvisor.model.Film;

@Service
public class FilmService
{
	@Autowired
	FilmDao filmDao;
	
	@Autowired
	FilmQueryService queryService;
	
	public Collection<String> findAllGenres()
	{
		List<String> result = null;
		
		// @formatter:off
		result =  filmDao.findAll()
					.stream()
					.map(f -> f.getGenres())
					.flatMap(list -> list.stream())
					.distinct()
					.sorted()
					.collect(Collectors.toList());
		// @formatter:on
		return result;
	}
	
	public Collection<Film> findAll()
	{
		return filmDao.findAll();
	}
	
	public Collection<Film> findByAnyGenre(String... genres)
	{
		return queryService.anyGenre(genres).exec();
	}
	
	public Collection<Film> findByAllGenre(String... genres)
	{
		return queryService.allGenres(genres).exec();
	}
	
	public Collection<Film> findByYear(String year)
	{
		return queryService.year(year).exec();
	}
	
	public Collection<Film> findBetweenYears(String from, String to)
	{
		return queryService.betweenYears(from, to).exec();
	}
	
	public Collection<Film> findByTitleContains(String title)
	{
		return queryService.titleContains(title).exec();
	}
}
