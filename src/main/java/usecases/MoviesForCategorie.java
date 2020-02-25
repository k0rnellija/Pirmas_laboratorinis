package usecases;

import entities.Category;
import lombok.Getter;
import lombok.Setter;
import persistence.CategoriesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class MoviesForCategorie implements Serializable {

    @Inject
    private CategoriesDAO categoriesDAO;

    @Getter
    @Setter
    private Category category;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer categoryId = Integer.parseInt(requestParameters.get("categoryId"));
        this.category = categoriesDAO.findOne(categoryId);
    }
}
