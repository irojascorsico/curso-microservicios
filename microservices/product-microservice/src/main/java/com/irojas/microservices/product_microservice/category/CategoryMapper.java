package com.irojas.microservices.product_microservice.category;
import org.springframework.stereotype.Service;
import com.irojas.microservices.product_microservice.product.ProductResponse;

@Service
public class CategoryMapper {

    public Category toCategory(CategoryRequest request) {
       return  Category.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category) {
       return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getProducts().stream()
                        .map(product -> new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getPrice(),
                                product.getStock(),
                                product.getImageUrl(),
                                product.getCategory().getId(),
                                product.getCategory().getName(),
                                product.getCategory().getDescription(
                        )))
                        .toList()
        );
    }
}
