package usecases;

import entities.Category;
import lombok.Getter;
import lombok.Setter;
import persistence.CategoriesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Categories {

    @Inject
    private CategoriesDAO categoriesDAO;

    @Getter    @Setter
    private Category categoryToCreate = new Category();

    @Getter
    private List<Category> allCategories;

    @PostConstruct
    public void init(){
        loadAllCategories();
    }

    @Transactional
    public String createCategory(){
        this.categoriesDAO.persist(categoryToCreate);
        return "success";
    }

    private void loadAllCategories(){
        this.allCategories = categoriesDAO.getAllCategories();
    }
}
