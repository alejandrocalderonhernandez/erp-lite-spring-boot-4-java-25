package com.debuggeandoideas.erp_lite.persistence.mongo.adapters;

import com.debuggeandoideas.erp_lite.domain.ports.repositories.CatalogRepositoryPort;
import com.debuggeandoideas.erp_lite.domain.views.CatalogView;
import com.debuggeandoideas.erp_lite.domain.views.ItemsView;
import com.debuggeandoideas.erp_lite.enums.CatalogType;
import com.debuggeandoideas.erp_lite.persistence.mongo.mappers.CatalogMapper;
import com.debuggeandoideas.erp_lite.persistence.mongo.repositories.CatalogRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@AllArgsConstructor
public class CatalogRepositoryAdapter implements CatalogRepositoryPort {

    private final CatalogRepository catalogRepository;
    private final CatalogMapper catalogMapper;

    @Override
    public Optional<CatalogView> findByType(CatalogType type) {
        log.info("Find catalog by type: {}", type);
        return catalogRepository.findByCatalogType(type)
                .map(catalogMapper::toView);
    }

    @Override
    public List<ItemsView> findItemsByType(CatalogType type) {
        log.info("Find items catalog by type: {}", type);

        return catalogRepository.findByCatalogType(type)
                .map(doc -> doc.getItems()
                        .stream()
                        .map(catalogMapper::toItemView)
                        .toList())
                .orElse(List.of());
    }

    @Override
    public Optional<ItemsView> findItemByTypeAndCode(CatalogType type, String code) {
        log.info("Find items catalog by type: {} & code: {}", type, code);

        return catalogRepository.findByCatalogType(type)
                .flatMap(doc -> doc.getItems()
                        .stream()
                        .filter(item -> item.code().equals(code))
                        .findFirst()
                        .map(catalogMapper::toItemView));
    }

}