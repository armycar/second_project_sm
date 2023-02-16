package com.readers.be3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.readers.be3.entity.ArticleInfoEntity;

public interface ArticleInfoRepository extends JpaRepository<ArticleInfoEntity, Long>{
    // public Page<ArticleInfoEntity> findByKeywordContains(String keyword, Pageable pageable);
    // 게시글 전체 리스트 조회
    public Page<ArticleInfoEntity> findAll(Pageable pageable);

    // 제목으로 게시글 검색
    public Page<ArticleInfoEntity> findByAiTitleContains(String keyword, Pageable pageable);
    // 내용으로 게시글 검색
    public Page<ArticleInfoEntity> findByAiContentContains(String keyword, Pageable pageable);
    // 작성자로 게시글 검색
    public Page<ArticleInfoEntity> findByAiUiSeq(Long uiSeq, Pageable pageable);

    // public Page<ArticleInfoEntity> findByiUiSeqContains(String keyword, Pageable pageable);
    // public Page<ArticleInfoEntity> findByAiTitleContains(String keyword, Pageable pageable);

}
