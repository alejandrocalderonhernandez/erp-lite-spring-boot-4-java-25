package com.debuggeandoideas.erp_lite.persistence.mongo.adapters;

import com.debuggeandoideas.erp_lite.domain.ports.repositories.ProductCatalogRepositoryPort;
import com.debuggeandoideas.erp_lite.domain.views.ProductView;
import com.debuggeandoideas.erp_lite.persistence.mongo.mappers.ProductCatalogMapper;
import com.debuggeandoideas.erp_lite.persistence.mongo.repositories.ProductInCatalogRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@AllArgsConstructor
public class ProductCatalogRepositoryAdapter implements ProductCatalogRepositoryPort {

    private final ProductInCatalogRepository productInCatalogRepository;
    private final ProductCatalogMapper productCatalogMapper;

    @Override
    public Optional<ProductView> findById(String id) {
        log.info("Find product by id: {}", id);

        return this.productInCatalogRepository.findById(id)
                .map(productCatalogMapper::toView);
    }

    @Override
    public Optional<ProductView> findBySku(String sku) {
        log.info("Find product by sku: {}", sku);

        return this.productInCatalogRepository.findBySku(sku)
                .map(productCatalogMapper::toView);
    }

    @Override
    public List<ProductView> findByText(String text) {
        log.info("Find product by text: {}", text);

        return this.productInCatalogRepository.findByTextAndActive(text)
                .stream().map(productCatalogMapper::toView)
                .toList();
    }

    @Override
    public List<ProductView> findByCategory(String category) {
        log.info("Find product by category: {}", category);

        return this.productInCatalogRepository.findByCategoryIdAndActiveTrue(category)
                .stream().map(productCatalogMapper::toView)
                .toList();
    }

    @Override
    public List<ProductView> findActive() {
        log.info("Find product active ");

        return this.productInCatalogRepository.findByActiveTrueOrderByIdAsc()
                .stream().map(productCatalogMapper::toView)
                .toList();
    }
}
