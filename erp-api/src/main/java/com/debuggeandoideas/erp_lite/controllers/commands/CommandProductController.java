package com.debuggeandoideas.erp_lite.controllers.commands;

import com.debuggeandoideas.erp_lite.dtos.BaseResponseWrapper;
import com.debuggeandoideas.erp_lite.paths.ApiPaths;
import com.debuggeandoideas.erp_lite.use_cases.product.CreateProductUseCase;
import com.debuggeandoideas.erp_lite.use_cases.product.DeactivateProductUseCase;
import com.debuggeandoideas.erp_lite.use_cases.product.UpdateProductUseCase;
import com.debuggeandoideas.erp_lite.use_cases.product.UpdateStockUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiPaths.COMMANDS_PRODUCTS)
@RequiredArgsConstructor
public class CommandProductController {

    private final CreateProductUseCase createProductUseCase;
    private final DeactivateProductUseCase deactivateProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final UpdateStockUseCase updateStockUseCase;

    public ResponseEntity<BaseResponseWrapper<String>> postOrder()


}
