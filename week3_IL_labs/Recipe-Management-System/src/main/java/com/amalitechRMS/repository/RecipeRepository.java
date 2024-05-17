package com.amalitechRMS.repository;

import com.amalitechRMS.model.Recipe;
import com.amalitechRMS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByOwnerAndId(User owner, Long id);
}

