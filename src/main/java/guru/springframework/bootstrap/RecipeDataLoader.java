package guru.springframework.bootstrap;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.domain.Category;
import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Notes;
import guru.springframework.domain.Recipe;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;

@Component
public class RecipeDataLoader implements CommandLineRunner{
	
	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	
	public RecipeDataLoader(CategoryRepository categoryRepository, 
			RecipeRepository recipeRepository,
			UnitOfMeasureRepository unitOfMeasureRepository) {
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if (recipeRepository.count() == 0) {
			loadData();
		}
	}
	
	@Transactional
	private void loadData() {
		Category catMexican = categoryRepository.findByDescription("Mexican").get();
		Category catAmerican = categoryRepository.findByDescription("American").get();
//		INSERT INTO unit_of_measure (description) VALUES ('Teaspoon');
//		INSERT INTO unit_of_measure (description) VALUES ('Tablespoon');
//		INSERT INTO unit_of_measure (description) VALUES ('Cup');
//		INSERT INTO unit_of_measure (description) VALUES ('Pinch');
//		INSERT INTO unit_of_measure (description) VALUES ('Ounce');
//		INSERT INTO unit_of_measure (description) VALUES ('Dash');
//		INSERT INTO unit_of_measure (description) VALUES ('Unit');
		UnitOfMeasure uomTeaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
		UnitOfMeasure uomTablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
		UnitOfMeasure uomDash = unitOfMeasureRepository.findByDescription("Dash").get();
		UnitOfMeasure uomUnit = unitOfMeasureRepository.findByDescription("Unit").get();
		UnitOfMeasure uomPinch = unitOfMeasureRepository.findByDescription("Pinch").get();
		UnitOfMeasure uomOunce = unitOfMeasureRepository.findByDescription("Ounce").get();
//		UnitOfMeasure uom = unitOfMeasureRepository.findByDescription("").get();
		
		////////////////// Guacamole /////////////////////
		Recipe recipeGuacamole = new Recipe();
		recipeGuacamole.setDescription("Perfect Guacamole");
		recipeGuacamole.setCategories(new HashSet<>(Arrays.asList(catMexican, catAmerican)));
		recipeGuacamole.setCookTime(0);
		recipeGuacamole.setDifficulty(Difficulty.EASY);
//		recipeGuacamole.setImage(image);
		recipeGuacamole.setPrepTime(10);
		recipeGuacamole.setServings(4);
		recipeGuacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
		recipeGuacamole.setSource("source guacamole");

		Notes notesGuacamole = new Notes();
		notesGuacamole.setRecipe(recipeGuacamole);
		notesGuacamole.setRecipeNotes("Be careful handling chiles if using. "
				+ "Wash your hands thoroughly after handling and do not touch your eyes "
				+ "or the area near your eyes with your hands for several hours.");
		recipeGuacamole.setNotes(notesGuacamole);
		
		recipeGuacamole.setDirections("1 Cut the avocado, remove flesh: ...." 
				+ "\r\n 2 Mash with a fork: ..."
				+ "\r\n 3 Add salt, lime juice, and the rest: ...");

		Ingredient ingGuacamole = new Ingredient();
		ingGuacamole.setAmount(new BigDecimal(2));
		ingGuacamole.setDescription("Ripe Avocados");
		ingGuacamole.setUom(uomUnit);
		ingGuacamole.setRecipe(recipeGuacamole);
		recipeGuacamole.getIngredients().add(ingGuacamole);
		
		ingGuacamole = new Ingredient();
		ingGuacamole.setAmount(new BigDecimal(0.25));
		ingGuacamole.setDescription("salt");
		ingGuacamole.setUom(uomTeaspoon);
		ingGuacamole.setRecipe(recipeGuacamole);
		recipeGuacamole.getIngredients().add(ingGuacamole);
		
		ingGuacamole = new Ingredient();
		ingGuacamole.setAmount(new BigDecimal(1));
		ingGuacamole.setDescription("fresh lime juice or lemon juice");
		ingGuacamole.setUom(uomTablespoon);
		ingGuacamole.setRecipe(recipeGuacamole);
		recipeGuacamole.getIngredients().add(ingGuacamole);
		
		ingGuacamole = new Ingredient();
		ingGuacamole.setAmount(new BigDecimal(2));
		ingGuacamole.setDescription("minced red onion or thinly sliced green onion");
		ingGuacamole.setUom(uomTablespoon);
		ingGuacamole.setRecipe(recipeGuacamole);
		recipeGuacamole.getIngredients().add(ingGuacamole);
		
		ingGuacamole = new Ingredient();
		ingGuacamole.setAmount(new BigDecimal(2));
		ingGuacamole.setDescription("serrano chiles, stems and seeds removed, minced");
		ingGuacamole.setUom(uomUnit);
		ingGuacamole.setRecipe(recipeGuacamole);
		recipeGuacamole.getIngredients().add(ingGuacamole);
		
		recipeRepository.save(recipeGuacamole);

		////////////////// Chicken /////////////////////
		Recipe recipeChicken = new Recipe();
		recipeChicken.setDescription("Spicy Grilled Chicken Tacos");
		recipeChicken.setCategories(new HashSet<>(Arrays.asList(catMexican, catAmerican)));
		recipeChicken.setCookTime(15);
		recipeChicken.setDifficulty(Difficulty.MODERATE);
//		recipeChicken.setImage(image);
		recipeChicken.setPrepTime(20);
		recipeChicken.setServings(6);
		recipeChicken.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
		recipeChicken.setSource("source Chicken");

		Notes notesChicken = new Notes();
		notesChicken.setRecipe(recipeChicken);
		notesChicken.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, "
				+ "on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, "
				+ "the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, "
				+ "though the flavor won't be quite the same.)");
		recipeChicken.setNotes(notesChicken);
		
		recipeChicken.setDirections("1 Prepare a gas or charcoal grill." 
				+ "\r\n 2 Make the marinade and coat the chicken: ..."
				+ "\r\n 3 Grill the chicken: ...");

		Ingredient ingChicken = new Ingredient();
		ingChicken.setAmount(new BigDecimal(2));
		ingChicken.setDescription("ancho chili powder");
		ingChicken.setUom(uomTablespoon);
		ingChicken.setRecipe(recipeChicken);
		recipeChicken.getIngredients().add(ingChicken);
		
		ingChicken = new Ingredient();
		ingChicken.setAmount(new BigDecimal(1));
		ingChicken.setDescription("dried oregano");
		ingChicken.setUom(uomTeaspoon);
		ingChicken.setRecipe(recipeChicken);
		recipeChicken.getIngredients().add(ingChicken);
		
		ingChicken = new Ingredient();
		ingChicken.setAmount(new BigDecimal(1));
		ingChicken.setDescription("dried cumin");
		ingChicken.setUom(uomTeaspoon);
		ingChicken.setRecipe(recipeChicken);
		recipeChicken.getIngredients().add(ingChicken);
		
		ingChicken = new Ingredient();
		ingChicken.setAmount(new BigDecimal(6));
		ingChicken.setDescription("skinless, boneless chicken thighs");
		ingChicken.setUom(uomUnit);
		ingChicken.setRecipe(recipeChicken);
		recipeChicken.getIngredients().add(ingChicken);
		
		ingChicken = new Ingredient();
		ingChicken.setAmount(new BigDecimal(2));
		ingChicken.setDescription("olive oil");
		ingChicken.setUom(uomTablespoon);
		ingChicken.setRecipe(recipeChicken);
		recipeChicken.getIngredients().add(ingChicken);
	
		recipeRepository.save(recipeChicken);

	}

}
