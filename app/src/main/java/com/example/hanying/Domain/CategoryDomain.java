package com.example.hanying.Domain;

public class CategoryDomain {
    private String categoryName;
    private String categoryPic;

    public CategoryDomain(String categoryName, String categoryPic) {
        this.categoryName = categoryName;
        this.categoryPic = categoryPic;
    }

    public String getName() {
        return categoryName;
    }
    public void setName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getPic() {
        return categoryPic;
    }
    public void setPic(String categoryPic) {
        this.categoryPic = categoryPic;
    }
}
