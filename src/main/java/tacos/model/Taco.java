package tacos.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;



@Data
@Table("tacos")
public class Taco {
  @PrimaryKeyColumn(type= PrimaryKeyType.PARTITIONED)
  private UUID id = Uuids.timeBased();

  @NotNull
  @Size(min = 3, message = "Name mast be at least 3 characters long")
  private String name;

  @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
  private Date createAt = new Date();

  @Size(min = 1, message = "You mast choose at least 1 ingredient")
  @Column("ingredients")
  private List<IngredientUDT>ingredients =new ArrayList<>();

  public void addIngredient(Ingredient ingredient) {
    this.ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient));
  }

}
