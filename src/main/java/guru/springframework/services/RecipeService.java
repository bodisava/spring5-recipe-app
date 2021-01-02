package guru.springframework.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;

@Service
public class RecipeService {

	private final RecipeRepository recipeRepository;
	
	public RecipeService(RecipeRepository recipeRepository) {
		super();
		this.recipeRepository = recipeRepository;
	}

	public List<Recipe> getAllRecipes() {
		Iterable<Recipe> iter = recipeRepository.findAll();
		List<Recipe> lista = new ArrayList<>();
		iter.forEach(lista::add);
		return lista;
	}
}
