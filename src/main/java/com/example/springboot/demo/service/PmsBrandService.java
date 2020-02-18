package com.example.springboot.demo.service;

import com.example.springboot.demo.mbg.model.PmsBrand;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PmsBrandService {

    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}

