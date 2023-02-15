package com.readers.be3.dto.response;

import java.time.LocalDateTime;

import com.readers.be3.entity.OneCommentEntity;
import com.readers.be3.entity.UserInfoEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Schema(description = "한줄평VO")
public class OneCommentResponse {
  @Schema(description = "한줄평 내용")
  private String comment;
  @Schema(description = "한줄평 내용")
  private Integer score;
  private LocalDateTime regDt;
  private String nickName;

  public static OneCommentResponse toResponse(OneCommentEntity entity){
    return new OneCommentResponse(entity.getOcComment(),
                                  entity.getOcScore(),
                                  entity.getOcRegDt(),
                                  entity.getUserInfoEntity().getUiNickname());
  }
}