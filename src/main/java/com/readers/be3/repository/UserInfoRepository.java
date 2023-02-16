package com.readers.be3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.readers.be3.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long>{
  public Integer countByUiEmail(String uiEmail);
  public Integer countByUiNickname(String uiNickname);
  public UserInfoEntity findTop1ByUiEmailAndUiPwd(String uiEmail, String uiPwd);
  public UserInfoEntity findByUiSeq(Long uiSeq);
  public Page<UserInfoEntity> findAll(Pageable pageable);
  
  // 아이디로 유저 정보 찾기 (유저아이디로 게시글 검색을 위해서 만듦)
  public UserInfoEntity findByUiEmail(String email);

}
