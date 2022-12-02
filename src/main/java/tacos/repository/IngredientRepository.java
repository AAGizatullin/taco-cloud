package tacos.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tacos.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,String> {

//  Iterable<Ingredient>findAll();
//
//  Optional<Ingredient> findById(String id);
//
//  Ingredient save(Ingredient ingredient);
}
