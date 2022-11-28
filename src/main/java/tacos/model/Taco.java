package tacos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Entity
public class Taco {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(min = 3, message = "Name mast be at least 3 characters long")
  private String name;

  private Date createAt = new Date();


  @Size(min = 1, message = "You mast choose at least 1 ingredient")
  @ManyToMany
  private List<Ingredient>ingredients =new ArrayList<>();

  public void addIngredient(Ingredient ingredient){
    this.ingredients.add(ingredient);
  }

}
