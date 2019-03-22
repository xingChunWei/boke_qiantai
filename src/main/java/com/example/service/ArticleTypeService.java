package com.example.service;

import com.example.entity.ArticleTypes;

import java.util.List;

public interface ArticleTypeService {

    List<ArticleTypes> findAll(ArticleTypes types);

}
